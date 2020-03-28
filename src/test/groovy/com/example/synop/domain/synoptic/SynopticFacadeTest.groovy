package com.example.synop.domain.synoptic


import com.example.synop.infrastructure.synoptic.SynopticCreatorImpl
import com.example.synop.infrastructure.synoptic.SynopticRepository
import com.example.synop.infrastructure.synoptic.SynopticRetrievalDataImpl
import spock.lang.Specification

class SynopticFacadeTest extends Specification {

    SynopticRepository synopticRepository=Mock(SynopticRepository)
    SynopticRetrievalData synopticRetrievalData=new SynopticRetrievalDataImpl(synopticRepository)
    SynopticCreator synopticCreator=new SynopticCreatorImpl(synopticRepository)
//    RestClientData restClientData=new RestClientDataImpl()
//    SynopticFacade synopticFacade= new SynopticFacade(synopticCreator,synopticRetrievalData,restClientData)

    def "AddMultiSynopticData"() {
    }

    def "Should retrieve pressure average"() {
        setup:
        Double pressureAvg=1200.0
        1*synopticRepository.findByPressure()>>pressureAvg
        expect:
        synopticRetrievalData.pressureAverage()== pressureAvg
    }

    def "Should retrieve wind speed average"() {
        setup:
        Double windSpeedAvg=3.0
        1*synopticRepository.findByWindSpeed()>>windSpeedAvg
        expect:
        synopticRetrievalData.windSpeedAverage()==windSpeedAvg
    }

    def "StationWithMinTemperature"() {
    }

    def "StationWithMaxTemperature"() {
    }

    def "AverageTemperatureGroupingByDate"() {
    }
}
