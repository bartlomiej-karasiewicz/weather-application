package com.example.synop.api;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class SynopticResponse {

    private Double pressureAverage;
    private Double windSpeedAverage;
    private Map<Double, String> stationWithMinTemperature;
    private Map<Double, String> stationWithMaxTemperature;
}
