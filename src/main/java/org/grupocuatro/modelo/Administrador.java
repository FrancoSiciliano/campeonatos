package org.grupocuatro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private Integer documento;
    private String mail;

    public Administrador(){}

    public Administrador(String nombre, String apellido, String tipoDocumento, Integer documento, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.mail = mail;
    }

    public Integer getIdAdmin() {return idAdmin;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getTipoDocumento() {return tipoDocumento;}

    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}

    public Integer getDocumento() {return documento;}

    public void setDocumento(Integer documento) {this.documento = documento;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}
}
