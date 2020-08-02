package com.samar.findmehome.controller;

import com.samar.findmehome.service.PropertyApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Samar J on 7/31/2020.
 */

@Controller
public class ViewController {
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private PropertyApiService service;

    @GetMapping(value = {"/" , "/index"})
    public String getHomePage(){
        return "index";
    }

    @PostMapping("/search")
    public String getSearchResults(@RequestParam( value = "location" , required = true) String location,
                                   @RequestParam( value = "property-types" , required = false) String propertyType,
                                   @RequestParam( value = "min-bed" , required = false) Integer minBed,
                                   @RequestParam( value = "min-bath" , required = false) Integer minBath,
                                   @RequestParam( value = "min-price" , required = false) Integer minPrice,
                                   @RequestParam( value = "max-price" , required = false) Integer maxPrice,
                                   Model model){
        logger.info("Location = " + location +
                " Type = " + propertyType +
                " min beds = " + minBed +
                " min baths = " + minBath +
                " min price = " + minPrice +
                " max price = " + maxPrice);

        //TODO Validating the input parameters

        //Call service and set model
        model.addAttribute("properties", service.getProperties(90025, propertyType, minBed, minBath, minPrice, maxPrice));

        //TODO update view

        return "search";
    }

    @GetMapping("/property-single.html")
    public String getPropertyDetails(Model model){
        return "property-single";
    }


}
