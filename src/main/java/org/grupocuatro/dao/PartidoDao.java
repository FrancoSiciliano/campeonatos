package org.grupocuatro.dao;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDao extends AbstractDao {

    private static PartidoDao instancia;

    private PartidoDao() {
    }

    public static PartidoDao getInstancia() {
        if (instancia == null) {
            instancia = new PartidoDao();
        }
        return instancia;
    }

    public List<Partido> getAllPartidos() throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido").getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No hay partidos");
    }

    public Partido getPartidoById(Integer idPartido) throws PartidoException {
        try {
            Partido partido = (Partido) getEntityManager().createQuery("FROM Partido WHERE idPartido = " + idPartido).getSingleResult();
            return partido;
        } catch (NoResultException e) {
            throw new PartidoException("No hay un partido con el Id " + idPartido);
        }

    }

    public List<Partido> getPartidosByCategoria(int categoria) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE categoria =" + categoria).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la categoria " + categoria);
    }

    public List<Partido> getPartidosByNroFecha(int nroFecha) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroFecha =" + nroFecha).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la fecha " + nroFecha);
    }

    public List<Partido> getPartidosByNroZona(int nroZona) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroZona =" + nroZona).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la zona " + nroZona);
    }

    public List<Partido> getPartidosByClubLocal(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubLocal =" + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club local  " + idClub);
    }

    public List<Partido> getPartidosByClubVisitante(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubVisitante =" + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la idClub " + idClub);
    }
}