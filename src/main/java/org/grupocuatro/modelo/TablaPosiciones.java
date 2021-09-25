package org.grupocuatro.modelo;

import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.vo.TablaPosicionesVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tablaPosiciones")
@IdClass(TablaPosicionesPK.class)
public class TablaPosiciones implements Serializable {

    private static final long serialVersionUID = 1140126951524813662L;

    @Id
    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club id;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCampeonato")
    private Campeonato campeonato;

    private int cantidadJugados;
    private int cantidadGanados;
    private int cantidadEmpatados;
    private int cantidadPerdidos;
    private int golesFavor;
    private int golesContra;
    private int diferenciaGoles;
    private int puntos;
    private float promedio;

    public TablaPosiciones(Club id, Campeonato campeonato) {
        this.id = id;
        this.campeonato = campeonato;
        cantidadEmpatados = 0;
        cantidadGanados = 0;
        cantidadJugados = 0;
        cantidadPerdidos = 0;
        golesFavor = 0;
        golesContra = 0;
        diferenciaGoles = 0;
        puntos = 0;
        promedio = 0;
    }

    public TablaPosiciones() {
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Club getId() {
        return id;
    }

    public void setId(Club id) {
        this.id = id;
    }

    public int getCantidadJugados() {
        return cantidadJugados;
    }

    public void setCantidadJugados(int cantidadJugados) {
        this.cantidadJugados = cantidadJugados;
    }

    public int getCantidadGanados() {
        return cantidadGanados;
    }

    public void setCantidadGanados(int cantidadGanados) {
        this.cantidadGanados = cantidadGanados;
        this.cantidadJugados++;
    }

    public int getCantidadEmpatados() {
        return cantidadEmpatados;
    }

    public void setCantidadEmpatados(int cantidadEmpatados) {
        this.cantidadEmpatados = cantidadEmpatados;
        this.cantidadJugados++;
    }

    public int getCantidadPerdidos() {
        return cantidadPerdidos;
    }

    public void setCantidadPerdidos(int cantidadPerdidos) {
        this.cantidadPerdidos = cantidadPerdidos;
        this.cantidadJugados++;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void save() {
        TablaPosicionDao.getInstancia().save(this);
    }

    public void update() {
        TablaPosicionDao.getInstancia().update(this);
    }

    public TablaPosicionesVO toVO() {
        return new TablaPosicionesVO(this.id.toVO(), this.campeonato.toVO(), this.cantidadJugados, this.cantidadGanados, this.cantidadEmpatados, this.cantidadPerdidos, this.golesFavor, this.golesContra, this.diferenciaGoles, this.puntos, this.promedio);}

    @Override
    public String toString() {
        return "TablaPosiciones{" +
                "id=" + id +
                ", campeonato=" + campeonato +
                ", cantidadJugados=" + cantidadJugados +
                ", cantidadGanados=" + cantidadGanados +
                ", cantidadEmpatados=" + cantidadEmpatados +
                ", cantidadPerdidos=" + cantidadPerdidos +
                ", golesFavor=" + golesFavor +
                ", golesContra=" + golesContra +
                ", diferenciaGoles=" + diferenciaGoles +
                ", puntos=" + puntos +
                ", promedio=" + promedio +
                '}';
    }
}
