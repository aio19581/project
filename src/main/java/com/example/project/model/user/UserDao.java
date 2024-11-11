package com.example.project.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserRepository repo;


    //비밀번호 확인용
    public String getPass(String id){
        return repo.findByuserid(id).getUserpw();
    }

    //등록된 id 확인용
    public boolean checkId(String id){
        return (repo.findByuserid(id) != null);
    }

}
