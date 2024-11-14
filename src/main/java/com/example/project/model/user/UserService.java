package com.example.project.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private UserRepository repo;

    //등록된 id 확인용
    public boolean duplicateCheck(String id){
        return (repo.findByuserid(id) != null);
    }

}
