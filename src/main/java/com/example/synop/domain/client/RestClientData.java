package com.example.synop.domain.client;

import com.example.synop.api.SynopticDTO;

import java.util.List;

public interface RestClientData {

    List<SynopticDTO> retrieveData();

}
