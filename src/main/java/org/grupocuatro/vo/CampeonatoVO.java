package org.grupocuatro.vo;

import org.grupocuatro.modelo.Campeonato;

import java.io.Serializable;
import java.time.LocalDate;

public class CampeonatoVO implements Serializable {
    private static final long serialVersionUID = -896702539183504958L;
    private Integer idCampeonato;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private String tipoCampeonato;

    public CampeonatoVO () {

    }
    public CampeonatoVO (Integer idCampeonato, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado, String tipoCampeonato) {
        this.idCampeonato = idCampeonato;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipoCampeonato = tipoCampeonato;
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(String tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public Campeonato toModelo(){
        return new Campeonato(this.descripcion, this.fechaInicio, this.fechaFin, this.estado);
    }

    @Override
    public String toString() {
        return "CampeonatoVO{" +
                "idCampeonato=" + idCampeonato +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado='" + estado + '\'' +
                ", tipoCampeonato='" + tipoCampeonato + '\'' +
                '}';
    }
}
