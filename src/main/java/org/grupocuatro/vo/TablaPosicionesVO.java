package org.grupocuatro.vo;

import org.grupocuatro.modelo.TablaPosiciones;

import java.io.Serializable;

public class TablaPosicionesVO implements Serializable {
    private static final long serialVersionUID = -2208986107768590757L;

    private ClubVO id;
    private CampeonatoVO campeonato;
    private int cantidadJugados;
    private int cantidadGanados;
    private int cantidadEmpatados;
    private int cantidadPerdidos;
    private int golesFavor;
    private int golesContra;
    private int diferenciaGoles;
    private int puntos;
    private float promedio;

    public TablaPosicionesVO () {}

    public TablaPosicionesVO(ClubVO id, CampeonatoVO campeonato, int cantidadJugados, int cantidadGanados, int cantidadEmpatados, int cantidadPerdidos, int golesFavor, int golesContra, int diferenciaGoles, int puntos, float promedio) {
        this.id = id;
        this.campeonato = campeonato;
        this.cantidadJugados = cantidadJugados;
        this.cantidadGanados = cantidadGanados;
        this.cantidadEmpatados = cantidadEmpatados;
        this.cantidadPerdidos = cantidadPerdidos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.diferenciaGoles = diferenciaGoles;
        this.puntos = puntos;
        this.promedio = promedio;
    }

    public ClubVO getId() {return id;}

    public void setId(ClubVO id) {this.id = id;}

    public CampeonatoVO getCampeonato() {return campeonato;}

    public void setCampeonato(CampeonatoVO campeonato) {this.campeonato = campeonato;}

    public int getCantidadJugados() {return cantidadJugados;}

    public void setCantidadJugados(int cantidadJugados) {this.cantidadJugados = cantidadJugados;}

    public int getCantidadGanados() {return cantidadGanados;}

    public void setCantidadGanados(int cantidadGanados) {this.cantidadGanados = cantidadGanados;}

    public int getCantidadEmpatados() {return cantidadEmpatados;}

    public void setCantidadEmpatados(int cantidadEmpatados) {this.cantidadEmpatados = cantidadEmpatados;}

    public int getCantidadPerdidos() {return cantidadPerdidos;}

    public void setCantidadPerdidos(int cantidadPerdidos) {this.cantidadPerdidos = cantidadPerdidos;}

    public int getGolesFavor() {return golesFavor;}

    public void setGolesFavor(int golesFavor) {this.golesFavor = golesFavor;}

    public int getGolesContra() {return golesContra;}

    public void setGolesContra(int golesContra) {this.golesContra = golesContra;}

    public int getDiferenciaGoles() {return diferenciaGoles;}

    public void setDiferenciaGoles(int diferenciaGoles) {this.diferenciaGoles = diferenciaGoles;}

    public int getPuntos() {return puntos;}

    public void setPuntos(int puntos) {this.puntos = puntos;}

    public float getPromedio() {return promedio;}

    public void setPromedio(float promedio) {this.promedio = promedio;}

    @Override
    public String toString() {
        return "TablaPosicionesVO{" +
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

    public TablaPosiciones toModelo() {
        return new TablaPosiciones(this.id.toModelo(), this.campeonato.toModelo());
    }
}
