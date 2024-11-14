package com.example.project.controller;

import com.example.project.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JoinController {

    @Autowired
    private UserService service;

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }


    @GetMapping("/join/duplicate/{id}")
    @ResponseBody
    public Map<String,String> duplicateCheck(@PathVariable("id") String id){
        System.out.println(id);
        Map<String,String> map = new HashMap<String,String>();
        if(service.duplicateCheck(id)) {
            map.put("result", "duplicate");
        } else {
            map.put("reslut","none");
        }
        return map;
    }

}
