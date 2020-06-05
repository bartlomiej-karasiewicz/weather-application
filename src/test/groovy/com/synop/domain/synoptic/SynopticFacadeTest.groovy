package com.synop.domain.synoptic

import com.synop.domain.client.RestClientData
import com.synop.infrastructure.synoptic.SynopticCreatorImpl
import com.synop.infrastructure.synoptic.SynopticRepository
import com.synop.infrastructure.synoptic.SynopticRetrievalDataImpl
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDate

class SynopticFacadeTest extends Specification {

    SynopticRepository synopticRepository = Mock(SynopticRepository)
    RestClientData restClientData = Mock(RestClientData)
    SynopticRetrievalData synopticRetrievalData = new SynopticRetrievalDataImpl(synopticRepository)
    SynopticCreator synopticCreator = new SynopticCreatorImpl(synopticRepository)
    SynopticFacade synopticFacade = new SynopticFacade(synopticCreator, synopticRetrievalData, restClientData)

    @Shared
    List<Synoptic> synopticList = Arrays.asList(
            Synoptic.builder().temperature(30.0).station("Plock").measureDate(LocalDate.of(2020, 3, 27)).build(),
            Synoptic.builder().temperature(28.0).station("Warszawa").measureDate(LocalDate.of(2020, 3, 28)).build())

    def "AddMultiSynopticData"() {
    }

    def "Should retrieve pressure average"() {
        given:
        Double pressureAvg = 1200.01
        1 * synopticRepository.pressureAverage() >> pressureAvg
        expect:
        synopticFacade.pressureAverage() == pressureAvg
    }

    def "Should retrieve wind speed average"() {
        given:
        Double windSpeedAvg = 3.01
        1 * synopticRepository.windSpeedAverage() >> windSpeedAvg
        expect:
        synopticFacade.windSpeedAverage() == windSpeedAvg
    }

    def "Should provide data about station with min temperature and min temperature"() {
        given:
        _ * synopticRepository.dataWithoutNulls() >> synopticList
        expect:
        synopticFacade.stationWithMinTemperature().values().min {} == 28.0 &&
                synopticFacade.stationWithMinTemperature().find {
                    synopticFacade.stationWithMinTemperature().values().min {}
                }.key == "Warszawa"
    }

    def "Should provide data about station with max temperature and max temperature"() {
        given:
        _ * synopticRepository.dataWithoutNulls() >> synopticList
        expect:
        synopticFacade.stationWithMaxTemperature().values().max {} == 30.0 &&
                synopticFacade.stationWithMaxTemperature().find {
                    synopticFacade.stationWithMaxTemperature().values().max {}
                }.key == "Plock"
    }

    def "Should group data by base on date and average temperature"() {
        given:
        _ * synopticRepository.findAll() >> synopticList
        when:
        synopticFacade.averageTemperatureGroupingByDate()
        then:
        synopticFacade.averageTemperatureGroupingByDate().values().asList() == [28.0, 30.0]
    }
}
