package isi.dan.practicas.practica1.dao;

import java.util.List;

import isi.dan.practicas.practica1.model.Alumno;

public interface AlumnoDao {
    void insert(Alumno alumno);
    void insert(Iterable<Alumno> alumnos);
    void update(Alumno alumno);
    void delete(Alumno alumno);
    Alumno findById(Integer id);
    List<Alumno> findAll();
}
