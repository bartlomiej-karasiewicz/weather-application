package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SynopticRepository extends JpaRepository<Synoptic, Long> {

    @Query(value = "select avg(s.pressure) from synoptic s",
            nativeQuery = true)
    Double findByPressure();

    @Query(value = "select avg(s.wind_speed) from synoptic s",
            nativeQuery = true)
    Double findByWindSpeed();

    @Query(value = "select * from synoptic s " +
            "where s.temperature is not null " +
            "and s.station is not null " +
            "and s.measure_date=current_date",
            nativeQuery = true)
    List<Synoptic> dataWithoutNulls();

    @Query(value = "select s.measure_date from synoptic s group by s.measure_date",
    nativeQuery = true)
    Date groupByTemperatureByMeasureDate();

}
