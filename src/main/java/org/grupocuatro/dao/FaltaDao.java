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
            return (Falta) getEntityManager().createQuery("FROM Falta WHERE idFalta = " + id).getSingleResult();
        } catch (NoResultException e) {
            throw new FaltaException("No existe una falta con id: " + id);
        }

    }

    public List<Falta> getFaltasByJugador(Integer id) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + id).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("El jugador de id: " + id + " no posee faltas");
    }

    public List<Falta> getFaltasByCampeonato(Integer campeonato) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido IN (SELECT idPartido FROM Partido WHERE idCampeonato = " + campeonato + ") ").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas en el campeonato de id: " + campeonato);
    }

    public List<Falta> getFaltasByPartido(Integer partido) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido =" + partido).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas en el partido de id: " + partido);
    }

    public List<Falta> getFaltasByTipo(String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE tipo = '" + tipo + "'").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No existen faltas del tipo: " + tipo);
    }

    public List<Falta> getFaltasByJugadorAndPartido(Integer jugador, Integer partido) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idPartido = " + partido).getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador de id: " + jugador + " en el partido de id: " + partido);
    }

    public List<Falta> getFaltasByJugadorAndTipo(Integer jugador, String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " and tipo = '" + tipo + "'").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("El jugador de id: " + jugador + " no posee faltas del tipo: " + tipo);
    }

    public List<Falta> getFaltasByJugadorAndCampeonato(Integer jugador, Integer campeonato) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idPartido IN (SELECT idPartido FROM Partido WHERE idCampeonato = " + campeonato + ") ").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador de id: " + jugador + " y campeonato de id: " + campeonato);
    }


    public List<Falta> getFaltasByJugadorAndTipoAndPartido(Integer jugador, String tipo, Integer partido) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + jugador + " AND idPartido = " + partido + " AND tipo = '" + tipo + "'").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al jugador de id: " + jugador + " en el partido de id: " + partido + " de tipo: " + tipo);

    }

    public List<Falta> getFaltasByPartidoAndTipo(Integer partido, String tipo) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido = " + partido + " AND tipo = '" + tipo + "'").getResultList();
        if (!faltas.isEmpty()) return faltas;
        throw new FaltaException("No hay faltas correspondientes al partido de id: " + partido + " y tipo: " + tipo);

    }

    public List<Falta> getFaltasByClubAndPartido(Integer idClub, Integer Partido){
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idPartido = " + Partido + " AND idJugador IN (FROM Jugador WHERE idClub = " + idClub + ")").getResultList();
        return faltas;
    }

}
