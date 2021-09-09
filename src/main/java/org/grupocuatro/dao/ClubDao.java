package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Club;

import javax.persistence.NoResultException;
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
            Club result = (Club) getEntityManager().createQuery("FROM Club WHERE id = " + id).getSingleResult();
            return result;
        } catch (NoResultException e) {
            throw new ClubException("No existe un club con ID " + id);
        }
    }

    public Club getClubByNombre(String nombre) throws ClubException {
        try {
            Club result = (Club) getEntityManager().createQuery("FROM Club WHERE nombre = '" + nombre + "'").getSingleResult();
            return result;
        } catch (NoResultException e) {
            throw new ClubException("No existe un club con nombre " + nombre);
        }
    }

    public List<Club> getClubes() throws ClubException {
        List<Club> clubes = getEntityManager().createQuery("SELECT c FROM Club c").getResultList();
        if (clubes != null) return clubes;
        throw new ClubException("No existen clubes ");
    }


}
