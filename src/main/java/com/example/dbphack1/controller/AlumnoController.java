package com.example.dbphack1.controller;


import com.example.dbphack1.model.Alumno;
import com.example.dbphack1.respository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;


    @GetMapping("/")
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> alumno =  alumnoRepository.findAll();

        return ResponseEntity.status(200).body(alumno);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable long id) {
        Alumno alumno =  alumnoRepository.findById(id).orElse(null);

        if (alumno == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(alumno);

    }

}
