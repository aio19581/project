package com.example.project.controller;

import com.example.project.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Map<String, Object> joinPage2(String roadAddrPart1, String roadAddrPart2, String zipNo, String inputYn){
        Map<String,Object> map = new HashMap<String, Object>();
        List list = new ArrayList();
        Map<String,String> data = new HashMap<String,String>();
        data.put("roadAddrPart1",roadAddrPart1);
        data.put("roadAddrPart2",roadAddrPart2);
        data.put("zipNo",zipNo);
        list.add(data);
        map.put("addr",list);

        return map;
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
