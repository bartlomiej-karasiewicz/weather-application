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
    public void createSyno(@RequestBody SynopticDTO synopticDTO) {
        synopticCreator.insertData(synopticDTO);
    }


    @PostMapping
    @RequestMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMultiSyno() {
        synopticFacade.createMultiSynoptic();
    }

    @GetMapping
    @RequestMapping("/pressure")
    @ResponseStatus(HttpStatus.CREATED)
    public Double pressureAverage() {
        return synopticFacade.pressureAverage();
    }

    @GetMapping
    @RequestMapping("/windSpeed")
    @ResponseStatus(HttpStatus.CREATED)
    public Double windSpeedAverage() {
        return synopticFacade.windSpeedAverage();
    }


    @GetMapping
    @RequestMapping("/minstation")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<Double, String> stationWithMinTemperature() {
        return synopticFacade.stationWithMinTemperature();
    }

    @GetMapping
    @RequestMapping("/maxstation")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<Double, String> stationWithMaxTemperature() {
        return synopticFacade.stationWithMaxTemperature();
    }
}
