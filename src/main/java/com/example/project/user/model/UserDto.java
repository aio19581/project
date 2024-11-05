package com.example.project.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int no, point;
    private String userid, userpw, name, nick, addr, addr2, email, phone;
    private Date regdate;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .no(user.getNo())
                .userid(user.getUserid())
                .userpw(user.getUserpw())
                .name(user.getName())
                .nick(user.getNick())
                .addr(user.getAddr())
                .addr2(user.getAddr2())
                .email(user.getEmail())
                .phone(user.getPhone())
                .point(user.getPoint())
                .build();
    }

    public static User toEntity(UserDto dto){
        return User.builder()
                .no(dto.getNo())
                .userid(dto.getUserid())
                .userpw(dto.getUserpw())
                .name(dto.getName())
                .nick(dto.getNick())
                .addr(dto.getAddr())
                .addr2(dto.getAddr2())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .point(dto.getPoint())
                .build();
    }
}
