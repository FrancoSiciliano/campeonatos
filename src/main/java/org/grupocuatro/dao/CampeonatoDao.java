package org.grupocuatro.dao;

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

    public Campeonato getCampeonato(Integer id) {
        return (Campeonato) getEntityManager().createQuery("FROM Campeonato WHERE id = " + id).getSingleResult();
    }

    public List<Campeonato> getCampeonatos() {

        return getEntityManager().createQuery("SELECT c FROM Campeonato c").getResultList();
    }
}
