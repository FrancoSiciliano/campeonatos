package org.grupocuatro.strategy;

import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Partido;

import java.time.LocalDate;

public interface GeneracionPartidosStrategy {
    void generarPartidosCampeonato(Campeonato campeonato, int categoria);
}
