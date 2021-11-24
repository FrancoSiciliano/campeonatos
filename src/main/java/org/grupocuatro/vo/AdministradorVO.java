package org.grupocuatro.vo;

import java.io.Serializable;

public class AdministradorVO implements Serializable {

    private static final long serialVersionUID = 4817207724799457049L;
    private Integer idAdmin;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private Integer documento;
    private String mail;
    private String password;

    public AdministradorVO(){}

    public AdministradorVO(Integer idAdmin, String nombre, String apellido, String tipoDocumento, Integer documento, String mail, String password) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.mail = mail;
        this.password = password;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
