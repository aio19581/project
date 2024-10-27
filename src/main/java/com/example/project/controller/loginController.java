package com.example.project.controller;

import com.example.project.model.Member;
import com.example.project.model.MemberDao;

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
    private MemberDao dao;

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
    public void memberCheck(@RequestParam("memberId") String memberId,
                            @RequestParam("memberPw") String memberPw,
                            Model model){

        List<Member> list = dao.getAllData();
        list.forEach(m ->{
            if(memberId.equals(m.getMemberid()) && memberPw.equals(m.getMemberpw())){
                model.addAttribute("msg","로그인성공");
                System.out.println("success");
            } else {
                model.addAttribute("msg","로그인실패");
                System.out.println("fail");
            }
        });
    }
}
