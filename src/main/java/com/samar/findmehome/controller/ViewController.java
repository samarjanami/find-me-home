package com.samar.findmehome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Samar J on 7/31/2020.
 */

@Controller
public class ViewController {

    @GetMapping(value = {"/" , "/index.html"})
    public String getSearchResults(Model model){
        return "index";
    }

    @GetMapping("/property-single.html")
    public String getPropertyDetails(Model model){
        return "property-single";
    }

}
