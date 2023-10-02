package com.example.dbphack1.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "alumnos", schema="dbp_hckt1")
public class Alumno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;

    @Column(name = "last_name",nullable = false, length = 255)
    private String lastName;

    @Column(name = "code",nullable = false, length = 50, unique = true)
    private String code;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

public Alumno() {
    }

    public Alumno(int id, String lastName, String code, List<Grade> grades) {
        this.id = id;
        this.lastName = lastName;
        this.code = code;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}