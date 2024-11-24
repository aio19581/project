package com.example.project.controller.user;

import com.example.project.dto.AddressDto;
import com.example.project.model.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/address")
    public List<AddressDto> getList(){
        return service.getAllData();
    }
    @GetMapping("/address/city")
    public Set<String> getCity(){
        return service.getCityData();
    }



}
