package com.samar.findmehome.service.util;

/**
 * Created by Samar J on 8/2/2020.
 */

public class QueryBuilder {

    public String generate(String postalCode, String propertyType, Integer minBed, Integer minBath, Integer minPrice, Integer maxPrice){
        //https://api.bridgedataoutput.com/api/v2/OData/test/Property?access_token=6baca547742c6f96a6ff71b138424f21&$filter=contains(PostalCode,'95314') and PropertySubType eq 'Single Family Residence' and BedroomsTotal ge 1 and BathroomsFull ge 1 and ListPrice ge 2000 and ListPrice le 600000
//.queryParam("$select","ListingId, PropertySubType,NumberOfUnitsTotal, ListingId, PropertySubType, Media, LotSizeSquareFeet, LivingArea, YearBuilt, ListPrice, BedroomsTotal, BathroomsTotalInteger, GarageSpaces")

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
        //https://api.bridgedataoutput.com/api/v2/OData/test/Property('P_5dba1fb94aa4055b9f29696f')?access_token=6baca547742c6f96a6ff71b138424f21
        String query = String.format("('%s')", listingKey);
        return query;
    }
}
