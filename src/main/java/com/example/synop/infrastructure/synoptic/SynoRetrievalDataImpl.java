package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticRetrievalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SynoRetrievalDataImpl implements SynopticRetrievalData {

    private final SynopticRepository synoRepository;

    @Override
    public List<Synoptic> filterByCisnienie(Double cisnienie) {
        return synoRepository.findByCisnienieGreaterThanEqual(cisnienie);
    }
}
