package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Docente;

@Service
public class DocenteServiceImpl implements DocenteService {

    // public static Integer ID_ALUMNO = 0;
    // public static List<Docente> listaDocentes = new ArrayList<>();

    @Autowired private MemoryDB memoryDB;

    public DocenteServiceImpl() {
        
    }

    @Override
    public Docente guardarDocente(Docente a) throws RecursoNoEncontrado {
        if ( a.getId() == null || a.getId() <= 0 ) {
            a.setId(memoryDB.nextIdDocente());
            memoryDB.getDocentes().add(a);
        } else {
            OptionalInt indexOpt = IntStream.range(0, memoryDB.getDocentes().size())
                .filter(i -> memoryDB.getDocentes().get(i).getId().equals(a.getId()))
                .findFirst();
            if ( indexOpt.isPresent() ) {
                memoryDB.getDocentes().set(indexOpt.getAsInt(), a);
            } else {
                throw new RecursoNoEncontrado("Docente", a.getId());
            }
        }
        return a;
    }

    @Override
    public Optional<Docente> buscarDocentePorId(Integer id) throws RecursoNoEncontrado {
        Optional<Docente> docente = memoryDB.getDocentes().stream().filter(i -> i.getId() == id).findFirst();
        if ( docente.isPresent() ) return docente;
        throw new RecursoNoEncontrado("Docente", id);
    }

    @Override
    public List<Docente> listarDocentes() {
        return memoryDB.getDocentes();
    }

    @Override
    public void bajaDocente(Integer id) throws RecursoNoEncontrado {
        OptionalInt indexOpt = IntStream.range(0, memoryDB.getDocentes().size())
            .filter(i -> memoryDB.getDocentes().get(i).getId().equals(id))
            .findFirst();
        if ( indexOpt.isPresent() ) {
            memoryDB.getDocentes().remove(indexOpt.getAsInt());
        } else {
            throw new RecursoNoEncontrado("Docente", id);
        }
    }   
    
}
