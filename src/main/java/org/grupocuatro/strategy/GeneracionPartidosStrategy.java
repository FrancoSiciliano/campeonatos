package org.grupocuatro.strategy;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Partido;

import java.time.LocalDate;

public interface GeneracionPartidosStrategy {
    void generarPartidosCampeonato(Campeonato campeonato, int categoria) throws ClubesCampeonatoException, PartidoException, CampeonatoException, ClubException;
}
