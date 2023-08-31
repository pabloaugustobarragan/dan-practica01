package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Docente;

public interface DocenteService {
    public Docente guardarDocente(Docente a) throws RecursoNoEncontrado;
    public Optional<Docente> buscarDocentePorId(Integer id) throws RecursoNoEncontrado;
    public List<Docente> listarDocentes();
    public void bajaDocente(Integer id) throws RecursoNoEncontrado;
}
