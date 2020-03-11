package com.example.synop.domain.synoptic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "syno")
@Builder
@Getter
@ToString
@Entity
public class Synoptic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "idStation")
    private Long idStacji;
    @Column(name = "station")
    private String stacja;
    @Column(name = "measure_date")
    private LocalDate dataPomiaru;
    @Column(name = "measuare_time")
    private Integer godzinaPomiaru;
    @Column(name = "temperature")
    private Double temperatura;
    @Column(name = "wind_speed")
    private Double predkoscWiatru;
    @Column(name = "wind_direction")
    private Integer kierunekWiatru;
    @Column(name = "relative_humidity")
    private Double wilgotnoscWzgledna;
    @Column(name = "total_rainfall")
    private Double sumaOpadu;
    @Column(name = "pressure")
    private Double cisnienie;
}
