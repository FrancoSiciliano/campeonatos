package org.grupocuatro.excepciones;

import java.io.Serializable;

public class JugadorException extends Exception {

    private static final long serialVersionUID = 3041353636962566203L;
    public JugadorException(String mensaje) {
        super(mensaje);
    }
}
