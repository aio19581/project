package com.example.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDao {
    @Autowired
    private MemberRepository repo;

    public List<Member> getAllData(){
        return repo.findAll();
    }
}
