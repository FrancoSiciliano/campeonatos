package org.grupocuatro.vo;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Gol;

import java.io.Serializable;

public class GolVO implements Serializable {
    private static final long serialVersionUID = -6060942856938929011L;

    private Integer idGol;
    private JugadorVO jugador;
    private PartidoVO partido;
    private int minuto;
    private String tipo;

    public GolVO() {
    }

    public GolVO(Integer idGol, JugadorVO jugador, PartidoVO partido, int minuto, String tipo) {
        this.idGol = idGol;
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public Integer getIdGol() {
        return idGol;
    }

    public void setIdGol(Integer idGol) {
        this.idGol = idGol;
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

    @Override
    public String toString() {
        return "GolVO{" +
                "idGol=" + idGol +
                ", jugador=" + jugador +
                ", partido=" + partido +
                ", minuto=" + minuto +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Gol toModelo() {
        try {
            Gol gol = GolDao.getInstancia().getGolById(idGol);
            return gol;
        } catch (GolException e) {
            return new Gol(jugador.toModelo(), partido.toModelo(), minuto, tipo);
        }

    }
}
