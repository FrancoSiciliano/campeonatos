package org.grupocuatro.modelo;

import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.utiles.EntityManagerUtil;
import org.grupocuatro.vo.MiembroVO;

import javax.persistence.*;

@Entity
@Table(name = "listaJugadoresPartido")
public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLista")
    private Integer idLista;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "idPartido")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    private Integer ingreso;
    private Integer egreso;


    public Miembro(Club club, Partido partido, Jugador jugador) {
        this.club = club;
        this.partido = partido;
        this.jugador = jugador;
        this.ingreso = null;
        this.egreso = null;
    }

    public Miembro(Club club, Partido partido) {
        this.club = club;
        this.partido = partido;
        this.jugador = null;
        this.ingreso = null;
        this.egreso = null;
    }


    public Miembro() {
    }

    public Integer getIdLista() {
        return idLista;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public Integer getEgreso() {
        return egreso;
    }

    public void setEgreso(Integer egreso) {this.egreso = egreso;}

    public void save() {
        MiembroDao.getInstancia().save(this);
    }

    public void update() {
        MiembroDao.getInstancia().update(this);
    }

    public void delete() { MiembroDao.getInstancia().delete(this); }
    @Override
    public String toString() {
        return "Miembro{" +
                "idLista=" + idLista +
                ", club=" + club +
                ", partido=" + partido +
                ", jugador=" + jugador +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                '}';
    }

    public MiembroVO toVO() {
        return new MiembroVO(this.idLista, this.getClub().toVO(), this.getPartido().toVO(), this.getJugador().toVO(), this.ingreso, this.egreso);
    }

}
