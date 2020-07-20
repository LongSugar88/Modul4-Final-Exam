package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String national;
    private Long area;
    private Long popular;
    private Long gpd;
    @Column(columnDefinition = "TEXT")
    private String describer;
}
