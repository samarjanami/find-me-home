package com.samar.findmehome.service.model;

import java.util.List;

/**
 * Created by Samar J on 8/1/2020.
 */

public class Property {
    private String address;
    private int price;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private String propertyType;
    private String description;
    private int floorArea;
    private int lotArea;
    private List<String> pictures;
    private int numberOfParking;
    private int yearBuilt;

    public Property(String address, int price, int numberOfBedrooms, int numberOfBathrooms, String propertyType, String description, int floorArea, int lotArea, List<String> pictures, int numberOfParking, int yearBuilt) {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
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
