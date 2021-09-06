package org.grupocuatro.dao;


import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.modelo.Falta;

import javax.persistence.NoResultException;
import java.util.List;

public class FaltaDao extends AbstractDao {

    private static FaltaDao instancia;

    private FaltaDao() {
    }

    public static FaltaDao getInstancia() {
        if (instancia == null) instancia = new FaltaDao();
        return instancia;
    }

    public List<Falta> getFaltas() throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("SELECT f FROM Falta f").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No existen faltas");
    }

    public Falta getFaltaById(Integer id) throws FaltaException {
        try {
            Falta falta = (Falta) getEntityManager().createQuery("FROM Falta WHERE idFalta = " + id).getSingleResult();
            return falta;
        } catch (NoResultException e) {
            throw new FaltaException("No existe una falta con id: " + id);
        }

    }

    public List<Falta> getFaltasByJugador(Integer id) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + id).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("El jugador de id " + id + " no posee faltas");
    }

    public List<Falta> getFaltasByCampeonato(Integer campeonato) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idCampeonato = " + campeonato).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas en el campeonato de id " + campeonato);
    }

    public List<Falta> getFaltasByPartido(Integer partido) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido =" + partido).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas en el partido de id " + partido);
    }

    public List<Falta> getFaltasByTipo(String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE tipo = " + tipo).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No existen faltas del tipo " + tipo);
    }

    public List<Falta> getFaltaByMinuto(Integer min) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE miuto = " + min).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas en el minuto " + min);
    }

    public List<Falta> getFaltasByJugadorAndPartido(Integer jugador, Integer partido) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idPartido = " + partido).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador de id " + jugador + " en el partido " + partido);
    }

    public List<Falta> getFaltasByJugadorAndTipo(Integer jugador, String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " and tipo = " + tipo).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("El jugador de id " + jugador + " no posee faltas del tipo " + tipo);
    }

    public List<Falta> getFaltasByJugadorAndCampeonato(Integer jugador, Integer campeonato) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idCampeonato = " + campeonato).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador " + jugador + " y campeonato " + campeonato);
    }

    public List<Falta> getFaltasByJugadorAndTipoAndPartido(Integer jugador, Integer partido, String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " and idPartido = " + partido + " and tipo = " + tipo).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("El jugador de id " + jugador + " de tipo " + tipo + " en el partido de id " + partido);
    }

    public List<Falta> getFaltasByJugadorAndTipoAndPartidoAndCampeonato(Integer jugador, Integer partido, String tipo, Integer campeonato) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idPartido = " + partido + " AND tipo = " + tipo + " AND idCampeonato = " + campeonato).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador " + jugador + ", partido " + partido + ", tipo " + tipo + " y campeonato " + campeonato);

    }

    public List<Falta> getFaltasByTipoAndPartido(Integer partido, String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido = " + partido + " AND tipo = " + tipo).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al partido " + partido + " y tipo " + tipo);

    }

}
