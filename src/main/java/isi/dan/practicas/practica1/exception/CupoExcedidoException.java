package isi.dan.practicas.practica1.exception;

public class CupoExcedidoException extends Exception {
    public CupoExcedidoException() {
        super("El curso alcanzó al cupo máximo.");
    }
}
