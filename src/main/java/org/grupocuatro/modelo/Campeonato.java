package org.grupocuatro.modelo;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.vo.CampeonatoVO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "campeonatos")
public class Campeonato implements Comparable<Campeonato> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCampeonato")
    private Integer idCampeonato;

    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private String tipoCampeonato;

    @OneToMany(mappedBy = "idClub")
    private List<Club> inscriptos;

    @OneToMany(mappedBy = "campeonato")
    private List<Partido> partidos;


    @OneToMany(mappedBy = "campeonato")
    private List<TablaPosiciones> tablaPosiciones;

    public Campeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.idCampeonato = null;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipoCampeonato = "";
    }

    public Campeonato() {
        partidos = new ArrayList<>();
        inscriptos = new ArrayList<>();
        tablaPosiciones = new ArrayList<>();
    }

    public List<TablaPosiciones> getTablaPosiciones() {
        return tablaPosiciones;
    }

    public void setTablaPosiciones(List<TablaPosiciones> tablaPosiciones) {
        this.tablaPosiciones = tablaPosiciones;
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(String tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int compareTo(Campeonato o) {
        return this.getIdCampeonato().compareTo(o.getIdCampeonato());
    }

    public void save() {
        CampeonatoDao.getInstancia().save(this);
    }

    public void update() {
        CampeonatoDao.getInstancia().update(this);
    }

    public long calcularDuracionCampeonato (){
        return DAYS.between(this.fechaInicio, this.fechaFin);
    }

    public boolean estaEnLaFecha(LocalDate fecha) {
        return (fecha.isEqual(this.fechaInicio) || fecha.isEqual(this.fechaFin)) || (fecha.isAfter(this.fechaInicio) && fecha.isBefore(this.fechaFin));
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "idCampeonato=" + idCampeonato +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado='" + estado + '\'' +
                ", tipoCampeonato='" + tipoCampeonato + '\'' +
                '}';
    }

    public CampeonatoVO toVO(){
        return new CampeonatoVO(this.idCampeonato,this.descripcion,this.fechaInicio,this.fechaFin,this.estado, this.tipoCampeonato);
    }
}
