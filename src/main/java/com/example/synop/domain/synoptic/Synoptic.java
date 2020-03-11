package com.example.synop.domain.synoptic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private Long idStacji;
    private String stacja;
    private LocalDate dataPomiaru;
    private Integer godzinaPomiaru;
    private Double temperatura;
    private Double predkoscWiatru;
    private Integer kierunekWiatru;
    private Double wilgotnoscWzgledna;
    private Double sumaOpadu;
    private Double cisnienie;
}
