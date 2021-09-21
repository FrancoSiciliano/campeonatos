package org.grupocuatro.vo;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

public class JugadorVO implements Serializable {
    private static final long serialVersionUID = -5107004978447553182L;
    private Integer idJugador;
    private String tipoDocumento;
    private Integer documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String mail;
    private String telefono;
    private int categoria;
    private boolean estado;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
}
