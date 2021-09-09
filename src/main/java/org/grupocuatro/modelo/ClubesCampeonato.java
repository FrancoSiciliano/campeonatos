package org.grupocuatro.modelo;

import org.grupocuatro.dao.ClubesCampeonatoDao;

import javax.persistence.*;

@Entity
@Table(name = "clubesCampeonato")

public class ClubesCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClubesCampeonatos;

    @Override
    public String toString() {
        return "ClubesCampeonato{" +
                "idClubesCampeonatos=" + idClubesCampeonatos +
                ", idClub=" + idClub +
                ", idCampeonato=" + idCampeonato +
                '}';
    }

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

    public Club getIdClub() {
        return idClub;
    }

    public void setIdClub(Club idClub) {
        this.idClub = idClub;
    }

    public Campeonato getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Campeonato idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public void save() { ClubesCampeonatoDao.getInstancia().save(this); }
}
