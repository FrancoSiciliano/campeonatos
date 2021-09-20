package org.grupocuatro.strategy;

import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.utiles.Tupla;

import java.util.*;

public class GenerarPuntosPar implements GeneracionPartidosStrategy {
    @Override
    public void generarPartidosCampeonato(Campeonato campeonato, int categoria) {
        List<Club> clubesInscriptos = ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato());
        List<Club> clubesLocales = clubesInscriptos;
        List<Club> clubesVisitantes = clubesInscriptos;
        for (Club clubLocal : clubesLocales) {
            for (Club clubVisitante : clubesVisitantes) {
                if (!Objects.equals(clubLocal.getIdClub(), clubVisitante.getIdClub()))
                    ControladorPartidos.getInstancia().crearPartido(0, categoria, clubLocal.getIdClub(), clubVisitante.getIdClub(), campeonato.getIdCampeonato());
            }
        }
        generarFechasPartidosCampeonato(campeonato.getIdCampeonato());
    }

    @Override
    public void generarFechasPartidosCampeonato(Integer idCampeonato) {
        List<Partido> partidosCampeonato = ControladorPartidos.getInstancia().getPartidosByCampeonato(idCampeonato);
        List<Club> clubesParticipantes = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);
        int cantFechas = (clubesParticipantes.size() - 1) * 2;
        int partidoPorFecha = clubesParticipantes.size() / 2;
        Set<Club> clubesRegistrados = new HashSet<Club>();
        List<Tupla> enfrentamientos = new ArrayList<>();
        int cantRegistrados = 0;
        int indice = 0;

        for (int nroFecha = 1; nroFecha <= cantFechas; nroFecha++) {
            indice = 0;
            while (cantRegistrados < clubesParticipantes.size()) {
                Partido p = partidosCampeonato.get(indice);
                System.out.println(!clubesRegistrados.contains(p.getClubLocal()) && !clubesRegistrados.contains(p.getClubVisitante()));

                if (!clubesRegistrados.contains(p.getClubLocal()) && !clubesRegistrados.contains(p.getClubVisitante())) {

                    p.setNroFecha(nroFecha);
                    p.update();

                    clubesRegistrados.add(p.getClubLocal());
                    clubesRegistrados.add(p.getClubVisitante());

                    partidosCampeonato.remove(p);

                    cantRegistrados = clubesRegistrados.size();

                } else {
                    indice++;
                }
            }
            clubesRegistrados.clear();  // Como la fecha ya se terminó de organizar, el conjunto se vacía para poder comenzar con la siguiente.
            cantRegistrados = 0;
        }
    }
}

