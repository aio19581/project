package com.example.project.user.controller;

import com.example.project.user.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("loginsubmit")
    @ResponseBody
    public Map<String, String> userCheck(@RequestParam("userid") String userId,
                                        @RequestParam("userpw") String userPw){
        Map<String, String> data = new HashMap<String, String>();

        if(dao.checkId(userId)){
            if(dao.getPass(userId).equals(userPw)){
                data.put("msg","success");
            } else {
                data.put("msg","pw fail");
            }
        } else {
            data.put("msg","id fail");
        }
        return data;
    }
    /*
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
    */

    @GetMapping("join")
    public String joinPage(){ return "join"; }
}
