package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    // public static Integer ID_ALUMNO = 0;
    // public static List<Alumno> listaAlumnos = new ArrayList<>();

    @Autowired private MemoryDB memoryDB;

    public AlumnoServiceImpl() {
        
    }

    @Override
    public Alumno guardarAlumno(Alumno a) throws RecursoNoEncontrado {
        if ( a.getId() == null || a.getId() <= 0 ) {
            a.setId(memoryDB.nextIdAlumno());
            memoryDB.getAlumnos().add(a);
        } else {
            OptionalInt indexOpt = IntStream.range(0, memoryDB.getAlumnos().size())
                .filter(i -> memoryDB.getAlumnos().get(i).getId().equals(a.getId()))
                .findFirst();
            if ( indexOpt.isPresent() ) {
                memoryDB.getAlumnos().set(indexOpt.getAsInt(), a);
            } else {
                throw new RecursoNoEncontrado("Alumno", a.getId());
            }
        }
        return a;
    }

    @Override
    public Optional<Alumno> buscarAlumnoPorId(Integer id) throws RecursoNoEncontrado {
        Optional<Alumno> alumno = memoryDB.getAlumnos().stream().filter(i -> i.getId() == id).findFirst();
        if ( alumno.isPresent() ) return alumno;
        throw new RecursoNoEncontrado("Alumno", id);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return memoryDB.getAlumnos();
    }

    @Override
    public void bajaAlumno(Integer id) throws RecursoNoEncontrado {
        OptionalInt indexOpt = IntStream.range(0, memoryDB.getAlumnos().size())
            .filter(i -> memoryDB.getAlumnos().get(i).getId().equals(id))
            .findFirst();
        if ( indexOpt.isPresent() ) {
            memoryDB.getAlumnos().remove(indexOpt.getAsInt());
        } else {
            throw new RecursoNoEncontrado("Alumno", id);
        }
    }

    @Override
    public List<Curso> listarCursosInscriptos(Alumno a) throws RecursoNoEncontrado {
        OptionalInt indexOpt = IntStream.range(0, memoryDB.getAlumnos().size())
            .filter(i -> memoryDB.getAlumnos().get(i).getId().equals(a.getId()))
            .findFirst();

        if ( indexOpt.isPresent() ) {
            return memoryDB.getAlumnos().get(indexOpt.getAsInt()).getCursosInscriptos();
        } else {
            throw new RecursoNoEncontrado("Alumno", a.getId());
        }
    }

    
    
}
