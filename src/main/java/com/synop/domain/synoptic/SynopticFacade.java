package com.synop.domain.synoptic;

import com.synop.domain.client.RestClientData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SynopticFacade {

    private final SynopticCreator synopticCreator;
    private final SynopticRetrievalData synopticRetrievalData;
    private final RestClientData restClientData;

    @Transactional
    public void addMultiSynopticData() {
        synopticCreator.insertMultiData(restClientData.retrieveData());
    }

    public Double pressureAverage() {
        return synopticRetrievalData.pressureAverage();
    }

    public Double windSpeedAverage() {
        return synopticRetrievalData.windSpeedAverage();
    }

    public Map<String, Double> stationWithMinTemperature() {
        return synopticRetrievalData.stationWithMinTemperature();
    }

    public Map<String, Double> stationWithMaxTemperature() {
        return synopticRetrievalData.stationWithMaxTemperature();
    }

    public Map<LocalDate, Double> averageTemperatureGroupingByDate() {
        return synopticRetrievalData.averageTemperatureGroupingByDate();
    }
}
