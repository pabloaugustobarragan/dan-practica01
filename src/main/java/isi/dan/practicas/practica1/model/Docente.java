package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

public class Docente {
    private Integer id;
    private String nombre;
    private Double salario;
    private List<Curso> cursosDictados;

    public Docente() {
        this.cursosDictados = new ArrayList<>();
    }

    public Docente(Integer id) {
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Curso> getCursosDictados() {
        return cursosDictados;
    }

    public void setCursosDictados(List<Curso> cursosDictados) {
        this.cursosDictados = cursosDictados;
    }

    public void addCursosDictados(Curso curso) {
        this.cursosDictados.add(curso);
    }

    
}
