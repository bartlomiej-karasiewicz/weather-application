package com.example.synop.api;

import com.example.synop.domain.email.EmailSender;
import com.example.synop.domain.email.Receiver;
import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class SynopticController {

    private final SynopticFacade synopticFacade;
    private final EmailSender emailSender;
    private final static String INDEX_VIEW = "index";

    @GetMapping
    public String parameters(Model model) {
        model.addAttribute("pressureAverage", synopticFacade.pressureAverage());
        model.addAttribute("windSpeedAverage", synopticFacade.windSpeedAverage());
        model.addAttribute("stationWithMinTemperature", synopticFacade.stationWithMinTemperature());
        model.addAttribute("stationWithMaxTemperature", synopticFacade.stationWithMaxTemperature());
        model.addAttribute("temperatureMapGroupByDate", synopticFacade.averageTemperatureGroupingByDate());
        model.addAttribute("receiver", new Receiver());
        return INDEX_VIEW;
    }

    @PostMapping("/email")
    public String greetingSubmit(@Valid @ModelAttribute Receiver receiver, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.info("Wrong mail address");
            return "redirect:/";
        }
        model.addAttribute("receiver", receiver);
        emailSender.sendEmailContent(receiver.getMailAddress());
        return "redirect:/";
    }
}
