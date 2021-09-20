package org.grupocuatro.strategy;

import org.grupocuatro.modelo.Campeonato;

public interface GeneracionPartidosStrategy {
    void generarPartidosCampeonato(Campeonato campeonato, int categoria);
    void generarFechasPartidosCampeonato(Integer idCampeonato);
}
