package isi.dan.practicas.practica1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.service.AlumnoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno nuevo) {
        Alumno creado = null;
        try {
            creado = this.alumnoService.guardarAlumno(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(creado);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> alumnoPorId(@PathVariable Integer id) {
        Optional<Alumno> alumno = null;
        try {
            alumno = alumnoService.buscarAlumnoPorId(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(alumno.get());

    }

    @GetMapping
    public ResponseEntity<List<Alumno>> todos() {
        return ResponseEntity.ok(this.alumnoService.listarAlumnos());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Alumno nuevo, @PathVariable Integer id){
        Alumno actualizado = null;
        try {
            nuevo.setId(id);
            actualizado = this.alumnoService.guardarAlumno(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) {
        try {
            this.alumnoService.bajaAlumno(id);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
    
}
