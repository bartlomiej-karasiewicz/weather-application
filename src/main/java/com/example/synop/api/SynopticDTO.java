package com.example.synop.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SynopticDTO {

    @JsonProperty("id_stacji")
    private Long idStation;
    private String station;
    @JsonProperty("data_pomiaru")
    private LocalDate measureDate;
    @JsonProperty("godzina_pomiaru")
    private Integer measureTime;
    private Double temperature;
    @JsonProperty("predkosc_wiatru")
    private Double windSpeed;
    @JsonProperty("kierunek_wiatru")
    private Integer windDirection;
    @JsonProperty("wilgotnosc_wzgledna")
    private Double relativeHumidity;
    @JsonProperty("suma_opadu")
    private Double totalRainfall;
    private Double pressure;

}
