package org.grupocuatro.strategy;

import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenerarZonas implements GeneracionPartidosStrategy {

    private int cantZonas;

    public GenerarZonas(int cantZonas) {
        this.cantZonas = cantZonas;
    }

    @Override
    public void generarPartidosCampeonato(Campeonato campeonato, int categoria) {
        List<Club> clubesInscriptos = ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato());

        if (cantZonas % 2 != 0 || clubesInscriptos.size() % cantZonas != 0 || clubesInscriptos.size() % 2 != 0 || cantZonas == clubesInscriptos.size()) {
            System.out.println("No se puede crear");
        } else {

            int cantidadEquiposZona = clubesInscriptos.size() / cantZonas;

            List<List<Club>> zonas = new ArrayList<>();
            int auxInicial = 0;
            int auxFinal = cantidadEquiposZona;

            for (int i = 0; i < cantZonas; i++) {
                zonas.add(clubesInscriptos.subList(auxInicial, auxFinal));
                auxInicial = auxFinal;
                auxFinal += cantidadEquiposZona;
            }

            List<Club> clubesLocales;
            List<Club> clubesVisitantes;

            for (List<Club> lc : zonas) {
                clubesLocales = lc;
                clubesVisitantes = lc;

                for (Club clubLocal : clubesLocales) {
                    for (Club clubVisitante : clubesVisitantes) {
                        if (!Objects.equals(clubLocal.getIdClub(), clubVisitante.getIdClub()))
                            ControladorPartidos.getInstancia().crearPartido(zonas.indexOf(lc) + 1, categoria, clubLocal.getIdClub(), clubVisitante.getIdClub(), campeonato.getIdCampeonato());
                    }
                }
            }

        }

    }

}
