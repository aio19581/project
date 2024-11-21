package com.example.project.controller.map;

import com.example.project.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @Autowired
    private UserService userService;

    @GetMapping("map")
    public String mapPage(Model model){
        //SecurityContextHolder에 저장된 사용자id 가져오기
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("addr",userService.getAddr(id));
        return "map";
    }

    @GetMapping("map2")
    public String map2Page(){
        return "map2";
    }
}
