package com.example.project.controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("map")
    public String mapPage(){
        return "map";
    }

    @GetMapping("map2")
    public String map2Page(){
        return "map2";
    }
}
