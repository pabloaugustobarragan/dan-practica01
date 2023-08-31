package isi.dan.practicas.practica1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.service.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Curso nuevo) {
        Curso creado = null;
        try {
            creado = this.cursoService.guardarCurso(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(creado);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> cursoPorId(@PathVariable Integer id) {
        Optional<Curso> curso = null;
        try {
            curso = cursoService.buscarCursoPorId(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(curso.get());

    }


    @GetMapping
    public ResponseEntity<List<Curso>> todos() {
        return ResponseEntity.ok(this.cursoService.listarCursos());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Curso nuevo, @PathVariable Integer id){
        Curso actualizado = null;
        try {
            nuevo.setId(id);
            actualizado = this.cursoService.guardarCurso(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) {
        try {
            this.cursoService.bajaCurso(id);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
    
}
