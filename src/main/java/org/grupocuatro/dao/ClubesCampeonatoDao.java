package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;

import java.util.List;

public class ClubesCampeonatoDao extends AbstractDao{
    private static ClubesCampeonato instancia;
    private ClubesCampeonatoDao(){}

    public ClubesCampeonato getInstancia(){
        if (instancia == null)
            instancia = new ClubesCampeonato();
        return instancia;
    }


    public List<Club> getClubesEnCampeonato(Integer idCampeonato) throws ClubesCampeonatoException {
        List<Club> result = (List<Club>) getEntityManager().createQuery("FROM clubesCampeonato WHERE idCampeonato = " + idCampeonato).getResultList();
        if(!result.isEmpty())
            return result;
        throw new ClubesCampeonatoException("No existen clubes registrados en este campeonato");
    }

    public List<Campeonato> getCampeonatosClub(Integer idClub) throws ClubesCampeonatoException {
        List<Campeonato> result = (List<Campeonato>) getEntityManager().createQuery("FROM clubesCampeonato WHERE idClub = " + idClub).getResultList();
        if(!result.isEmpty())
            return result;
        throw new ClubesCampeonatoException("El club ingresado no esta registrado en ningun campeonato");
    }
}
