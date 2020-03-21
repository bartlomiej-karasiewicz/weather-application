package com.example.synop.domain.synoptic;

import com.example.synop.domain.client.RestClientData;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SynopticFacade {

    private final SynopticCreator synopticCreator;
    private final SynopticRetrievalData synopticRetrievalData;
    private final RestClientData restClientData;
    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");


    @Transactional
    public void addMultiSynopticData() {
        synopticCreator.insertMultiData(restClientData.retrieveData());
    }

    public Double pressureAverage() {
        return Precision.round(synopticRetrievalData.pressureAverage(), 2);
    }

    public Double windSpeedAverage() {
        return Precision.round(synopticRetrievalData.windSpeedAverage(),2);
    }

    public Map<String, Double> stationWithMinTemperature() {
        return synopticRetrievalData.stationWithMinTemperature();
    }

    public Map<String, Double> stationWithMaxTemperature() {
        return synopticRetrievalData.stationWithMaxTemperature();
    }

    public Date averageTemperatureSplittedByDate() {return synopticRetrievalData.averageTemperatureSplittedByDate();}

}
