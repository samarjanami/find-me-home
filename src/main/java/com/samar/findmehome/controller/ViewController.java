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

        if (isValid(criteria)) {
            logger.info("criteria = " + criteria);

            PropertiesResponse response = service.getPropertiesResponse(criteria);

            if (response != null && response.getCount() != 0) {
                model.addAttribute("properties", response.getProperties());
                model.addAttribute("pages", (response.getCount() / criteria.getNumberOfListingInAPage()) + 1);
            } else {
                model.addAttribute("error", "No results found!");
            }
        } else {
            model.addAttribute("error", "Invalid input. Please try again!");
        }
        return "search";
    }

    @GetMapping("/property")
    public String getPropertyDetails(@RequestParam("key") String listingKey, Model model) {
        model.addAttribute("property", service.getPropertyInfo(listingKey));
        return "property";
    }

    private boolean isValid(SearchCriteria criteria) {
        if (!isValidZipCode(criteria.getLocation())) {
            return false;
        }
        if (criteria.getPageNumber() == null || criteria.getNumberOfListingInAPage() == null) {
            return false;
        }
        if (criteria.getMinBed() < 0 || criteria.getMinBed() > 5) {
            return false;
        }
        if (criteria.getMinBath() < 0 || criteria.getMinBath() > 5) {
            return false;
        }
        return true;
    }

    private boolean isValidZipCode(CharSequence zipCode) {
        String[] patterns = {"#####", "#####-####"};
        try {
            for (String pattern : patterns) {
                if (checkAgainstPattern(zipCode, pattern)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException ignored) {
            return false;
        }
    }

    private boolean checkAgainstPattern(CharSequence zipCode, CharSequence pattern) {
        if (zipCode.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = zipCode.charAt(i);
            switch (pattern.charAt(i)) {
                case '#':
                    if (!Character.isDigit(c)) {
                        return false;
                    }
                    break;

                default:
                    if (c != pattern.charAt(i)) {
                        return false;
                    }
            }
        }
        return true;
    }

}
