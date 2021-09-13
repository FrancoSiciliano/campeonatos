package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;

import javax.persistence.NoResultException;
import java.util.ArrayList;
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
        List<ClubesCampeonato> result = getEntityManager().createQuery("FROM ClubesCampeonato WHERE idCampeonato = " + idCampeonato).getResultList();
        List<Club> clubes = new ArrayList<>();
        if (!result.isEmpty()) {
            for (ClubesCampeonato cc : result) {
                clubes.add(cc.getClub());
            }
            return  clubes;

        } else {
            throw new ClubesCampeonatoException("No existen clubes registrados en el campeonato de id " + idCampeonato);
        }

    }

    public List<Campeonato> getCampeonatosClub(Integer idClub) throws ClubesCampeonatoException {
        List<ClubesCampeonato> result = getEntityManager().createQuery("FROM ClubesCampeonato WHERE idClub = " + idClub).getResultList();
        List<Campeonato> campeonatos = new ArrayList<>();
        if (!result.isEmpty()) {
            for (ClubesCampeonato cc : result) {
                campeonatos.add(cc.getCampeonato());
            }
            return  campeonatos;

        }
        throw new ClubesCampeonatoException("El club de id " + idClub + " no esta registrado en ningun campeonato");
    }

    public ClubesCampeonato getClubCampeonato (Integer idClub, Integer idCampeonato) throws ClubesCampeonatoException {
        try{
            ClubesCampeonato result = (ClubesCampeonato) getEntityManager().createQuery("FROM ClubesCampeonato WHERE idClub = " + idClub + " and idCampeonato = " + idCampeonato).getSingleResult();
            return result;
        }catch (NoResultException e) {
            throw new ClubesCampeonatoException("El club de id " + idClub + " no esta registrado en el campeonato " + idCampeonato);
        }
    }
}
