package com.example.synop.domain.synoptic;

import com.example.synop.domain.client.RestClientData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SynopticFacade {

    private final SynopticCreator ssynopticCreator;
    private final SynopticRetrievalData synopticRetrievalData;
    private final RestClientData restClientData;


    public void createMultiSynoptic(){
        ssynopticCreator.insertMultiData(restClientData.retrieveData());
    }
    public Double pressureAverage(){return synopticRetrievalData.pressureAverage();}
    public Double windSpeedAverage(){return synopticRetrievalData.windSpeedAverage();}
    public Map<Double, String> stationWithMinTemperature(){return synopticRetrievalData.stationWithMinTemperature();}
    public Map<Double, String> stationWithMaxTemperature(){return synopticRetrievalData.stationWithMaxTemperature();}

}
