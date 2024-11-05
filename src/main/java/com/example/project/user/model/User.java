package com.example.project.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private int no; //pk num
    @Column(nullable = false)
    private String userid, userpw, name, nick;
    private String addr, addr2;
    private String email;
    private String phone;
    private int point;
}
