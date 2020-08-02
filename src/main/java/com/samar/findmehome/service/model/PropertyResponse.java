package com.samar.findmehome.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Samar J on 8/1/2020.
 */

public class PropertyResponse {
    @JsonProperty("@odata.count")
    private int count;
    @JsonProperty("value")
    private List<Property> properties;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
