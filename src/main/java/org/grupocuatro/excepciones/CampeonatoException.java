package org.grupocuatro.excepciones;

import java.io.Serializable;

public class CampeonatoException extends Exception {

    private static final long serialVersionUID = 7932868764027141L;

    public CampeonatoException(String mensaje) {
        super(mensaje);
    }
}
