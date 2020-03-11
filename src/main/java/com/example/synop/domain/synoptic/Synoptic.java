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
    @Column(name = "id_station")
    private Long idStation;
    @Column(name = "station")
    private String station;
    @Column(name = "measure_date")
    private LocalDate measureDate;
    @Column(name = "measuare_time")
    private Integer measureTime;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "wind_speed")
    private Double windSpeed;
    @Column(name = "wind_direction")
    private Integer windDirection;
    @Column(name = "relative_humidity")
    private Double relativeHumidity;
    @Column(name = "total_rainfall")
    private Double totalRainfall;
    @Column(name = "pressure")
    private Double pressure;
}
