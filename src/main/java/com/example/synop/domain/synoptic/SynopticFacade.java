package com.example.synop.domain.synoptic;

import com.example.synop.domain.client.RestClientData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SynopticFacade {

    private final SynopticCreator synoCreator;
    private final SynopticRetrievalData synoRetrievalData;
    private final RestClientData restClientData;


    public void createMultiSyno(){
        synoCreator.insertMultiData(restClientData.retrieveData());
    }
    public List<Synoptic> filterByCisnienie(Double cisnienie){return synoRetrievalData.filterByCisnienie(cisnienie);}
}
