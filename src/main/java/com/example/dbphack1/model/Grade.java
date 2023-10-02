package com.example.dbphack1.model;


import jakarta.persistence.*;


@Entity
@Table(name = "grade", schema="dbp_hckt1")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;

    @Column(name = "score",nullable = false, unique = true)
    private Long score;

//    @ManyToOne(mappedBy = "alumno")
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    public Grade() {
    }

    public Grade(int id, Long score, Alumno alumno) {
        this.id = id;
        this.score = score;
        this.alumno = alumno;
    }

    public int getId() {
        return id;
    }

    public Long getScore() {
        return score;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}