package com.example.synop.domain.synoptic;

import java.util.Map;

public interface SynopticRetrievalData {
    Double pressureAverage();
    Double windSpeedAverage();
    Map<Double, String> stationWithMinTemperature();
    Map<Double, String> stationWithMaxTemperature();
}
