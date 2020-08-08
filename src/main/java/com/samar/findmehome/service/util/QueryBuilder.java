package com.samar.findmehome.service.util;

/**
 * Created by Samar J on 8/2/2020.
 */

public class QueryBuilder {

    public String generate(String postalCode, String propertyType, Integer minBed, Integer minBath, Integer minPrice, Integer maxPrice){

        String query = String.format("contains(PostalCode,'%s')", postalCode);
        if(propertyType != null && !propertyType.isEmpty()){
            query += String.format(" and PropertySubType eq '%s'" , propertyType);
        }
        if(minBed != null){
            query += " and BedroomsTotal ge " + minBed;
        }
        if(minBath != null){
            query += " and BathroomsFull ge " + minBath;
        }
        if(minPrice != null){
            query += " and ListPrice ge " + minPrice;
        }
        if(maxPrice != null){
            query += " and ListPrice le " + maxPrice;
        }
        return query;
    }

    public String generateSinglePropertyQuery(String listingKey){
        return String.format("('%s')", listingKey);
    }
}
