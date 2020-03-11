package com.example.synop.infrastructure.synoptic;

import com.example.synop.api.SynopticDTO;
import com.example.synop.domain.synoptic.Synoptic;
import com.example.synop.domain.synoptic.SynopticCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SynopticCreatorImpl implements SynopticCreator {

    private final SynopticRepository synoRepository;

    public void insertData(SynopticDTO synopticDTO){
        synoRepository.save(Synoptic.builder()
                .idStacji(synopticDTO.getIdStacji())
                .stacja(synopticDTO.getStacja())
                .dataPomiaru(synopticDTO.getDataPomiaru())
                .godzinaPomiaru(synopticDTO.getGodzinaPomiaru())
                .temperatura(synopticDTO.getTemperatura())
                .predkoscWiatru(synopticDTO.getPredkoscWiatru())
                .kierunekWiatru(synopticDTO.getKierunekWiatru())
                .wilgotnoscWzgledna(synopticDTO.getWilgotnoscWzgledna())
                .cisnienie(synopticDTO.getCisnienie())
                .sumaOpadu(synopticDTO.getSumaOpadu())
                .build());
    }

    @Override
    public void insertMultiData(List<SynopticDTO> synoDTOList) {
        synoDTOList.forEach(this::insertData);
    }

}
