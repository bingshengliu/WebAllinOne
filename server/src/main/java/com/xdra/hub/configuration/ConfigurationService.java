package com.xdra.hub.configuration;

import com.xdra.hub.entity.ClusterEntity;
import com.xdra.hub.entity.ContainerEntity;
import com.xdra.hub.model.Cluster;
import com.xdra.hub.model.Container;
import com.xdra.hub.model.SystemConfiguration;
import com.xdra.hub.repository.ContainerRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigurationService {

    private final ContainerRepository containerRepository;
    @Getter
    private volatile SystemConfiguration systemConfiguration;

    @Value("${config.pack.type}")
    private SystemConfiguration.PackTypeEnum packType;

    @PostConstruct
    public void init() {
        // refresh system configuration periodically
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this::loadSystemConfiguration, 0, 3, TimeUnit.MINUTES);
    }

    private void loadSystemConfiguration() {
        SystemConfiguration systemConfiguration = new SystemConfiguration();
        List<ContainerEntity> containers = containerRepository.findAll();
        for (ContainerEntity container : containers) {
            Container containerModel = new Container();
            containerModel.setId(String.valueOf(container.getId()));

            for (ClusterEntity cluster : container.getClusters()) {
                Cluster clusterModel = new Cluster();
                clusterModel.setId(String.valueOf(cluster.getId()));
                clusterModel.setPacks(cluster.getPacks().stream().map(pack -> String.valueOf(pack.getId())).toList());
                containerModel.addClustersItem(clusterModel);
            }

            systemConfiguration.addContainersItem(containerModel);
        }
        systemConfiguration.setPackType(packType);
        this.systemConfiguration = systemConfiguration;
        log.info("system configuration loaded {}", systemConfiguration);
    }

    public List<String> getPackIds(String containerId, String clusterId) {
        return systemConfiguration.getContainers().stream()
                .filter(container -> container.getId().equals(containerId))
                .flatMap(container -> container.getClusters().stream())
                .filter(cluster -> cluster.getId().equals(clusterId))
                .findFirst()
                .map(Cluster::getPacks)
                .orElseThrow(() -> new IllegalArgumentException("containerId or clusterId not found"));
    }
}
