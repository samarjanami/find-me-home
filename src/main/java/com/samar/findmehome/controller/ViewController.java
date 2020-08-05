package com.samar.findmehome.controller;

import com.samar.findmehome.service.PropertyApiService;
import com.samar.findmehome.service.model.PropertiesResponse;
import com.samar.findmehome.service.model.SearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Samar J on 7/31/2020.
 */

@Controller
public class ViewController {
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private PropertyApiService service;

    @GetMapping(value = {"/" , "/index"})
    public String getHomePage(Model model){
        model.addAttribute("criteria", new SearchCriteria());

        return "index";
    }

    /*@PostMapping("/search")
    public String getSearchResults(@RequestParam( value = "location" , required = true) String location,
                                   @RequestParam( value = "property-types" , required = false) String propertyType,
                                   @RequestParam( value = "min-bed" , required = false) Integer minBed,
                                   @RequestParam( value = "min-bath" , required = false) Integer minBath,
                                   @RequestParam( value = "min-price" , required = false) Integer minPrice,
                                   @RequestParam( value = "max-price" , required = false) Integer maxPrice,
                                   @RequestParam( value = "top", required = false, defaultValue = "9") Integer numberOfListingInAPage,
                                   @RequestParam( value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                   Model model){
        logger.info("Location = " + location +
                " Type = " + propertyType +
                " min beds = " + minBed +
                " min baths = " + minBath +
                " min price = " + minPrice +
                " max price = " + maxPrice +
                " top = " + numberOfListingInAPage +
                " page number = " + pageNumber);

        //TODO Validating the input parameters

        //Call service and set model
        PropertiesResponse response = service.getPropertiesResponse(953, propertyType, minBed, minBath,
                minPrice, maxPrice, numberOfListingInAPage, pageNumber);
        model.addAttribute("properties", response.getProperties());
        model.addAttribute("pages", response.getCount()/numberOfListingInAPage);
        model.addAttribute("currentPageNumber", pageNumber+1);

        return "search";
    }*/


    @PostMapping("/search")
    public String getSearchResults(@ModelAttribute("criteria") SearchCriteria criteria, Model model){

        PropertiesResponse response = service.getPropertiesResponse(953, criteria.getPropertyType(),
                criteria.getMinBed(), criteria.getMinBath(), criteria.getMinPrice(), criteria.getMaxPrice(),
                criteria.getNumberOfListingInAPage(), criteria.getCurrentPageNumber()-1);

        logger.info("Location = " + criteria.getLocation() +
                " Type = " + criteria.getPropertyType() +
                " min beds = " + criteria.getMinBed() +
                " min baths = " + criteria.getMinBath() +
                " min price = " + criteria.getMinPrice() +
                " max price = " + criteria.getMaxPrice() +
                " top = " + criteria.getNumberOfListingInAPage() +
                " page number = " + criteria.getCurrentPageNumber());

        if(response.getCount() != 0) {
            model.addAttribute("properties", response.getProperties());
           // model.addAttribute("criteria", criteria);
            model.addAttribute("pages", (response.getCount()/criteria.getNumberOfListingInAPage())+1);
        }
        return "search";
    }

    @GetMapping("/property")
    public String getPropertyDetails(@RequestParam("key") String listingKey, Model model){

        model.addAttribute("property",service.getPropertyInfo(listingKey));
        return "property";
    }


}
