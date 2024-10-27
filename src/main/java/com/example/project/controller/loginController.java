package com.example.project.controller;

import com.example.project.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @Autowired
    private MemberDao dao;

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

}
