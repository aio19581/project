package com.example.project.model.user;

import com.example.project.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userinfo,Integer> {

    //비밀번호 확인용
    Userinfo findByuserid(String id);
}
