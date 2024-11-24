package com.example.project.dto;

import com.example.project.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String city, local;

    public static AddressDto toDto(Address address){
        return AddressDto.builder().city(address.getCity()).local(address.getLocal()).build();
    }
}
