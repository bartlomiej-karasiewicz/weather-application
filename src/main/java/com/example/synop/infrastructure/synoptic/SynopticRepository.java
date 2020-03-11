package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SynopticRepository extends JpaRepository<Synoptic, Long> {

    List<Synoptic> findByCisnienieGreaterThanEqual(Double cisnienie);
}
