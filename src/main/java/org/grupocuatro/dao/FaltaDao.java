package org.grupocuatro.dao;


import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.modelo.Falta;

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
        if (faltas != null) return faltas;
        throw new FaltaException("No existen faltas");
    }

    public Falta getFaltaById(Integer id) throws FaltaException {
        Falta falta = (Falta) getEntityManager().createQuery("FROM Falta WHERE idFalta = " + id).getSingleResult();
        if (falta != null) return falta;
        throw new FaltaException("No existe una falta con id: " + id);
    }

    public List<Falta> getFaltasByJugador(Integer id) throws FaltaException {
        List<Falta> faltas = getEntityManager().createQuery("FROM Falta WHERE idJugador = " + id).getResultList();
        if (faltas != null) return faltas;
        throw new FaltaException("El jugador no posee faltas");
    }

    public List<Falta> getFaltasByCampeonato(Integer campeonato) {
        return null;
    }

    public List<Falta> getFaltasByPartido(Integer partido) {
        return null;
    }

    public List<Falta> getFaltasByTipo(String tipo) {
        return null;
    }

    public List<Falta> getFaltasByJugadorAndPartido(Integer jugador, Integer partido) { return null;}

    public List<Falta> getFaltasByJugadorAndTipo(Integer jugador, String tipo) {return null;}

    public List<Falta> getFaltasByJugadorAndCampeonato(Integer jugador, Integer campeonato) {return null;}

    public List<Falta> getFaltasByJugadorAndTipoAndPartido(Integer jugador, Integer partido, String tipo) {return null;}

    public List<Falta> getFaltasByJugadorAndTipoAndPartidoAndCampeonato(Integer jugador, Integer partido, String tipo, Integer campeonato) {return null;}

}
