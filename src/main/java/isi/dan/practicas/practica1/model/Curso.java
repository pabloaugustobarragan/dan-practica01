package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

import isi.dan.practicas.practica1.exception.DocenteExcedidoException;

public class Curso {
    private Integer id;
    private String nombre;
    private Integer creditos;
    private Docente docenteAsignado;
    private List<Alumno> listaInscriptos;

    public Curso() {
        listaInscriptos = new ArrayList<>();
    }

    public Curso(Integer id) {
        this();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Docente getDocenteAsignado() {
        return docenteAsignado;
    }

    public Integer cantidadCursosAsignado(Docente docenteAsignado) {
        return docenteAsignado.getCursosDictados().size();
    }

    public void setDocenteAsignado(Docente docenteAsignado) throws DocenteExcedidoException {
        if ( cantidadCursosAsignado(docenteAsignado) >= 3 ) {
            throw new DocenteExcedidoException();
        }
        this.docenteAsignado = docenteAsignado;
        this.docenteAsignado.addCursosDictados(this);        
    }

    public void inscribirAlumno(Alumno alumno){
        this.listaInscriptos.add(alumno);
    }

    public List<Alumno> getListaInscriptos() {
        return listaInscriptos;
    }

    public void setListaInscriptos(List<Alumno> listaInscriptos) {
        this.listaInscriptos = listaInscriptos;
    }

    
}
