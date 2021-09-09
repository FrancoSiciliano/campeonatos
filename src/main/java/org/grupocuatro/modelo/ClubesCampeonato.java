package org.grupocuatro.modelo;

import org.grupocuatro.dao.ClubesCampeonatoDao;

import javax.persistence.*;

@Entity
@Table(name = "clubesCampeonato")

public class ClubesCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClubesCampeonatos;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club idClub;
    @ManyToOne
    @JoinColumn(name = "idCampeonato")
    private Campeonato idCampeonato;

    public ClubesCampeonato() {
    }

    public ClubesCampeonato(Club idClub, Campeonato idCampeonato) {
        this.idClub = idClub;
        this.idCampeonato = idCampeonato;
    }


    public Integer getIdClubesCampeonatos() {
        return idClubesCampeonatos;
    }

    public void setIdClubesCampeonatos(Integer idClubesCampeonatos) {
        this.idClubesCampeonatos = idClubesCampeonatos;
    }

    public Club getClub() {
        return idClub;
    }

    public void setClub(Club idClub) {
        this.idClub = idClub;
    }

    public Campeonato getCampeonato() {
        return idCampeonato;
    }

    public void setCampeonato(Campeonato idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public void save() {
        ClubesCampeonatoDao.getInstancia().save(this);
    }

    @Override
    public String toString() {
        return "ClubesCampeonato{" +
                "idClubesCampeonatos=" + idClubesCampeonatos +
                ", idClub=" + idClub +
                ", idCampeonato=" + idCampeonato +
                '}';
    }
}
