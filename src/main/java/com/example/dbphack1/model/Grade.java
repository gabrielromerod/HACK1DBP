package com.example.dbphack1.model;


import jakarta.persistence.*;


@Entity
@Table(name = "grade", schema="dbp-hckt1")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;

    @Column(name = "score",nullable = false, unique = true)
    private Long score;

//    @ManyToOne(mappedBy = "alumno")
    @Column(name = "alumno_id", nullable = false, unique = true)
    private int alumnoId;



}