package org.grupocuatro.excepciones;

public class MiembroException extends Exception{
    private static final long serialVersionUID = 7529151608212757570L;

    public MiembroException(String mensaje) {
        super(mensaje);
    }
}
