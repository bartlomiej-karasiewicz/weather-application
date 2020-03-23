package com.example.synop.domain.synoptic;

import java.time.LocalDate;
import java.util.Map;

public interface SynopticRetrievalData {
    Double pressureAverage();
    Double windSpeedAverage();
    Map<String, Double> stationWithMinTemperature();
    Map<String, Double> stationWithMaxTemperature();
    Map<LocalDate, Double> averageTemperatureGroupingByDate();
}
