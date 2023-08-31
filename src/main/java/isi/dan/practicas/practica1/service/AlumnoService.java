package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;

public interface AlumnoService {
    public Alumno guardarAlumno(Alumno a) throws RecursoNoEncontrado;
    public Optional<Alumno> buscarAlumnoPorId(Integer id) throws RecursoNoEncontrado;
    public List<Alumno> listarAlumnos();
    public void bajaAlumno(Integer id) throws RecursoNoEncontrado;

    // Extras
    public List<Curso> listarCursosInscriptos(Alumno a) throws RecursoNoEncontrado;
}
