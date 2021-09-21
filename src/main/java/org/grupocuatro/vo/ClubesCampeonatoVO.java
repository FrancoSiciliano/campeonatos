package org.grupocuatro.vo;

import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.ClubesCampeonato;

import java.io.Serializable;

public class ClubesCampeonatoVO implements Serializable {
    private static final long serialVersionUID = 2062881872206625034L;

    private Integer idClubesCampeonatos;
    private ClubVO idClub;
    private CampeonatoVO idCampeonato;

    public ClubesCampeonatoVO () {}

    public ClubesCampeonatoVO (Integer idClubesCampeonatos, ClubVO idClub, CampeonatoVO idCampeonato) {
        this.idClubesCampeonatos = idClubesCampeonatos;
        this.idClub = idClub;
        this.idCampeonato = idCampeonato;
    }

    public Integer getIdClubesCampeonatos() {
        return idClubesCampeonatos;
    }

    public void setIdClubesCampeonatos(Integer idClubesCampeonatos) {
        this.idClubesCampeonatos = idClubesCampeonatos;
    }

    public ClubVO getIdClub() {
        return idClub;
    }

    public void setIdClub(ClubVO idClub) {
        this.idClub = idClub;
    }

    public CampeonatoVO getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(CampeonatoVO idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public ClubesCampeonato toModelo() {
        return new ClubesCampeonato(idClub.toModelo(), idCampeonato.toModelo());
    }

    @Override
    public String toString() {
        return "ClubesCampeonatoVO{" +
                "idClubesCampeonatos=" + idClubesCampeonatos +
                ", idClub=" + idClub +
                ", idCampeonato=" + idCampeonato +
                '}';
    }
}
