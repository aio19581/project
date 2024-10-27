package com.example.project.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserRepository repo;

    /*
    public String getAllData(){
        JsonObject returnObj = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        List<Member> list = repo.findAll();
        list.forEach(m -> {
            JsonObject json = new JsonObject();
            json.addProperty("id",m.getMemberid());
            json.addProperty("pw",m.getMemberpw());
            jsonArray.add(json);
        });
        returnObj.add("data",jsonArray);
        return returnObj.toString();
    }
    * */

    //비밀번호 확인용
    public User getPass(String id){
        return repo.findByuserid(id);
    }

}
