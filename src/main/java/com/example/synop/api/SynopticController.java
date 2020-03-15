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
        model.addAttribute("maxTemperature", synopticFacade.stationWithMaxTemperature().values().toArray()[0]);
        model.addAttribute("minTemperature", synopticFacade.stationWithMinTemperature().values().toArray()[0]);
        model.addAttribute("stationWithMinTemperature", synopticFacade.stationWithMinTemperature().keySet().toArray()[0]);
        model.addAttribute("stationWithMaxTemperature", synopticFacade.stationWithMaxTemperature().keySet().toArray()[0]);
        return INDEX_VIEW;
    }


}
