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
    private ClubVO club;

    public ResponsableVO() {
    }

    public ResponsableVO(Integer legajo, Integer documento, String nombre, ClubVO club) {
        this.legajo = legajo;
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
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

    public ClubVO getClub() {
        return club;
    }

    public void setClub(ClubVO club) {
        this.club = club;
    }

    public Responsable toModelo() {
        try {
            Responsable resp = ResponsableDao.getInstancia().getResponsableByNroDocAndClub(documento, club.getIdClub());
            return resp;
        } catch (ResponsableException e) {
            return new Responsable(documento, nombre, club.toModelo());
        }

    }

    @Override
    public String toString() {
        return "ResponsableVO{" +
                "legajo=" + legajo +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", club=" + club +
                '}';
    }
}
