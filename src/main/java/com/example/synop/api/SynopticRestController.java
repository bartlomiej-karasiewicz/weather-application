package com.example.synop.api;

import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticCreator;
import com.example.synop.domain.synoptic.SynopticFacade;
import com.example.synop.domain.synoptic.SynopticRetrievalData;
import com.example.synop.infrastructure.synoptic.SynopticRetrievalDataImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/syno")
@RequiredArgsConstructor
public class SynopticRestController {

    private final SynopticCreator synopticCreator;
    private final SynopticFacade synopticFacade;
    private final SynopticRetrievalDataImpl synopticRetrievalDataImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSynoptic(@RequestBody SynopticDTO synopticDTO) {
        synopticCreator.insertData(synopticDTO);
    }


    @PostMapping
    @RequestMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMultiSynoptic() {
        synopticFacade.addMultiSynopticData();
    }

    @GetMapping
    @RequestMapping("/parameters")
    @ResponseStatus(HttpStatus.OK)
    public SynopticResponse getAllParameters() {
        return SynopticResponse.builder()
                .pressureAverage(synopticFacade.pressureAverage())
                .windSpeedAverage(synopticFacade.windSpeedAverage())
                .stationWithMaxTemperature(synopticFacade.stationWithMaxTemperature())
                .stationWithMinTemperature(synopticFacade.stationWithMinTemperature())
                .build();
    }
    @GetMapping
    @RequestMapping("/temperature")
    @ResponseStatus(HttpStatus.OK)
    public Map<LocalDate, List<Synoptic>> averageTemperature(){
        return synopticRetrievalDataImpl.averageTemperature();
    }
}
