package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ListadoJugadoresDeshabilitadosException;
import org.grupocuatro.modelo.ListadoJugadoresDeshabilitados;

import javax.persistence.NoResultException;
import java.util.List;

public class ListadoJugadoresDeshabilitadosDao extends AbstractDao {

    private static ListadoJugadoresDeshabilitadosDao instancia;

    private ListadoJugadoresDeshabilitadosDao() {
    }

    public static ListadoJugadoresDeshabilitadosDao getInstancia() {
        if (instancia == null)
            instancia = new ListadoJugadoresDeshabilitadosDao();
        return instancia;
    }

    public boolean isJugadorDeshabilitado(Integer idJugador, Integer idCampeonato) {
        try {
            getEntityManager().createQuery("FROM ListadoJugadoresDeshabilitados WHERE idJugador = " + idJugador + " AND idCampeonato = " + idCampeonato).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public List<ListadoJugadoresDeshabilitados> getJugadoresDeshabilitadosCampeonato(Integer idCampeonato) throws ListadoJugadoresDeshabilitadosException {
        List<ListadoJugadoresDeshabilitados> lista = getEntityManager().createQuery("FROM ListadoJugadoresDeshabilitados WHERE idCampeonato = " + idCampeonato).getResultList();
        if (!lista.isEmpty()) return lista;
        throw new ListadoJugadoresDeshabilitadosException("No hay jugadores deshabilitados para el campeonato " + idCampeonato);
    }

    public ListadoJugadoresDeshabilitados getByJugadorAndCampeonato(Integer idJugador, Integer idCampeonato) throws ListadoJugadoresDeshabilitadosException {
        try {
            return (ListadoJugadoresDeshabilitados) getEntityManager().createQuery("FROM ListadoJugadoresDeshabilitados WHERE idJugador = " + idJugador + " AND idCampeonato = " + idCampeonato).getSingleResult();
        } catch (NoResultException e) {
            throw new ListadoJugadoresDeshabilitadosException("El jugador " + idJugador + " no se encuentra deshabilitado en el campeonato " + idCampeonato);
        }
    }

}
