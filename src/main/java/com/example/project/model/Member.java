package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    private int membernum;

    private String memberid, memberpw, membername, birth, phone, email, nickname, address;
    private boolean memberout;
    private Date regdate;

}
