package com.samar.findmehome.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samar J on 8/1/2020.
 */

public class Property {
    @JsonProperty("City")
    private String city;
    @JsonProperty("StateOrProvince")
    private String state;
    @JsonProperty("PostalCode")
    private int postalCode;
    @JsonProperty("UnparsedAddress")
    private String address;
    @JsonProperty("ListPrice")
    private int price;
    @JsonProperty("BedroomsTotal")
    private int numberOfBedrooms;
    @JsonProperty("BathroomsTotalInteger")
    private int numberOfBathrooms;
    @JsonProperty("PropertySubType")
    private String propertyType;
    @JsonProperty("PublicRemarks")
    private String description;
    @JsonProperty("LivingArea")
    private int floorArea;
    @JsonProperty("LotSizeSquareFeet")
    private int lotArea;
    @JsonProperty("GarageSpaces")
    private int numberOfParking;
    @JsonProperty("YearBuilt")
    private int yearBuilt;
    @JsonProperty("ListingKey")
    private String listingKey;
    @JsonProperty("Media")
    private List<Media> pictures;

    public Property(){}
    public Property(String city, String state, int postalCode, String address, int price, int numberOfBedrooms, int numberOfBathrooms, String propertyType, String description, int floorArea, int lotArea, List<Media> pictures, int numberOfParking, int yearBuilt) {
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.price = price;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.propertyType = propertyType;
        this.description = description;
        this.floorArea = floorArea;
        this.lotArea = lotArea;
        this.pictures = pictures;
        this.numberOfParking = numberOfParking;
        this.yearBuilt = yearBuilt;
    }

    @Override
    public String toString() {
        return "Property{" +
                " city='" + city +
                ", state=" + state +
                ", postalCode=" + postalCode +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", propertyType='" + propertyType + '\'' +
                ", description='" + description + '\'' +
                ", floorArea=" + floorArea +
                ", lotArea=" + lotArea +
                ", numberOfParking=" + numberOfParking +
                ", yearBuilt=" + yearBuilt +
                ", listingKey='" + listingKey + '\'' +
                ", pictures=" + pictures +
                '}';
    }

    public String getListingKey() {
        return listingKey;
    }

    public void setListingKey(String listingKey) {
        this.listingKey = listingKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        if(address == null){
            address = city + ", " + state + ", " + postalCode;
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public int getLotArea() {
        return lotArea;
    }

    public void setLotArea(int lotArea) {
        this.lotArea = lotArea;
    }

    public List<Media> getPictures() {
        if(pictures == null){
            pictures = new ArrayList<>();
            pictures.add(new Media("images/no-photo.jpg", "No pictures available"));
        }
        return pictures;
    }

    public void setPictures(List<Media> pictures) {
        this.pictures = pictures;
    }

    public int getNumberOfParking() {
        return numberOfParking;
    }

    public void setNumberOfParking(int numberOfParking) {
        this.numberOfParking = numberOfParking;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
