package com.example.synop.infrastructure.synoptic;

import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticRetrievalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SynopticRetrievalDataImpl implements SynopticRetrievalData {

    private final SynopticRepository synopticRepository;

    @Override
    public Double pressureAverage() {
        return synopticRepository.findByPressure();
    }

    @Override
    public Double windSpeedAverage() {
        return synopticRepository.findByWindSpeed();
    }

    @Override
    public Map<String, Double> stationWithMinTemperature() {
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
        Map<String, Double> stationWithMinTemperature = new HashMap<>();
        stationWithMinTemperature.put(station, minTemperature);
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
        Map<String, Double> stationWithMaxTemperature = new HashMap<>();
        stationWithMaxTemperature.put(station, minTemperature);
        return stationWithMaxTemperature;
    }

    @Override
    public Date averageTemperatureSplittedByDate() {
        return synopticRepository.groupByTemperatureByMeasureDate();
    }

    public Map<LocalDate, List<Synoptic>> averageTemperature(){
        Map<LocalDate, List<Synoptic>> dateDoubleMap=synopticRepository
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(synoptic -> synoptic.getMeasureDate()));
        return dateDoubleMap;
    }
}
