package org.grupocuatro.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tablaPosiciones")
public class TablaPosiciones implements Serializable {

    private static final long serialVersionUID = -5832613523487497675L;

    @Id
    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club id;

    @OneToOne
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
    private float  promedio;

    public TablaPosiciones(Club id){
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

    public TablaPosiciones(){}

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato){
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
    }

    public int getCantidadEmpatados() {
        return cantidadEmpatados;
    }

    public void setCantidadEmpatados(int cantidadEmpatados) {
        this.cantidadEmpatados = cantidadEmpatados;
    }

    public int getCantidadPerdidos() {
        return cantidadPerdidos;
    }

    public void setCantidadPerdidos(int cantidadPerdidos) {
        this.cantidadPerdidos = cantidadPerdidos;
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
}
