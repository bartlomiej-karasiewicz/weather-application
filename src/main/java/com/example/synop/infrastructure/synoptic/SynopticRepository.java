package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SynopticRepository extends JpaRepository<Synoptic, Long> {

    @Query(value = "select s.pressure from syno s where s.pressure is not null", nativeQuery = true)
    List<Double> findByPressure();
}
