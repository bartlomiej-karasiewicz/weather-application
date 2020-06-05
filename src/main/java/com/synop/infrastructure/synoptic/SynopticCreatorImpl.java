package com.synop.infrastructure.synoptic;

import com.synop.api.SynopticDTO;
import com.synop.domain.synoptic.Synoptic;
import com.synop.domain.synoptic.SynopticCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SynopticCreatorImpl implements SynopticCreator {

    private final SynopticRepository synopticRepository;

    @Transactional
    public void insertData(SynopticDTO synopticDTO){
        synopticRepository.save(Synoptic.builder()
                .idStation(synopticDTO.getIdStation())
                .station(synopticDTO.getStation())
                .measureDate(synopticDTO.getMeasureDate())
                .measureTime(synopticDTO.getMeasureTime())
                .temperature(synopticDTO.getTemperature())
                .windSpeed(synopticDTO.getWindSpeed())
                .windDirection(synopticDTO.getWindDirection())
                .relativeHumidity(synopticDTO.getRelativeHumidity())
                .pressure(synopticDTO.getPressure())
                .totalRainfall(synopticDTO.getTotalRainfall())
                .build());
    }

    @Override
    @Transactional
    public void insertMultiData(List<SynopticDTO> synoDTOList) {
        synoDTOList.forEach(this::insertData);
    }

}
