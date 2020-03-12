package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.SynopticRetrievalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SynopticRetrievalDataImpl implements SynopticRetrievalData {

    private final SynopticRepository synopticRepository;

    @Override
    public Double pressureAverage() {
        List<Double> pressureList=synopticRepository.findByPressure();
        return pressureList.stream()
                .mapToDouble(value->value)
                .average()
                .getAsDouble();
    }

    @Override
    public Double windSpeedAverage() {
        List<Double> windSpeedList=synopticRepository.findByWindSpeed();
        return windSpeedList
                .stream()
                .mapToDouble(value->value)
                .average()
                .getAsDouble();
    }

    @Override
    public Map<Double, String> stationWithMinTemperature() {
        Double minTemperature = synopticRepository
                .withoutNulls()
                .stream()
                .mapToDouble(value -> value.getTemperature())
                .min()
                .getAsDouble();
        String stringStream = synopticRepository.withoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(value -> value.getStation()).findFirst().get();
        Map<Double,String> stationWithMinTemperature=new HashMap<>();
        stationWithMinTemperature.put(minTemperature,stringStream);
        return stationWithMinTemperature;
    }

    @Override
    public Map<Double, String> stationWithMaxTemperature() {
        Double minTemperature = synopticRepository
                .withoutNulls()
                .stream()
                .mapToDouble(value -> value.getTemperature())
                .max()
                .getAsDouble();
        String station = synopticRepository.withoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(value -> value.getStation()).findFirst().get();
        Map<Double,String> stationWithMaxTemperature=new HashMap<>();
        stationWithMaxTemperature.put(minTemperature,station);
        return stationWithMaxTemperature;
    }
}
