package org.grupocuatro.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clubesCampeonato")

public class ClubesCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClubesCampeonatos;

    @ManyToOne
    @JoinColumn
    private Club idClub;
    @ManyToOne
    @JoinColumn
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
}
