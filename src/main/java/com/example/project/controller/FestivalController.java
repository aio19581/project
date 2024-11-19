package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FestivalController {
    @GetMapping("/festival")
    public String page(){
        return "Festival";
    }
}