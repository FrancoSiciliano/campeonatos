package org.grupocuatro.dao;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.modelo.Campeonato;

import javax.persistence.NoResultException;
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
            Campeonato campeonato = (Campeonato) getEntityManager().createQuery("FROM Campeonato WHERE id = " + id).getSingleResult();
            return campeonato;
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

    public List<Campeonato> getCampeonatosByEstado (String estado) throws CampeonatoException {
        List<Campeonato> campeonatos = getEntityManager().createQuery("SELECT c FROM Campeonato c WHERE c.estado = '" + estado +"'").getResultList();
        if (!campeonatos.isEmpty())
            return campeonatos;
        throw new CampeonatoException("No existen campeonatos en estado " + estado);
    }


}
