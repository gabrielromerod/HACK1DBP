package com.example.dbphack1.controllers;


import com.example.dbphack1.model.Alumno;
import com.example.dbphack1.respository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;


    @GetMapping
    public ResponseEntity<List<Alumno>> getAll() {

        List<Alumno> alumno =  alumnoRepository.findAll();
        if (alumno.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(alumno);

    }

    @PostMapping("/")
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        Alumno alumnoCreated = alumnoRepository.save(alumno);

        return ResponseEntity.status(201).body(alumnoCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        Alumno alumno =  alumnoRepository.findById(id).orElse(null);

        if (alumno == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(alumno);

    }



}
