package com.synop.infrastructure.client;

import com.synop.api.SynopticDTO;
import com.synop.domain.client.RestClientData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestClientDataImpl implements RestClientData {

    private final RestTemplate restTemplate;
    private final String synoAppHost;
    private final String synoAppUrl;

    public RestClientDataImpl(RestTemplate restTemplate,
                              @Value("${syno.app.host}")String synoAppHost,
                              @Value("${syno.app.retrieve}")String synoAppUrl) {
        this.restTemplate = restTemplate;
        this.synoAppHost = synoAppHost;
        this.synoAppUrl = synoAppUrl;
    }

    @Override
    public List<SynopticDTO> retrieveData() {
        String url = synoAppHost + synoAppUrl;
        ResponseEntity<List<SynopticDTO>> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<SynopticDTO>>() {
                }
        );
        return exchange.getBody();
    }
}
