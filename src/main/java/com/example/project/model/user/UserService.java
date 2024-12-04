package com.example.project.model.user;

import com.example.project.controller.user.UserBean;
import com.example.project.dto.UserDto;
import com.example.project.entity.Userinfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private BCryptPasswordEncoder pwEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //등록된 id 확인용
    public boolean duplicateIdCheck(String id){
        return (repo.findByuserid(id) != null);
    }

    //등록된 nick 확인용
    public boolean duplicateNickCheck(String nick){
        return (repo.findBynick(nick) != null);
    }

    //주소
    public String getAddr(String id){
        return repo.findByuserid(id).getAddr();
    }

    //User정보 반환
    public Userinfo getUser(String id){
        return userRepository.findByuserid(id);
    }

}
