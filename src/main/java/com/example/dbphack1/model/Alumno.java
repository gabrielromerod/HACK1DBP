package com.example.dbphack1.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "alumnos", schema="dbp-hckt1")
public class Alumno {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;
    @Column(name = "last_name",nullable = false, length = 255)
    private String lastName;

    @Column(name = "code",nullable = false, length = 50, unique = true)
    private String code;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();
}