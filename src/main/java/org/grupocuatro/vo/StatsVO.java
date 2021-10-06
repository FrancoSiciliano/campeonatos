package org.grupocuatro.vo;

import java.io.Serializable;

public class StatsVO implements Serializable {
    private static final long serialVersionID = 3961852476412385233L;

    private Integer idJugador;
    private String nombreJugador;
    private String apellido;
    private Integer idCampeonato;
    private String descripcion;
    private Integer idClub;
    private String nombreClub;
    private int cantGoles;
    private int cantRojas;
    private int cantAmarillas;
    private int cantJugados;

    public StatsVO(){}

    public StatsVO(int cantGoles, int cantRojas, int cantAmarillas, int cantJugados, Integer idJugador, String nombre,
                   String apellido, Integer idCampeonato, String descripcion, Integer idClub, String nombreClub) {
        this.idJugador = idJugador;
        this.nombreJugador = nombre;
        this.apellido = apellido;
        this.idCampeonato = idCampeonato;
        this.descripcion = descripcion;
        this.idClub = idClub;
        this.nombreClub = nombreClub;
        this.cantGoles = cantGoles;
        this.cantRojas = cantRojas;
        this.cantAmarillas = cantAmarillas;
        this.cantJugados = cantJugados;
    }

    public StatsVO(int cantGoles, int cantRojas, int cantAmarillas, int cantJugados, Integer idJugador, String nombre,
                   String apellido, Integer idClub, String nombreClub) {
        this.idJugador = idJugador;
        this.nombreJugador = nombre;
        this.apellido = apellido;
        this.idClub = idClub;
        this.nombreClub = nombreClub;
        this.cantGoles = cantGoles;
        this.cantRojas = cantRojas;
        this.cantAmarillas = cantAmarillas;
        this.cantJugados = cantJugados;
    }

    public Integer getIdJugador() {return idJugador;}

    public void setIdJugador(Integer idJugador) {this.idJugador = idJugador;}

    public String getNombreJugador() {return nombreJugador;}

    public void setNombreJugador(String nombreJugador) {this.nombreJugador = nombreJugador;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public Integer getIdCampeonato() {return idCampeonato;}

    public void setIdCampeonato(Integer idCampeonato) {this.idCampeonato = idCampeonato;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Integer getIdClub() {return idClub;}

    public void setIdClub(Integer idClub) {this.idClub = idClub;}

    public String getNombreClub() {return nombreClub;}

    public void setNombreClub(String nombreClub) {this.nombreClub = nombreClub;}

    public int getCantGoles() {return cantGoles;}

    public void setCantGoles(int cantGoles) {this.cantGoles = cantGoles;}

    public int getCantRojas() {return cantRojas;}

    public void setCantRojas(int cantRojas) {this.cantRojas = cantRojas;}

    public int getCantAmarillas() {return cantAmarillas;}

    public void setCantAmarillas(int cantAmarillas) {this.cantAmarillas = cantAmarillas;}

    public int getCantJugados() {return cantJugados;}

    public void setCantJugados(int cantJugados) {this.cantJugados = cantJugados;}
}
