package com.xdra.hub.repository;

import com.xdra.hub.analytics.StatsDto;
import com.xdra.hub.entity.EisMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EisMeasurementRepository extends JpaRepository<EisMeasurementEntity, Long> {

    // 既有：统计区间内的次数和测量总数
    @Query("""
      select new com.xdra.hub.analytics.StatsDto(
        count(distinct m.creationTime) as totalInspections,
        count(m) as totalMeasurements
      )
      from EisMeasurementEntity m
      where m.creationTime >= ?1 and m.creationTime < ?2
    """)
    StatsDto getStatsByCreationTimeBetween(Instant start, Instant end);

    // 既有：按区间拿所有行
    List<EisMeasurementEntity> findByCreationTimeBetween(Instant start, Instant end);

    // 既有：原生 SQL 拿最新一条
    @Query(value = "select * from eis_measurement order by creation_time desc limit 1",
           nativeQuery = true)
    Optional<EisMeasurementEntity> getLatestRecord();

    // 新增：统计一组 creationTime 对应的行数
    long countByCreationTimeIn(Collection<Instant> creationTimes);

}
