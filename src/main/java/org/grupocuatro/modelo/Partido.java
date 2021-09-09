package org.grupocuatro.modelo;


import org.grupocuatro.dao.PartidoDao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partidos")
public class Partido {

    //FIXME AGREGAR INCIDENTES


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartido")
    private Integer idPartido;
    private int nroFecha;
    private int nroZona;
    private int categoria;
    private String incidentes;

    @ManyToOne
    @JoinColumn(name = "idClubLocal")
    private Club clubLocal;

    @ManyToOne
    @JoinColumn(name = "idClubVisitante")
    private Club clubVisitante;

    private Integer golesLocal;
    private Integer golesVisitante;
    private LocalDate fechaPartido;

    @Column(name = "validadoLocal")
    private boolean convalidaLocal;

    @Column(name = "validadoVisitante")
    private boolean convalidaVisitante;

    @ManyToOne
    @JoinColumn(name = "idCampeonato")
    private Campeonato campeonato;

    @OneToMany(mappedBy = "partido")
    private List<Miembro> jugadoresLocales;

    @OneToMany(mappedBy = "partido")
    private List<Miembro> jugadoresVisitantes;

    //agregamos lista de faltas del partido
    @OneToMany(mappedBy = "partido")
    private List<Falta> faltas;

    //agregamos lista de goles del partido
    @OneToMany(mappedBy = "partido")
    private List<Gol> goles;

    public Partido(int nroFecha, int nroZona, int categoria, Club clubLocal, Club clubVisitante, LocalDate fechaPartido, Campeonato campeonato) {
        this.nroFecha = nroFecha;
        this.nroZona = nroZona;
        this.categoria = categoria;
        this.clubLocal = clubLocal;
        this.clubVisitante = clubVisitante;
        this.golesLocal = null;
        this.golesVisitante = null;
        this.fechaPartido = fechaPartido;
        this.convalidaLocal = false;
        this.convalidaVisitante = false;
        this.campeonato = campeonato;
        this.incidentes = "";
    }

    public Partido() {
        jugadoresLocales = new ArrayList<>();
        jugadoresVisitantes = new ArrayList<>();
        faltas = new ArrayList<>();
        goles = new ArrayList<>();
    }

    public String getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(String incidentes) {
        this.incidentes = incidentes;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public int getNroFecha() {
        return nroFecha;
    }

    public int getNroZona() {
        return nroZona;
    }

    public int getCategoria() {
        return categoria;
    }

    public Club getClubLocal() {
        return clubLocal;
    }

    public Club getClubVisitante() {
        return clubVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public boolean isConvalidaLocal() {
        return convalidaLocal;
    }

    public boolean isConvalidaVisitante() {
        return convalidaVisitante;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public List<Miembro> getJugadoresLocales() {
        return jugadoresLocales;
    }

    public List<Miembro> getJugadoresVisitantes() {
        return jugadoresVisitantes;
    }

    public void setNroFecha(int nroFecha) {
        this.nroFecha = nroFecha;
    }

    public void setNroZona(int nroZona) {
        this.nroZona = nroZona;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setClubLocal(Club clubLocal) {
        this.clubLocal = clubLocal;
    }

    public void setClubVisitante(Club clubVisitante) {
        this.clubVisitante = clubVisitante;
    }

    public void setFechaPartido(LocalDate fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public void setConvalidaLocal() {
        this.convalidaLocal = true;
    }

    public void setConvalidaVisitante() {
        this.convalidaVisitante = true;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public void save() {
        PartidoDao.getInstancia().save(this);
    }

    public void update() {
        PartidoDao.getInstancia().update(this);
    }

    public boolean isValidado() {
        return convalidaLocal && convalidaVisitante;
    }

    public Club getGanador() {
        return (golesLocal > golesVisitante) ? clubLocal : clubVisitante;
    }

    public Club getPerdedor() {
        return (golesLocal < golesVisitante) ? clubLocal : clubVisitante;
    }

    public boolean isEmpate() {
        return golesLocal == golesVisitante;
    }

    public int getGolesGanador () {
        return (golesLocal > golesVisitante) ? golesLocal : golesVisitante;
    }

    public int getGolesPerdedor () {
        return (golesVisitante < golesLocal) ? golesVisitante : golesLocal;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", nroFecha=" + nroFecha +
                ", nroZona=" + nroZona +
                ", categoria=" + categoria +
                ", incidentes='" + incidentes + '\'' +
                ", clubLocal=" + clubLocal +
                ", clubVisitante=" + clubVisitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", fechaPartido=" + fechaPartido +
                ", convalidaLocal=" + convalidaLocal +
                ", convalidaVisitante=" + convalidaVisitante +
                ", campeonato=" + campeonato +
                '}';
    }

}
