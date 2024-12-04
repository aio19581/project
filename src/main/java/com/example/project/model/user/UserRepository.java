package com.example.project.model.user;

import com.example.project.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userinfo,Integer> {

    Userinfo findByuserid(String id);
    Userinfo findBynick(String nick);

    Userinfo findByUserid(String userid);
}
