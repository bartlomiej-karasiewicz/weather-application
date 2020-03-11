package com.example.synop.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SynopticDTO {

    @JsonProperty("id_stacji")
    private Long idStacji;
    private String stacja;
    @JsonProperty("data_pomiaru")
    private LocalDate dataPomiaru;
    @JsonProperty("godzina_pomiaru")
    private Integer godzinaPomiaru;
    private Double temperatura;
    @JsonProperty("predkosc_wiatru")
    private Double predkoscWiatru;
    @JsonProperty("kierunek_wiatru")
    private Integer kierunekWiatru;
    @JsonProperty("wilgotnosc_wzgledna")
    private Double wilgotnoscWzgledna;
    @JsonProperty("suma_opadu")
    private Double sumaOpadu;
    private Double cisnienie;

}
