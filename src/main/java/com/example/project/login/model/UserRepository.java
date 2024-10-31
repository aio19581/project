package com.example.project.login.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //비밀번호 확인용
    User findByuserid(String id);
}
