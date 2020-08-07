package com.samar.findmehome.service;

import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertiesResponse;
import com.samar.findmehome.service.model.SearchCriteria;

/**
 * Created by Samar J on 8/1/2020.
 */

public interface PropertyApiService {
    PropertiesResponse getPropertiesResponse(SearchCriteria criteria);
    Property getPropertyInfo(String listingKey);
}
