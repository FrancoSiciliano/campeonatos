package org.grupocuatro.dao;

import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class MiembroDao extends AbstractDao {

    private static MiembroDao instancia;

    private MiembroDao() {
    }

    public static MiembroDao getInstancia() {
        if (instancia == null)
            instancia = new MiembroDao();
        return instancia;
    }

    public Miembro getMiembroById(Integer id) throws MiembroException {

        try {
            return (Miembro) getEntityManager().createQuery("FROM Miembro WHERE idLista = " + id).getSingleResult();
        } catch (NoResultException e) {
            throw new MiembroException("No existe un miembro con id: " + id);
        }
    }

    public List<Miembro> getMiembros() throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("SELECT m FROM Miembro m").getResultList();
        if (!miembros.isEmpty()) return miembros;
        throw new MiembroException("No existen listas");
    }

    public List<Miembro> getMiembrosByClub(Integer idClub) throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("FROM Miembro WHERE idClub = " + idClub).getResultList();
        if (!miembros.isEmpty()) return miembros;
        throw new MiembroException("El club de id: " + idClub + " no posee una lista");
    }

    public List<Miembro> getMiembrosByClubAndPartido(Integer idClub, Integer idPartido) throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("FROM Miembro WHERE idClub = " + idClub + " and idPartido = " + idPartido).getResultList();
        return miembros;
    }

    public Miembro getMiembroByPartidoAndJugador(int idPartido, int idJugador) throws MiembroException {
        try {
            return (Miembro) getEntityManager().createQuery("FROM Miembro WHERE idPartido = " + idPartido + " AND idJugador = " + idJugador).getSingleResult();
        } catch (NoResultException e) {
            throw new MiembroException("No existe un miembro con el idJugador: " + idJugador + ", en el partido de id: " + idPartido);
        }
    }

    public Miembro getMiembroByClubAndPartidoAndJugador(Integer idClub, Integer idPartido, Integer idJugador) throws MiembroException {
        try {
            return (Miembro) getEntityManager().createQuery("FROM Miembro WHERE idClub = " + idClub + " AND idPartido = " + idPartido + " AND idJugador = " + idJugador).getSingleResult();
        } catch (NoResultException e) {
            throw new MiembroException("El club de id: " + idClub + " no posee una lista para el jugador de id: " + idJugador + " en el partido de id: " + idPartido);
        }
    }

    public List<Miembro> getMiembroByJugadorAndFecha(Integer idJugador, LocalDate fecha) throws MiembroException {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Miembro> cq = cb.createQuery(Miembro.class);
        Root<Miembro> r = cq.from(Miembro.class);
        Join<Miembro, Partido> join = r.join("partido", JoinType.INNER);
        Predicate fechaPred = cb.equal(join.get("fechaPartido"), fecha);
        Predicate jugador = cb.equal(join.getParent().get("jugador"), idJugador);
        cq.where(cb.and(fechaPred, jugador));
        List<Miembro> result = getEntityManager().createQuery(cq).getResultList();
        return result;
    }

    public List<Miembro> getMiembroByPartido(Integer idPartido) throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("FROM Miembro WHERE idPartido = " + idPartido).getResultList();
        if (!miembros.isEmpty()) return miembros;
        throw new MiembroException("No hay jugadores registrados para el partido " + idPartido);
    }

}
