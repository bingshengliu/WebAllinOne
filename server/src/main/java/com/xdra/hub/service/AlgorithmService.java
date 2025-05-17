package com.xdra.hub.service;

import com.xdra.hub.entity.EisMeasurementEntity;
import com.xdra.hub.repository.EisMeasurementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlgorithmService {

    private final EisMeasurementRepository eisMeasurementRepository;

    @Value("${app.python.executable}")
    private String pythonExec;

    @Value("${app.python.scripts-dir}")
    private String scriptsDir;

    /** 最多等待 5 秒，每 300ms 检查一次 */
    private static final int MAX_WAIT_MS      = 5000;
    private static final int POLL_INTERVAL_MS = 300;

    /**
     * 异步触发 Python 脚本：等待刚刚写入的测量数据都落库后，再执行 transmit_data.py。
     * @param saved 本次批量写入并持久化的 EIS 测量记录
     */
    @Async("algoExecutor")
    public void computeAndTransmitAll(List<EisMeasurementEntity> saved) {
        try {
            log.info("[AlgorithmService] computeAndTransmitAll received {} records", saved.size());

            // 1) 收集所有 distinct creationTime（Instant 类型）
            Set<Instant> creationTimes = saved.stream()
                .map(EisMeasurementEntity::getCreationTime)
                .collect(Collectors.toSet());
            int expectedCount = saved.size();

            // 2) 轮询等待：直到数据库里这些时间戳对应的行数 >= expectedCount
            waitForAllMeasurements(creationTimes, expectedCount);

            // 3) 拼到脚本工作目录并执行 transmit_data.py（脚本内部会 load JSON、执行算法、再 POST 回后端）
            File script = new File(scriptsDir, "transmit_data.py");
            log.info("[AlgorithmService] launching {}", script.getAbsolutePath());

            ProcessBuilder pb = new ProcessBuilder(
                pythonExec,
                script.getAbsolutePath()
            )
            .directory(new File(scriptsDir))
            .redirectErrorStream(true);

            Process proc = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    log.info("[transmit_data.py] {}", line);
                }
            }

            int exitCode = proc.waitFor();
            if (exitCode != 0) {
                throw new IllegalStateException("transmit_data.py exited with code " + exitCode);
            }
            log.info("[AlgorithmService] transmit_data.py completed successfully");

        } catch (Exception ex) {
            log.error("[AlgorithmService] Exception while running transmit_data.py", ex);
        }
    }

    /**
     * 在 eis_measurement 表中轮询，直到指定 creationTimes 的行数达到 expectedCount 或超时。
     */
    private void waitForAllMeasurements(Set<Instant> creationTimes, int expectedCount)
            throws InterruptedException {
        int waited = 0;
        while (waited < MAX_WAIT_MS) {
            long actual = eisMeasurementRepository.countByCreationTimeIn(creationTimes);
            if (actual >= expectedCount) {
                log.info("[AlgorithmService] all {} measurements persisted", actual);
                return;
            }
            Thread.sleep(POLL_INTERVAL_MS);
            waited += POLL_INTERVAL_MS;
        }
        long finalCount = eisMeasurementRepository.countByCreationTimeIn(creationTimes);
        log.warn("[AlgorithmService] timeout waiting for measurements: persisted {}/{}",
                 finalCount, expectedCount);
    }
}
