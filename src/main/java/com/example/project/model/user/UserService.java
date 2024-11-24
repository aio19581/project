package com.example.project.model.user;

import com.example.project.controller.user.UserBean;
import com.example.project.dto.UserDto;
import com.example.project.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private BCryptPasswordEncoder pwEncoder;

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

    //회원가입
    public void joinUser(UserBean bean){

        UserDto dto = UserBean.toDto(bean);
        Userinfo info = Userinfo.builder()
            .userno(dto.getUserno())
            .userid(dto.getUserid())
            .userpw(pwEncoder.encode(dto.getUserpw()))
            .name(dto.getName())
            .nick(dto.getNick())
            .addr(dto.getAddr())
            .addr2(dto.getAddr2())
            .email(dto.getEmail())
            .phone(dto.getPhone())
            .point(dto.getPoint())
            .build();

        repo.save(info);
    }
}
