package com.example.project.login.controller;

import com.example.project.login.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
    @Autowired
    private UserDao dao;

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("login")
    public String userCheck(@RequestParam("userid") String userId,
                            @RequestParam("userpw") String userPw,
                            Model model){
        try {
            String pass = dao.getPass(userId);
            if (userPw.equals(pass)){
                model.addAttribute("msg","로그인성공");
                System.out.println("로그인성공");
                return "main";
            } else {
                model.addAttribute("msg","비밀번호 오류");
                return "login";
            }
        } catch (Exception e){
            System.out.println("아이디가 없습니다.");
            return "login";
        }
    }

    @GetMapping("join")
    public String joinPage(){ return "join"; }
}
