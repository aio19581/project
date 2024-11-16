package com.example.project.controller.user;

import com.example.project.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JoinController {

    @Autowired
    private UserService service;

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/join")
    public String join(UserBean bean){
        System.out.println(bean.getName());
        System.out.println(bean.getUserid());
        service.joinUser(bean);

        return "main";
    }

    @GetMapping("/join/duplicate/{data}/{type}")
    @ResponseBody
    public Map<String,String> duplicateCheck(@PathVariable("data") String data,
                                             @PathVariable("type") String type){
        Map<String,String> map = new HashMap<String,String>();
        if(type.equals("id")){
            if(service.duplicateIdCheck(data)) {
                map.put("result", "duplicate");
            } else {
                map.put("reslut","none");
            }
            return map;
        } else if(type.equals("nick")) {
            if (service.duplicateNickCheck(data)) {
                map.put("result", "duplicate");
            } else {
                map.put("reslut", "none");
            }
            return map;
        } else{
            throw new Error("타입 불일치");
        }
    }

    @GetMapping("/join/popup")
    public String popupPage(Model model){
        model.addAttribute("inputYn","");
        return "jusopopup";
    }

    @PostMapping("/join/popup")
    public String popupReturn(String roadAddrPart1, String roadAddrPart2, String zipNo, String addrDetail, Model model){
        model.addAttribute("inputYn","Y");
        model.addAttribute("roadAddrPart1",roadAddrPart1);
        model.addAttribute("roadAddrPart2",roadAddrPart2);
        model.addAttribute("addrDetail",addrDetail);
        model.addAttribute("zipNo",zipNo);
        return "jusopopup";
    }



}
