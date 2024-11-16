package com.example.project.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private UserRepository repo;

    //등록된 id 확인용
    public boolean duplicateIdCheck(String id){
        return (repo.findByuserid(id) != null);
    }

    //등록된 nick 확인용
    public boolean duplicateNickCheck(String nick){
        return (repo.findBynick(nick) != null);
    }
}
