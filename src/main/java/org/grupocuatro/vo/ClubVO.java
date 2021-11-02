package org.grupocuatro.vo;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;

import java.io.Serializable;

public class ClubVO implements Serializable {
    private static final long serialVersionUID = -3992516389781773354L;
    private Integer idClub;
    private String nombre;
    private String direccion;

    public ClubVO(){

    }
    public ClubVO (int idClub, String nombre, String direccion) {
        this.idClub = idClub;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Club toModelo(){
        try {
            Club club = ClubDao.getInstancia().getClubById(this.idClub);
            return club;
        } catch (ClubException e) {
            return new Club(this.idClub, this.nombre, this.direccion);
        }
    }

    @Override
    public String toString() {
        return "ClubVO{" +
                "idClub=" + idClub +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
