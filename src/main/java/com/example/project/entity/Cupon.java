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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuponno;

    private String name, cont, type;
    private int discount, maxnum;
    private LocalDateTime startdate, enddate;

    @JoinColumn(name = "fk_category_no")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "cupon")
    private List<Usercupon> usercupons;

}
