package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reviewno;

    private String title, cont;
    private int scope;

    @JoinColumn(name="fk_store_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Store store;

    @JoinColumn(name="fk_user_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Userinfo userinfo;

}
