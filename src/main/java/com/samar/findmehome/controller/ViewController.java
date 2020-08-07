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

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(Model model) {
        model.addAttribute("criteria", new SearchCriteria());

        return "index";
    }

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public String getSearchResults(@ModelAttribute("criteria") SearchCriteria criteria, Model model) {

        //Validating the input parameters
        if (isValid(criteria)) {
            logger.info("Location = " + criteria);

            PropertiesResponse response = service.getPropertiesResponse(criteria);

            if ( response != null && response.getCount() != 0) {
                model.addAttribute("properties", response.getProperties());
                model.addAttribute("pages", (response.getCount() / criteria.getNumberOfListingInAPage()) + 1);
            }
        }
        //TODO error message for else
        return "search";
    }

    private boolean isValid(SearchCriteria criteria) {
        return true;
    }

    @GetMapping("/property")
    public String getPropertyDetails(@RequestParam("key") String listingKey, Model model) {

        model.addAttribute("property", service.getPropertyInfo(listingKey));
        return "property";
    }


}
