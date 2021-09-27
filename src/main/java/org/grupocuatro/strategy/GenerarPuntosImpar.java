package org.grupocuatro.strategy;

import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.ClubVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GenerarPuntosImpar implements GeneracionPartidosStrategy{
    private List<Club> transformarAListaModelo(List<ClubVO> listaClubesVO){
        List<Club> clubes = new ArrayList<>();
        for(ClubVO club:listaClubesVO){
            clubes.add(club.toModelo());
        }
        return clubes;
    }

    @Override
    public void generarPartidosCampeonato(Campeonato campeonato, int categoria) throws ClubesCampeonatoException, PartidoException {

        List<Club> clubesInscriptos = transformarAListaModelo(ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato()));
        HashMap<Integer, Club> map = new HashMap<>();

        int numRondas = clubesInscriptos.size();
        int partidosPorRonda = clubesInscriptos.size() / 2;

        Partido[][] auxPartidos = new Partido[numRondas][partidosPorRonda];

        int aux = 0;
        for (Club c : clubesInscriptos) {
            map.put(aux, c);
            aux++;
        }

        for (int i = 0, k = 0; i < numRondas; i++) {
            for (int j = -1; j < partidosPorRonda; j++) {
                if (j >= 0) {
                    auxPartidos[i][j] = new Partido();
                    auxPartidos[i][j].setClubLocal(map.get(k));
                    auxPartidos[i][j].setCategoria(categoria);
                    auxPartidos[i][j].setNroZona(0);
                }
                k++;

                if (k == numRondas) {
                    k = 0;
                }
            }
        }

        int equipoMasAlto = clubesInscriptos.size() - 1;
        for (int i = 0, k = equipoMasAlto; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {
                auxPartidos[i][j].setClubVisitante(map.get(k));
                k--;

                if (k == -1) {
                    k = equipoMasAlto;
                }
            }
        }

        LocalDate fechaInicial = campeonato.getFechaInicio();

        //IDA
        for (int i = 0; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {
                int idp = ControladorPartidos.getInstancia().crearPartido(auxPartidos[i][j].getNroZona(), auxPartidos[i][j].getCategoria(), auxPartidos[i][j].getClubLocal().getIdClub(), auxPartidos[i][j].getClubVisitante().getIdClub(), campeonato.getIdCampeonato());
                Partido p = ControladorPartidos.getInstancia().encontrarPartido(idp).toModelo();
                p.setNroFecha(i + 1);
                p.setFechaPartido(fechaInicial);
                p.update();
            }
            fechaInicial = fechaInicial.plusDays(1);
        }

        int auxFecha = numRondas + 1;

        //VUELTA
        for (int i = 0; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {
                int idp = ControladorPartidos.getInstancia().crearPartido(auxPartidos[i][j].getNroZona(), auxPartidos[i][j].getCategoria(), auxPartidos[i][j].getClubVisitante().getIdClub(), auxPartidos[i][j].getClubLocal().getIdClub(), campeonato.getIdCampeonato());
                Partido p = ControladorPartidos.getInstancia().encontrarPartido(idp).toModelo();
                p.setNroFecha(auxFecha);
                p.setFechaPartido(fechaInicial);
                p.update();
            }
            fechaInicial = fechaInicial.plusDays(1);
            auxFecha++;
        }

    }
}
