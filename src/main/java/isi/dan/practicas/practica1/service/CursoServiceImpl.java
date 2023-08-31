package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {

    // public static Integer ID_ALUMNO = 0;
    // public static List<Curso> listaCursos = new ArrayList<>();

    @Autowired private MemoryDB memoryDB;

    public CursoServiceImpl() {
        
    }

    @Override
    public Curso guardarCurso(Curso a) throws RecursoNoEncontrado {
        if ( a.getId() == null || a.getId() <= 0 ) {
            a.setId(memoryDB.nextIdCurso());
            memoryDB.getCursos().add(a);
        } else {
            OptionalInt indexOpt = IntStream.range(0, memoryDB.getCursos().size())
                .filter(i -> memoryDB.getCursos().get(i).getId().equals(a.getId()))
                .findFirst();
            if ( indexOpt.isPresent() ) {
                memoryDB.getCursos().set(indexOpt.getAsInt(), a);
            } else {
                throw new RecursoNoEncontrado("Curso", a.getId());
            }
        }
        return a;
    }

    @Override
    public Optional<Curso> buscarCursoPorId(Integer id) throws RecursoNoEncontrado {
        Optional<Curso> curso = memoryDB.getCursos().stream().filter(i -> i.getId() == id).findFirst();
        if ( curso.isPresent() ) return curso;
        throw new RecursoNoEncontrado("Curso", id);
    }

    @Override
    public List<Curso> listarCursos() {
        return memoryDB.getCursos();
    }

    @Override
    public void bajaCurso(Integer id) throws RecursoNoEncontrado {
        OptionalInt indexOpt = IntStream.range(0, memoryDB.getCursos().size())
            .filter(i -> memoryDB.getCursos().get(i).getId().equals(id))
            .findFirst();
        if ( indexOpt.isPresent() ) {
            memoryDB.getCursos().remove(indexOpt.getAsInt());
        } else {
            throw new RecursoNoEncontrado("Curso", id);
        }
    }   
    
}
