package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookmarkno;

    @JoinColumn(name = "fk_user_no")
    @ManyToOne
    private Userinfo userinfo;

    @JoinColumn(name="fk_store_no")
    @ManyToOne
    private Store store;
}
