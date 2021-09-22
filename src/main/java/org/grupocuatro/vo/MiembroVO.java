package org.grupocuatro.vo;

import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import java.io.Serializable;

public class MiembroVO implements Serializable {
    private static final long serialVersionUID = -6082746758958583939L;

    private Integer idLista;
    private ClubVO club;
    private PartidoVO partido;
    private JugadorVO jugador;
    private Integer ingreso;
    private Integer egreso;


    public MiembroVO (){}

    public MiembroVO(Integer idLista, ClubVO club, PartidoVO partido, JugadorVO jugador, Integer ingreso, Integer egreso) {
        this.idLista = idLista;
        this.club = club;
        this.partido = partido;
        this.jugador = jugador;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public Integer getIdLista() {return idLista;}

    public void setIdLista(Integer idLista) {this.idLista = idLista;}

    public ClubVO getClub() {return club;}

    public void setClub(ClubVO club) {this.club = club;}

    public PartidoVO getPartido() {return partido;}

    public void setPartido(PartidoVO partido) {this.partido = partido;}

    public JugadorVO getJugador() {return jugador;}

    public void setJugador(JugadorVO jugador) {this.jugador = jugador;}

    public Integer getIngreso() {return ingreso;}

    public void setIngreso(Integer ingreso) {this.ingreso = ingreso;}

    public Integer getEgreso() {return egreso;}

    public void setEgreso(Integer egreso) {this.egreso = egreso;}


    @Override
    public String toString() {
        return "MiembroVO{" +
                "idLista=" + idLista +
                ", club=" + club.getNombre() +
                ", partido=" + partido +
                ", jugador=" + jugador +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                '}';
    }

    public Miembro toModelo() {
        return new Miembro(this.club.toModelo(), this.partido.toModelo(), this.jugador.toModelo());}

}
