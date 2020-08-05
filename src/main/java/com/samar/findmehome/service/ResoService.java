package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertiesResponse;
import com.samar.findmehome.service.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by Samar J on 8/1/2020.
 */

@Service
public class ResoService implements PropertyApiService {
    private WebClient webClient;

    public ResoService(@Value("${server.url}") String url, @Value("${server.token}") String token) {
        webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", token)
                .build();
    }

    @Override
    public PropertiesResponse getPropertiesResponse(int postalCode, String propertyType, Integer minBed, Integer minBath,
                                                    Integer minPrice, Integer maxPrice, Integer numberOfListingInAPage, Integer pageNumber) {
        //TODO handle errors

        String query = new QueryBuilder().generate(postalCode, propertyType, minBed, minBath, minPrice, maxPrice);
        int skip = pageNumber * numberOfListingInAPage;
        PropertiesResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/Property")
                        .queryParam("$skip", skip)
                        .queryParam("$top", numberOfListingInAPage)
                        .queryParam("$filter", query)
                        .build())
                .retrieve()
                .bodyToMono(PropertiesResponse.class).block();

        return response;
    }

    @Override
    public Property getPropertyInfo(String listingKey) {
        //TODO handle errors
        String query = new QueryBuilder().generateSinglePropertyQuery(listingKey);
        Property property = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/Property" + query)
                        .build())
                .retrieve()
                .bodyToMono(Property.class).block();

        return property;
    }
}
