package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Integer id;
    private String nombre;
    private Integer legajo;
    private List<Curso> cursosInscriptos;

    public Alumno() {
        cursosInscriptos = new ArrayList<>();
    }

    public Alumno(Integer id) {
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
    public Integer getLegajo() {
        return legajo;
    }
    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }
    public List<Curso> getCursosInscriptos() {
        return cursosInscriptos;
    }
    public void setCursosInscriptos(List<Curso> cursosInscriptos) {
        this.cursosInscriptos = cursosInscriptos;
    }

    
}
