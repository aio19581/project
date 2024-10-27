package com.example.project.controller;

import com.example.project.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class loginController {
    @Autowired
    private UserDao dao;

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public void memberCheck(@RequestParam("userid") String userId,
                            @RequestParam("userpw") String userPw,
                            Model model){
        try {
            String pass = dao.getPass(userId).getUserpw();
            if (userPw.equals(pass)){
                model.addAttribute("msg","로그인성공");
                System.out.println(model.getAttribute("msg"));
            } else {
                model.addAttribute("msg","비밀번호 오류");
                System.out.println(model.getAttribute("msg"));
            }
        } catch (Exception e){
            System.out.println("아이디가 없습니다.");
        }
    }
}
