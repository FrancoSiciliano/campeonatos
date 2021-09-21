package org.grupocuatro.vo;

import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

public class PartidoVO implements Serializable {
    private static final long serialVersionUID = 6457920274723649036L;
    private Integer idPartido;
    private int nroFecha;
    private int nroZona;
    private int categoria;
    private String incidentes;
    private ClubVO clubLocal;
    private ClubVO clubVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    private LocalDate fechaPartido;
    private boolean convalidaLocal;
    private boolean convalidaVisitante;
    private CampeonatoVO campeonato;

    public PartidoVO(){

    }

    public PartidoVO(Integer idPartido,int nroZona, int categoria, ClubVO clubLocal, ClubVO clubVisitante, CampeonatoVO campeonato) {
        this.idPartido = idPartido;
        this.nroZona = nroZona;
        this.nroFecha = 99;
        this.categoria = categoria;
        this.clubLocal = clubLocal;
        this.clubVisitante = clubVisitante;
        this.golesLocal = null;
        this.golesVisitante = null;
        this.convalidaLocal = false;
        this.convalidaVisitante = false;
        this.campeonato = campeonato;
        this.incidentes = "";
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public int getNroFecha() {
        return nroFecha;
    }

    public void setNroFecha(int nroFecha) {
        this.nroFecha = nroFecha;
    }

    public int getNroZona() {
        return nroZona;
    }

    public void setNroZona(int nroZona) {
        this.nroZona = nroZona;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(String incidentes) {
        this.incidentes = incidentes;
    }

    public ClubVO getClubLocal() {
        return clubLocal;
    }

    public void setClubLocal(ClubVO clubLocal) {
        this.clubLocal = clubLocal;
    }

    public ClubVO getClubVisitante() {
        return clubVisitante;
    }

    public void setClubVisitante(ClubVO clubVisitante) {
        this.clubVisitante = clubVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(LocalDate fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public boolean isConvalidaLocal() {
        return convalidaLocal;
    }

    public void setConvalidaLocal(boolean convalidaLocal) {
        this.convalidaLocal = convalidaLocal;
    }

    public boolean isConvalidaVisitante() {
        return convalidaVisitante;
    }

    public void setConvalidaVisitante(boolean convalidaVisitante) {
        this.convalidaVisitante = convalidaVisitante;
    }

    public CampeonatoVO getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(CampeonatoVO campeonato) {
        this.campeonato = campeonato;
    }

    public Partido toModelo(){
        return new Partido(this.nroZona, this.categoria, this.clubLocal.toModelo(), this.clubVisitante.toModelo(), this.campeonato.toModelo());
    }

    @Override
    public String toString() {
        return "PartidoVO{" +
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
