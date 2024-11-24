package com.example.project.controller.user;

import com.example.project.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String mainPage(Model model) {
        Authentication check = SecurityContextHolder.getContext().getAuthentication();
        if(check.getPrincipal().equals("anonymousUser")){
            model.addAttribute("login",false);
        } else {
            model.addAttribute("login", true);
        }
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
