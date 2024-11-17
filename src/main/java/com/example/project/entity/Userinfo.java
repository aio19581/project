package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Userinfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userno;
    @Column(nullable = false)
    private String userid, userpw, name, nick;
    private String addr;
    @Column(columnDefinition = "TEXT")
    private String addr2;
    private String email;
    private String phone;
    private int point;
    private LocalDateTime regdate;
    private String roles;

    @OneToMany(mappedBy = "userinfo")
    private List<BookMark> bookMarks;

    @OneToMany(mappedBy = "userinfo")
    private List<Review> reviews;

    @OneToMany(mappedBy = "userinfo")
    private List<Usercupon> usercupons;

    @PrePersist
    public void setData(){
        this.regdate = LocalDateTime.now();
        this.roles = "USER";
    }

}
