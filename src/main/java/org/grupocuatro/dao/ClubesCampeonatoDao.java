package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;

import java.util.List;

public class ClubesCampeonatoDao extends AbstractDao {
    private static ClubesCampeonatoDao instancia;

    private ClubesCampeonatoDao() {
    }

    public static ClubesCampeonatoDao getInstancia() {
        if (instancia == null)
            instancia = new ClubesCampeonatoDao();
        return instancia;
    }


    public List<Club> getClubesEnCampeonato(Integer idCampeonato) throws ClubesCampeonatoException {
        List<Club> result = (List<Club>) getEntityManager().createQuery("FROM ClubesCampeonato WHERE idCampeonato = " + idCampeonato).getResultList();
        if (!result.isEmpty())
            return result;
        throw new ClubesCampeonatoException("No existen clubes registrados en el campeonato de id " + idCampeonato);
    }

    public List<Campeonato> getCampeonatosClub(Integer idClub) throws ClubesCampeonatoException {
        List<Campeonato> result = (List<Campeonato>) getEntityManager().createQuery("FROM ClubesCampeonato WHERE idClub = " + idClub).getResultList();
        if (!result.isEmpty())
            return result;
        throw new ClubesCampeonatoException("El club de id " + idClub + " no esta registrado en ningun campeonato");
    }
}
