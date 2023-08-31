package isi.dan.practicas.practica1.service;

import java.util.ArrayList;
import java.util.List;

import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

public class MemoryDB {
    private Integer idInicialAlumno;
    private Integer idInicialDocente;
    private Integer idInicialCurso;

    private List<Alumno> alumnos;
    private List<Docente> docentes;
    private List<Curso> cursos;


    public MemoryDB(){

        this.alumnos = new ArrayList<>();
        this.docentes = new ArrayList<>();
        this.cursos = new ArrayList<>();

        this.idInicialAlumno = 0;
        this.idInicialDocente = 0;
        this.idInicialCurso = 0;

    }


    public List<Alumno> getAlumnos() { return alumnos;  }
    public List<Docente> getDocentes() { return docentes;  }
    public List<Curso> getCursos() { return cursos;  }


    public Integer nextIdAlumno(){
        this.idInicialAlumno++;
        return this.idInicialAlumno;
    }
    public Integer nextIdDocente(){
        this.idInicialDocente++;
        return this.idInicialDocente;
    }
    public Integer nextIdCurso(){
        this.idInicialCurso++;
        return this.idInicialCurso;
    }
}
