package isi.dan.practicas.practica1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Docente;
import isi.dan.practicas.practica1.service.DocenteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/docente")
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Docente nuevo) {
        Docente creado = null;
        try {
            creado = this.docenteService.guardarDocente(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(creado);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> docentePorId(@PathVariable Integer id) {
        Optional<Docente> docente = null;
        try {
            docente = docenteService.buscarDocentePorId(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(docente.get());

    }


    @GetMapping
    public ResponseEntity<List<Docente>> todos() {
        return ResponseEntity.ok(this.docenteService.listarDocentes());
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Docente nuevo, @PathVariable Integer id){
        Docente actualizado = null;
        try {
            nuevo.setId(id);
            actualizado = this.docenteService.guardarDocente(nuevo);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) {
        try {
            this.docenteService.bajaDocente(id);
        } catch(RecursoNoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
    
}
