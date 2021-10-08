package org.grupocuatro.dao;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.modelo.Campeonato;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class CampeonatoDao extends AbstractDao {

    private static CampeonatoDao instancia;

    private CampeonatoDao() {
    }

    public static CampeonatoDao getInstancia() {
        if (instancia == null)
            instancia = new CampeonatoDao();
        return instancia;
    }

    public Campeonato getCampeonato(Integer id) throws CampeonatoException {
        try {
            return (Campeonato) getEntityManager().createQuery("FROM Campeonato WHERE id = " + id).getSingleResult();
        } catch (NoResultException e) {
            throw new CampeonatoException("El campeonato de id:  " + id + " no existe");
        }

    }

    public List<Campeonato> getCampeonatos() throws CampeonatoException {
        List<Campeonato> campeonatos = getEntityManager().createQuery("SELECT c FROM Campeonato c").getResultList();
        if (!campeonatos.isEmpty())
            return campeonatos;
        throw new CampeonatoException("No existen campeonatos");
    }

    public List<Campeonato> getCampeonatosByEstado(String estado) throws CampeonatoException {
        List<Campeonato> campeonatos = getEntityManager().createQuery("SELECT c FROM Campeonato c WHERE c.estado = '" + estado + "'").getResultList();
        if (!campeonatos.isEmpty())
            return campeonatos;
        throw new CampeonatoException("No existen campeonatos en estado: " + estado);
    }

    public boolean existeCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        String qlString = "FROM Campeonato WHERE descripcion = ?1 AND fechaInicio = ?2 AND fechaFin = ?3 AND estado = ?4";
        Query query = getEntityManager().createQuery(qlString);

        query.setParameter(1, descripcion);
        query.setParameter(2, fechaInicio);
        query.setParameter(3, fechaFin);
        query.setParameter(4, estado);

        try {
            query.getSingleResult();
            return true;

        } catch (NoResultException e) {
            return false;
        }
    }

    public Campeonato traerCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        String qlString = "FROM Campeonato WHERE descripcion = ?1 AND fechaInicio = ?2 AND fechaFin = ?3 AND estado = ?4";
        Query query = getEntityManager().createQuery(qlString);

        query.setParameter(1, descripcion);
        query.setParameter(2, fechaInicio);
        query.setParameter(3, fechaFin);
        query.setParameter(4, estado);

        try {
            return (Campeonato) query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

}
