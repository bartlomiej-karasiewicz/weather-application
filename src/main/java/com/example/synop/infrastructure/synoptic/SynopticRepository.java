package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SynopticRepository extends JpaRepository<Synoptic, Long> {

    @Query(value = "select s.pressure from syno s where s.pressure is not null",
            nativeQuery = true)
    List<Double> findByPressure();

    @Query(value = "select s.wind_speed from syno s where s.wind_speed is not null",
            nativeQuery = true)
    List<Double> findByWindSpeed();

    @Query(value = "select * from syno s where s.temperature is not null and s.station is not null",
            nativeQuery = true)
    List<Synoptic> withoutNulls();
}
