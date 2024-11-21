package com.example.project.controller.user;

import com.example.project.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserBean {

    private String userid, userpw, name, phone, email1,email2, nickname, roadAddrPart1, roadAddrPart2, addrDetail, zipNo;

    public static UserDto toDto(UserBean bean){
        return UserDto.builder()
                .userid(bean.getUserid())
                .userpw(bean.getUserpw())
                .name(bean.getName())
                .nick(bean.getNickname())
                .addr(bean.getRoadAddrPart1()+" "+bean.getRoadAddrPart2())
                .addr2(bean.getAddrDetail())
                .email(bean.getEmail1()+"@"+bean.getEmail2())
                .phone(bean.getPhone())
                .build();
    }

}
