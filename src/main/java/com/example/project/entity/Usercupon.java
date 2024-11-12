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
public class Usercupon {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int usercuponno;

    @JoinColumn(name="fk_user_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Userinfo userinfo;

    @JoinColumn(name="fk_cupon_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cupon cupon;
}
