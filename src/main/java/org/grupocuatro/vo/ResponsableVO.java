package org.grupocuatro.vo;

import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Responsable;

import java.io.Serializable;

public class ResponsableVO implements Serializable {
    private static final long serialVersionUID = 3961795476483321233L;

    private Integer legajo;
    private Integer documento;
    private String nombre;
    private String apellido;
    private ClubVO club;
    private String mail;
    private String password;

    public ResponsableVO() {
    }

    public ResponsableVO(Integer legajo, Integer documento, String nombre, String apellido, String mail, String password, ClubVO club) {
        this.legajo = legajo;
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
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

    public ClubVO getClub() {
        return club;
    }

    public void setClub(ClubVO club) {
        this.club = club;
    }

    public Responsable toModelo() {
        try {
            Responsable resp = ResponsableDao.getInstancia().getResponsable(legajo);
            return resp;
        } catch (ResponsableException e) {
            return new Responsable(documento, nombre, apellido, club.toModelo(), mail, password);
        }

    }

    @Override
    public String toString() {
        return "ResponsableVO{" +
                "legajo=" + legajo +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", club=" + club +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
