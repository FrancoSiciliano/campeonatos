package org.grupocuatro.excepciones;

public class ResponsableException extends Exception{

    private static final long serialVersionUID = 5948871692089516630L;

    public ResponsableException(String mensaje){
        super(mensaje);
    }
}
