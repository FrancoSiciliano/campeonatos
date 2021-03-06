package org.grupocuatro.strategy;

import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.ClubVO;

import java.time.LocalDate;
import java.util.*;

public class GenerarPuntosPar implements GeneracionPartidosStrategy {
    private List<Club> transformarAListaModelo(List<ClubVO> listaClubesVO){
        List<Club> clubes = new ArrayList<>();
        for(ClubVO club:listaClubesVO){
            clubes.add(club.toModelo());
        }
        return clubes;
    }
    @Override
    public void generarPartidosCampeonato(Campeonato campeonato, int categoria) throws ClubesCampeonatoException, PartidoException, CampeonatoException, ClubException {
        List<Club> clubesInscriptos = transformarAListaModelo(ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato()));
        HashMap<Integer, Club> map = new HashMap<>();

        int numRondas = clubesInscriptos.size() - 1;
        int partidosPorRonda = clubesInscriptos.size() / 2;

        Partido[][] auxPartidos = new Partido[numRondas][partidosPorRonda];

        int aux = 0;
        for (Club c : clubesInscriptos) {
            map.put(aux, c);
            aux++;
        }

        for (int i = 0, k = 0; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {

                auxPartidos[i][j] = new Partido();
                auxPartidos[i][j].setClubLocal(map.get(k));
                auxPartidos[i][j].setCategoria(categoria);
                auxPartidos[i][j].setNroZona(0);

                k++;

                if (k == numRondas) {
                    k = 0;
                }
            }
        }

        for (int i = 0; i < numRondas; i++) {
            if (i % 2 == 0) {
                auxPartidos[i][0].setClubVisitante(map.get(clubesInscriptos.size() - 1));
            } else {
                auxPartidos[i][0].setClubVisitante(auxPartidos[i][0].getClubLocal());
                auxPartidos[i][0].setClubLocal(map.get(clubesInscriptos.size() - 1));
            }
        }

        int equipoMasAlto = clubesInscriptos.size() - 1;
        int equipoImparMasAlto = equipoMasAlto - 1;

        for (int i = 0, k = equipoImparMasAlto; i < numRondas; i++) {
            for (int j = 1; j < partidosPorRonda; j++) {
                auxPartidos[i][j].setClubVisitante(map.get(k));
                k--;

                if (k == -1) {
                    k = equipoImparMasAlto;
                }
            }
        }

        LocalDate fechaInicial = campeonato.getFechaInicio();

        //IDA
        for (int i = 0; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {
                Partido p = new Partido(auxPartidos[i][j].getNroZona(),
                        auxPartidos[i][j].getCategoria(),
                        auxPartidos[i][j].getClubLocal(),
                        auxPartidos[i][j].getClubVisitante(),
                        campeonato,
                        fechaInicial, i + 1);
                p.save();
            }
            fechaInicial = fechaInicial.plusDays(1);
        }

        int auxFecha = numRondas + 1;

        //VUELTA
        for (int i = 0; i < numRondas; i++) {
            for (int j = 0; j < partidosPorRonda; j++) {
                Partido p = new Partido(auxPartidos[i][j].getNroZona(),
                        auxPartidos[i][j].getCategoria(),
                        auxPartidos[i][j].getClubVisitante(),
                        auxPartidos[i][j].getClubLocal(),
                        campeonato,
                        fechaInicial, auxFecha);
                p.save();
            }
            fechaInicial = fechaInicial.plusDays(1);
            auxFecha++;
        }
    }
}

