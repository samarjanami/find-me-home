package com.samar.findmehome.service.model;

/**
 * Created by Samar J on 8/4/2020.
 */

public class SearchCriteria {

    private String location;
    private String propertyType;
    private Integer minBed;
    private Integer minBath;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer numberOfListingInAPage;
    private Integer pageNumber;
/*
    public SearchCriteria(){
        this.location = null;
        this.propertyType = null;
        this.minBed = 1;
        this.minBath = 1;
        this.minPrice = 0;
        this.maxPrice = 10000000;
        this.numberOfListingInAPage = 9;
        this.pageNumber = 1;
    }
    public SearchCriteria(String location, String propertyType, Integer minBed, Integer minBath, Integer minPrice, Integer maxPrice, Integer numberOfListingInAPage, Integer pageNumber) {
        this.location = location;
        this.propertyType = propertyType;
        this.minBed = minBed;
        this.minBath = minBath;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.numberOfListingInAPage = numberOfListingInAPage;
        this.pageNumber = pageNumber;
    }*/

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "location='" + location + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", minBed=" + minBed +
                ", minBath=" + minBath +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", numberOfListingInAPage=" + numberOfListingInAPage +
                ", pageNumber=" + pageNumber +
                '}';
    }

    public Integer getNumberOfListingInAPage() {
        return numberOfListingInAPage;
    }

    public void setNumberOfListingInAPage(Integer numberOfListingInAPage) {
        this.numberOfListingInAPage = numberOfListingInAPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getMinBed() {
        return minBed;
    }

    public void setMinBed(Integer minBed) {
        this.minBed = minBed;
    }

    public Integer getMinBath() {
        return minBath;
    }

    public void setMinBath(Integer minBath) {
        this.minBath = minBath;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}
