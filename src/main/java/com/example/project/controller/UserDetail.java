package com.example.project.controller;

import com.example.project.entity.Userinfo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetail extends User {
    private final Userinfo user;

    public UserDetail(Userinfo user, Collection<? extends GrantedAuthority> authorities){
        super(user.getUserid(), user.getUserpw(), authorities);
        this.user = user;
    }

    public Userinfo getUser(){
        return user;
    }
}
