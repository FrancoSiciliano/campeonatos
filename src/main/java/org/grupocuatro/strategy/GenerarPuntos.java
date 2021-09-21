package org.grupocuatro.strategy;

import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.utiles.Tupla;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class GenerarPuntos implements GeneracionPartidosStrategy {
    @Override
    public void generarPartidosCampeonato(Campeonato campeonato, int categoria) {
        List<Club> clubesInscriptos = ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato());
        List<Club> clubesLocales = clubesInscriptos;
        List<Club> clubesVisitantes = clubesInscriptos;
        for (Club clubLocal : clubesLocales) {
            for (Club clubVisitante : clubesVisitantes) {
                if (!Objects.equals(clubLocal.getIdClub(), clubVisitante.getIdClub())) {
                    ControladorPartidos.getInstancia().crearPartido(0, categoria, clubLocal.getIdClub(), clubVisitante.getIdClub(), campeonato.getIdCampeonato());
                }
            }
        }
    }
}

