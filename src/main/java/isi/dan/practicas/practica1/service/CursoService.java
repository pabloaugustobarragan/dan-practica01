package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Curso;

public interface CursoService {
    public Curso guardarCurso(Curso a) throws RecursoNoEncontrado;
    public Optional<Curso> buscarCursoPorId(Integer id) throws RecursoNoEncontrado;
    public List<Curso> listarCursos();
    public void bajaCurso(Integer id) throws RecursoNoEncontrado;
}
