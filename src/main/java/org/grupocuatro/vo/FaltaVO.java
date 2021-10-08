package org.grupocuatro.vo;

import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Jugador;

import java.io.Serializable;

public class FaltaVO implements Serializable {
    private static final long serialVersionUID = 3396654674923190297L;

    private Integer idFalta;
    private JugadorVO jugador;
    private PartidoVO partido;
    private int minuto;
    private String tipo;

    public FaltaVO() {
    }

    public FaltaVO(Integer idFalta, JugadorVO jugador, PartidoVO partido, int minuto, String tipo) {
        this.idFalta = idFalta;
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public Integer getIdFalta() {
        return idFalta;
    }

    public void setIdFalta(Integer idFalta) {
        this.idFalta = idFalta;
    }

    public JugadorVO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorVO jugador) {
        this.jugador = jugador;
    }

    public PartidoVO getPartido() {
        return partido;
    }

    public void setPartido(PartidoVO partido) {
        this.partido = partido;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Falta toModelo() {
        Falta f = FaltaDao.getInstancia().traerFalta(jugador.getIdJugador(), partido.getIdPartido(), minuto, tipo);
        if(f == null)
            return new Falta(jugador.toModelo(), partido.toModelo(), minuto, tipo);
        return f;
    }

    @Override
    public String toString() {
        return "FaltaVO{" +
                "idFalta=" + idFalta +
                ", jugador=" + jugador +
                ", partido=" + partido +
                ", minuto=" + minuto +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
