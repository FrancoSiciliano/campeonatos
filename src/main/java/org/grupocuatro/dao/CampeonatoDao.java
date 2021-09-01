package org.grupocuatro.dao;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.modelo.Campeonato;

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

    public Campeonato getCampeonato(Integer id) throws CampeonatoException{
        Campeonato campeonato = (Campeonato) getEntityManager().createQuery("FROM Campeonato WHERE id = " + id).getSingleResult();
        if (campeonato != null)
            return campeonato;
        throw new CampeonatoException("El campeonato no existe");

    }

    public List<Campeonato> getCampeonatos() throws CampeonatoException {
        List<Campeonato> campeonatos = getEntityManager().createQuery("SELECT c FROM Campeonato c").getResultList();
        if(campeonatos != null)
            return campeonatos;
        throw new CampeonatoException("No existen campeonatos");
    }
}