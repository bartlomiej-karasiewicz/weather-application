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
    public Map<String,Double> stationWithMinTemperature() {
        Double minTemperature = synopticRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(value -> value.getTemperature())
                .min()
                .getAsDouble();
        String station = synopticRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(value -> value.getStation()).findFirst().get();
        Map<String, Double> stationWithMinTemperature=new HashMap<>();
        stationWithMinTemperature.put(station,minTemperature);
        return stationWithMinTemperature;
    }

    @Override
    public Map<String, Double> stationWithMaxTemperature() {
        Double minTemperature = synopticRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(value -> value.getTemperature())
                .max()
                .getAsDouble();
        String station = synopticRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(value -> value.getStation()).findFirst().get();
        Map<String,Double> stationWithMaxTemperature=new HashMap<>();
        stationWithMaxTemperature.put(station,minTemperature);
        return stationWithMaxTemperature;
    }
}
