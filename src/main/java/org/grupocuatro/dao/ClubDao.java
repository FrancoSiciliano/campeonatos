package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.List;

public class ClubDao extends AbstractDao {
    private static ClubDao instancia;

    private ClubDao() {
    }

    public static ClubDao getInstancia() {
        if (instancia == null)
            instancia = new ClubDao();
        return instancia;
    }

    public Club getClubById(Integer id) throws ClubException {
        try {
            return (Club) getEntityManager().createQuery("FROM Club WHERE id = " + id).getSingleResult();
        } catch (NoResultException e) {
            throw new ClubException("No existe un club con ID " + id);
        }
    }

    public Club getClubByNombre(String nombre) throws ClubException {
        try {
            return (Club) getEntityManager().createQuery("FROM Club WHERE nombre = '" + nombre + "'").getSingleResult();
        } catch (NoResultException e) {
            throw new ClubException("No existe un club con nombre " + nombre);
        }
    }

    public List<Club> getClubes() throws ClubException {
        List<Club> clubes = getEntityManager().createQuery("SELECT c FROM Club c").getResultList();
        if (clubes != null) return clubes;
        throw new ClubException("No existen clubes ");
    }

    public List<Club> getClubesHabilitadosPorCategoria(int categoria) throws ClubException {
        List<Club> clubes = getEntityManager().createQuery("FROM Club WHERE idClub in (SELECT club FROM Jugador WHERE categoria >= " + categoria + " and estado = true  GROUP BY club HAVING COUNT(*) >= 17)").getResultList();
        if (!clubes.isEmpty()) return clubes;
        throw new ClubException("No existen clubes con suficientes jugadores");
    }

}
