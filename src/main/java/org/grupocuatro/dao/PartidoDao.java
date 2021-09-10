package org.grupocuatro.dao;

import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        throw new PartidoException("No existen partidos del club visitante " + idClub);
    }

    public Partido getUltimoPartidoByClubAndCampeonato(Integer idClub, Integer idCampeonato, int nroFechaActual) throws PartidoException {
        String qlString = "FROM Partido WHERE (idClubLocal = ?1 or idClubVisitante = ?1) and idCampeonato = ?2 and nroFecha < ?3 ORDER BY nroFecha DESC";
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter(1, idClub);
        query.setParameter(2, idCampeonato);
        query.setParameter(3, nroFechaActual - 1);
        List<Partido> partidosAnteriores = query.getResultList();
        if (partidosAnteriores != null) return partidosAnteriores.get(0);
        throw new PartidoException("El equipo no tiene partidos previos");

    }

    public List<Partido> getPartidosByCampeonatoAndJugador(int idCampeonato, int idJugador) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato + " AND idJugador = " + idJugador).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del jugador " + idJugador + " en el campeonato " + idCampeonato);
    }

    public List<Partido> getPartidosByCampeonatoAndClub(int idCampeonato, int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato =" + idCampeonato + " AND (idClubLocal = " + idClub + " OR idClubVisitante = " + idClub + ")").getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club " + idClub + " en el campeonato " + idCampeonato);
    }

    public List<Partido> getPartidosByClub(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubLocal = " + idClub + " OR idClubVisitante = " + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club " + idClub);
    }

}