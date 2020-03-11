package com.example.synop.domain.synoptic;

import com.example.synop.api.SynopticDTO;

import java.util.List;

public interface SynopticCreator {

    void insertData(SynopticDTO synopticDTO);
    void insertMultiData(List<SynopticDTO> synopticDTOList);
}
