package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.SynopticRetrievalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SynoRetrievalDataImpl implements SynopticRetrievalData {

    private final SynopticRepository synopticRepository;

    @Override
    public Double pressureAverage() {
        List<Double> pressureList=synopticRepository.findByPressure();
        return pressureList.stream().mapToDouble(value->value).average().getAsDouble();
    }
}
