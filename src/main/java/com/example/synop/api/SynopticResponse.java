package com.example.synop.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class SynopticResponse {

    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<String, Double> stationWithMinTemperature;
    private Map<String, Double> stationWithMaxTemperature;
}
