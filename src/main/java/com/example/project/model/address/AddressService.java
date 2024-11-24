package com.example.project.model.address;

import com.example.project.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repo;

    public Set<String> getCityData(){
        Set<String> city = new LinkedHashSet<String>();
        List<AddressDto> address = repo.findAllByOrderByCityAsc().stream().map(AddressDto::toDto).toList();

        for(AddressDto dto:address){
            city.add(dto.getCity());
        }
        return city;
    }

    public List<AddressDto> getAllData(){
        return repo.findAll().stream().map(AddressDto::toDto).toList();
    }
}
