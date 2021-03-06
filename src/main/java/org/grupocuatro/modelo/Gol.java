package org.grupocuatro.modelo;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.vo.GolVO;

import javax.persistence.*;

@Entity
@Table(name = "goles")
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGol")
    private Integer idGol;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "idPartido")
    private Partido partido;

    private int minuto;

    @Column(name = "sentido")
    private String tipo;

    public Gol(Jugador jugador, Partido partido, int minuto, String tipo) {
        this.setIdGol(null);
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public Gol() {
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getIdGol() {
        return idGol;
    }

    public void setIdGol(Integer idGol) {
        this.idGol = idGol;
    }

    public void save() {
        GolDao.getInstancia().save(this);
    }

    public void update() {
        GolDao.getInstancia().update(this);
    }

    public void delete() { GolDao.getInstancia().delete(this);}

    public GolVO toVO() {
        return new GolVO(idGol, jugador.toVO(), partido.toVO(), minuto, tipo);
    }

    @Override
    public String toString() {
        return "Gol{" +
                "idGol=" + idGol +
                ", jugador=" + jugador +
                ", partido=" + partido +
                ", minuto=" + minuto +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
