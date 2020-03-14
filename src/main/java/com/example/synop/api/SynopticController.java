package com.example.synop.api;

import com.example.synop.domain.synoptic.SynopticCreator;
import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v1/syno")
@RequiredArgsConstructor
public class SynopticController {

    private final SynopticCreator synopticCreator;
    private final SynopticFacade synopticFacade;

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
    @RequestMapping("/pressure")
    @ResponseStatus(HttpStatus.OK)
    public Double pressureAverage() {
        return synopticFacade.pressureAverage();
    }

    @GetMapping
    @RequestMapping("/windSpeed")
    @ResponseStatus(HttpStatus.OK)
    public Double windSpeedAverage() {
        return synopticFacade.windSpeedAverage();
    }


    @GetMapping
    @RequestMapping("/minstation")
    @ResponseStatus(HttpStatus.OK)
    public Map<Double, String> stationWithMinTemperature() {
        return synopticFacade.stationWithMinTemperature();
    }

    @GetMapping
    @RequestMapping("/maxstation")
    @ResponseStatus(HttpStatus.OK)
    public Map<Double, String> stationWithMaxTemperature() {
        return synopticFacade.stationWithMaxTemperature();
    }

    @GetMapping
    @RequestMapping("/parameters")
    @ResponseStatus(HttpStatus.OK)
    public SynopticResponse getAllParameters(){
        return SynopticResponse.builder()
                .pressureAverage(synopticFacade.pressureAverage())
                .windSpeedAverage(synopticFacade.windSpeedAverage())
                .stationWithMaxTemperature(synopticFacade.stationWithMaxTemperature())
                .stationWithMinTemperature(synopticFacade.stationWithMinTemperature())
                .build();
    }
}
