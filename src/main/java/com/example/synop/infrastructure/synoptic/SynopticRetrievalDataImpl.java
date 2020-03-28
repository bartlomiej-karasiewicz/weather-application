package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticRetrievalData;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SynopticRetrievalDataImpl implements SynopticRetrievalData {

    private final SynopticRepository synopticRepository;

    @Override
    public Double pressureAverage() {
        return Precision.round(synopticRepository.pressureAverage(),2);
    }

    @Override
    public Double windSpeedAverage() {
        return Precision.round(synopticRepository.windSpeedAverage(),2);
    }

    @Override
    public Map<String, Double> stationWithMinTemperature() {
        Double minTemperature = synopticRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(Synoptic::getTemperature)
                .min()
                .getAsDouble();
        String station = synopticRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(Synoptic::getStation).findFirst()
                .get();
        Map<String, Double> stationWithMinTemperature = new HashMap<>();
        stationWithMinTemperature.put(station, minTemperature);
        return stationWithMinTemperature;
    }

    @Override
    public Map<String, Double> stationWithMaxTemperature() {
        Double minTemperature = synopticRepository
                .dataWithoutNulls()
                .stream()
                .mapToDouble(Synoptic::getTemperature)
                .max()
                .getAsDouble();
        String station = synopticRepository.dataWithoutNulls()
                .stream()
                .filter(value -> minTemperature.equals(value.getTemperature()))
                .map(Synoptic::getStation).findFirst()
                .get();
        Map<String, Double> stationWithMaxTemperature = new HashMap<>();
        stationWithMaxTemperature.put(station, minTemperature);
        return stationWithMaxTemperature;
    }

    @Override
    public Map<LocalDate, Double> averageTemperatureGroupingByDate() {
        Map<LocalDate, Double> averageTemperatureBaseOnDate = new HashMap<>();
        synopticRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Synoptic::getMeasureDate,
                        Collectors.averagingDouble(Synoptic::getTemperature)))
                .forEach((localDate, temperature) -> averageTemperatureBaseOnDate.put(localDate, Precision.round(temperature, 1)));
        return averageTemperatureBaseOnDate;
    }
}
