package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertyResponse;
import com.samar.findmehome.service.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 * Created by Samar J on 8/1/2020.
 */

@Service
public class ResoService implements PropertyApiService {
    private WebClient webClient;

    public ResoService(@Value("${server.url}") String url, @Value("${server.token}") String token) {
        webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", token ) //TODO dont hard code it
                .build();
    }

    @Override
    public List<Property> getProperties(int postalCode, String propertyType, Integer minBed, Integer minBath, Integer minPrice, Integer maxPrice) {
        //TODO handle errors

        String query = new QueryBuilder().generate(postalCode, propertyType, minBed, minBath, minPrice, maxPrice);

        PropertyResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/Property")
                        .queryParam("$filter", query)
                        .build())
                .retrieve()
                .bodyToMono(PropertyResponse.class).block();

        return response.getProperties();
    }
}
