package isi.dan.practicas.practica1.exception;

public class DocenteExcedidoException  extends Exception {
    public DocenteExcedidoException() {
        super("El docente alcanzó a la cantidad máxima de curso que puede dictar.");
    }
}
