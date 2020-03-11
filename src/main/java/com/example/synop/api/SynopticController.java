package com.example.synop.api;

import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticCreator;
import com.example.synop.domain.synoptic.SynopticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        synopticFacade.createMultiSyno();
    }

    @GetMapping
    @RequestMapping("/{cisnienie}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Synoptic> filterByCisnienie(@PathVariable (name = "cisnienie") Double cisnienie) {
        return synopticFacade.filterByCisnienie(cisnienie);
    }
}
