package isi.dan.practicas.practica1.exception;

public class RecursoNoEncontrado extends Exception {
    public RecursoNoEncontrado(String message, Integer id) {
        super("No existe el identificador " + id + " del modelo " + message);
    }
}
