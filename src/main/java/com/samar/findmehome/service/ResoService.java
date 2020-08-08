package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertiesResponse;
import com.samar.findmehome.service.model.SearchCriteria;
import com.samar.findmehome.service.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
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
    public PropertiesResponse getPropertiesResponse(SearchCriteria criteria) {

        String query = new QueryBuilder().generate(criteria.getLocation(), criteria.getPropertyType(),
                criteria.getMinBed(), criteria.getMinBath(), criteria.getMinPrice(), criteria.getMaxPrice());

        int skip = (criteria.getPageNumber() - 1) * criteria.getNumberOfListingInAPage();
        int numberOfListings = criteria.getNumberOfListingInAPage();

        PropertiesResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/Property")
                        .queryParam("$skip", skip)
                        .queryParam("$top", numberOfListings)
                        .queryParam("$filter", query)
                        .build())
                .retrieve()
                .bodyToMono(PropertiesResponse.class).block();

        return response;
    }

    @Override
    public Property getPropertyInfo(@NonNull String listingKey) {
        //TODO handle webclient errors
        String query = new QueryBuilder().generateSinglePropertyQuery(listingKey);
        Property property = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/Property" + query)
                        .build())
                .retrieve()
                .bodyToMono(Property.class).block();

        return property;
    }
}
