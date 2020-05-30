package com.synop.domain.client;

import com.synop.api.SynopticDTO;

import java.util.List;

public interface RestClientData {

    List<SynopticDTO> retrieveData();

}
