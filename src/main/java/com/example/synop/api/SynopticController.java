package com.example.synop.api;

import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SynopticController {

    private final SynopticFacade synopticFacade;
    private final static String INDEX_VIEW = "index";

    @GetMapping(value = "/")
    public String parameters(Model model) {
        model.addAttribute("pressureAverage", synopticFacade.pressureAverage());
        model.addAttribute("windSpeedAverage", synopticFacade.windSpeedAverage());
        model.addAttribute("stationWithMinTemperature", synopticFacade.stationWithMinTemperature());
        model.addAttribute("stationWithMaxTemperature", synopticFacade.stationWithMaxTemperature());
        model.addAttribute("temperatureMapGroupByDate", synopticFacade.averageTemperatureGroupingByDate());
        return INDEX_VIEW;
    }


}
