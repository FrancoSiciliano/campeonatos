package org.grupocuatro.modelo;

import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.vo.FaltaVO;

import javax.persistence.*;

@Entity
@Table(name = "faltas")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFalta")
    private Integer idFalta;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "idPartido")
    private Partido partido;

    private int minuto;
    private String tipo;

    public Falta(Jugador jugador, Partido partido, int minuto, String tipo) {
        this.idFalta = null;
        this.jugador = jugador;
        this.partido = partido;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public Falta() {

    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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

    public String getTipo() {
        return tipo;
    }

    public Integer getIdFalta() {
        return idFalta;
    }

    public void setIdFalta(Integer idFalta) {
        this.idFalta = idFalta;
    }

    public void save() {
        FaltaDao.getInstancia().save(this);
    }

    public void update() {
        FaltaDao.getInstancia().update(this);
    }

    public FaltaVO toVO(){
        return new FaltaVO(idFalta, jugador.toVO(), partido.toVO(), minuto, tipo);
    }

    @Override
    public String toString() {
        return "Falta{" +
                "idFalta=" + idFalta +
                ", jugador=" + jugador +
                ", partido=" + partido +
                ", minuto=" + minuto +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
