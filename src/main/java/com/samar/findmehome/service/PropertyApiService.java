package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertiesResponse;

/**
 * Created by Samar J on 8/1/2020.
 */

public interface PropertyApiService {
    PropertiesResponse getPropertiesResponse(int postalCode, String propertyType, Integer minBed, Integer minBath, Integer minPrice, Integer maxPrice, Integer numberOfListingInAPage, Integer pageNumber);
    Property getPropertyInfo(String listingKey);
}
