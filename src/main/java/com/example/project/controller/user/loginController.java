package com.example.project.controller.user;

import com.example.project.dto.UserDto;
import com.example.project.entity.Userinfo;
import com.example.project.model.user.UserRepository;
import com.example.project.model.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class loginController {
    @Autowired
    private UserService service;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    //    @GetMapping("/")
//    public String mainPage(Model model) {
//        Authentication check = SecurityContextHolder.getContext().getAuthentication();
//        if(check.getPrincipal().equals("anonymousUser")){
//            model.addAttribute("login",false);
//        } else {
//            model.addAttribute("login", true);
//        }
//        return "main";
//    }
    @GetMapping("/user")
    public ResponseEntity<Userinfo> getUser(String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userid = authentication.getName();
        Userinfo user =  userRepository.findByuserid(id);
        return ResponseEntity.ok(user);
    }


}
