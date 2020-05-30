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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class SynopticController {

    private final SynopticFacade synopticFacade;
    private final EmailSender emailSender;
    private final static String INDEX_VIEW = "index";
    private final static String SUCCESS_SEND_VIEW = "success";

    @GetMapping
    public String parameters(Model model) {
        model.addAttribute("pressureAverage", synopticFacade.pressureAverage());
        model.addAttribute("windSpeedAverage", synopticFacade.windSpeedAverage());
        model.addAttribute("stationWithMinTemperature", synopticFacade.stationWithMinTemperature());
        model.addAttribute("stationWithMaxTemperature", synopticFacade.stationWithMaxTemperature());
        model.addAttribute("temperatureMapGroupByDate", synopticFacade.averageTemperatureGroupingByDate());
        model.addAttribute("receiverDTO", new ReceiverDTO());
        return INDEX_VIEW;
    }

    @PostMapping("/email")
    @ResponseBody
    public String sendMail(@Valid @ModelAttribute ReceiverDTO receiverDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        model.addAttribute("receiverDTO", receiverDTO);
        //emailSender.sendEmailContent(receiverDTO.getMailAddress());
        emailSender.sendToQueque(receiverDTO.getMailAddress());
        log.info("Message sent successfully on queue");
        return SUCCESS_SEND_VIEW;
    }
}
