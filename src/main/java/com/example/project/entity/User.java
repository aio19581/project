package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userno;
    @Column(nullable = false)
    private String userid, userpw, name, nick;
    private String addr, addr2;
    private String email;
    private String phone;
    private int point;
    private LocalDateTime regdate;

    @OneToMany(mappedBy = "user")
    private List<BookMark> bookMarks;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Usercupon> usercupons;

}