package org.grupocuatro.modelo;


import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.vo.ClubVO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubes")
public class Club implements Comparable<Club> {

    @Id
    @Column(name = "idClub")
    private Integer idClub;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "club")
    private List<Responsable> responsables;

    @OneToMany(mappedBy = "club")
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "idCampeonato")
    private List<Campeonato> participaciones;

    @OneToMany(mappedBy = "clubLocal")
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "clubVisitante")
    private List<Partido> partidosVisitante;

    @OneToMany(mappedBy = "club")
    private List<Miembro> miembros;

    @OneToMany(mappedBy = "id")
    private List<TablaPosiciones> tablasPosiciones;


    public Club(int idClub, String nombre, String direccion) {
        this.idClub = idClub;
        this.nombre = nombre;
        this.direccion = direccion;
        jugadores = new ArrayList<Jugador>();
    }

    public Club() {
        participaciones = new ArrayList<>();
        partidosVisitante = new ArrayList<>();
        miembros = new ArrayList<>();
        partidosLocal = new ArrayList<>();
        tablasPosiciones = new ArrayList<>();
    }

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public Integer getIdClub() {
        return idClub;
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

    public List<Responsable> getResponsable() {
        return responsables;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public int compareTo(Club o) {
        return this.getIdClub().compareTo(o.getIdClub());
    }

    public void save() {
        ClubDao.getInstancia().save(this);
    }

    public void update() {
        ClubDao.getInstancia().update(this);
    }

    @Override
    public String toString() {
        return "Club{" +
                "idClub=" + idClub +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public ClubVO toVO(){
        return new ClubVO(this.idClub, this.nombre, this.direccion);
    }
}
