package org.grupocuatro.modelo;

import org.grupocuatro.dao.ListadoJugadoresDeshabilitadosDao;
import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jugadoresDeshabilitados")
@IdClass(ListaJugadoresDeshabilitadosPK.class)
public class ListadoJugadoresDeshabilitados implements Serializable {

    private static final long serialVersionUID = 8499657983180636586L;

    @Id
    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador jugador;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCampeonato")
    private Campeonato campeonato;

    public ListadoJugadoresDeshabilitados(Jugador jugador, Campeonato campeonato) {
        this.jugador = jugador;
        this.campeonato = campeonato;
    }

    public ListadoJugadoresDeshabilitados() {}

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public String toString() {
        return "ListadoJugadoresDeshabilitados{" +
                "jugador=" + jugador +
                ", campeonato=" + campeonato +
                '}';
    }

    public void save() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();}

    public void update() {ListadoJugadoresDeshabilitadosDao.getInstancia().update(this);}

    public void delete() {ListadoJugadoresDeshabilitadosDao.getInstancia().delete(this);}

}
