package com.synop.domain.synoptic;

import com.synop.api.SynopticDTO;

import java.util.List;

public interface SynopticCreator {

    void insertData(SynopticDTO synopticDTO);
    void insertMultiData(List<SynopticDTO> synopticDTOList);
}
