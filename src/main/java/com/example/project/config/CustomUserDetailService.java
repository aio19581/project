package com.example.project.config;

import com.example.project.entity.Userinfo;
import com.example.project.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder pwEncoder;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

        Userinfo user = userRepository.findByuserid(userid);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserid(),user.getUserpw(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRoles()))
        );

    }
}
