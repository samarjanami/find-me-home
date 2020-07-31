package com.samar.findmehome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Samar J on 7/31/2020.
 */

@Controller
public class ViewController {

    @GetMapping("/")
    public String getSearchResults(Model model){
        return "/index";
    }
}
