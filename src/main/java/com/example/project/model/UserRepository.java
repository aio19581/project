package com.example.project.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    //비밀번호 확인용
    User findByuserid(String id);
}
