package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;
import org.grupocuatro.strategy.GeneracionPartidosStrategy;
import org.grupocuatro.strategy.GenerarPuntos;
import org.grupocuatro.strategy.GenerarZonas;
import org.grupocuatro.utiles.Tupla;


import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControladorCampeonatos {
    private static ControladorCampeonatos instancia;

    private ControladorCampeonatos() {
    }

    public static ControladorCampeonatos getInstancia() {
        if (instancia == null)
            instancia = new ControladorCampeonatos();
        return instancia;
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, estado);
        try {
            for (Campeonato c : CampeonatoDao.getInstancia().getCampeonatos()) {
                if (Objects.equals(descripcion, c.getDescripcion()) && Objects.equals(c.getFechaInicio(), fechaInicio) && Objects.equals(c.getFechaFin(), fechaFin) && Objects.equals(c.getEstado(), "activo")) {
                    System.out.println("Ya existe el campeonato que se esta intentando ingresar");
                    return null;
                }
            }
            throw new CampeonatoException("");
        } catch (CampeonatoException e) {
            nuevoCampeonato.save();
        }
        return nuevoCampeonato.getIdCampeonato();
    }


    // TODO LA CATEGORIA LA CONTROLA LA VISTA
    // FIXME BORRAR EL PARTIDO FALSO :D

    public void definirTipoCampeonatoAndCategoria(int cantidadZonas, Integer idCampeonato, int categoria) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            GeneracionPartidosStrategy strategy;

            if ((cantidadZonas == 0)) {
                campeonato.setTipoCampeonato("Puntos");
                strategy = new GenerarPuntos();
            } else {
                campeonato.setTipoCampeonato("Zonas");
                strategy = new GenerarZonas(cantidadZonas);
            }

            campeonato.update();
            strategy.generarPartidosCampeonato(campeonato, categoria);

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarPartidosCampeonato(Integer idCampeonato, int categoria) {
        try {
            Campeonato camp = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            long duracion = camp.calcularDuracionCampeonato();


            //ASUMIMOS QUE EN ESTE PUNTO, LOS CLUBES REGISTRADOS EN EL CAMPEONATO TIENEN JUGADORES SUFICIENTES DE LA CATEGORIA INDICADA
            List<Club> clubesInscriptos = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);

            if (camp.getTipoCampeonato().toLowerCase().replace(" ", "") == "puntos") {
                cargarPartidosCampPuntos(duracion, lista);
            } else if (camp.getTipoCampeonato().toLowerCase().replace(" ", "") == "zonas") {
                cargarPartidoCampZonas(duracion, lista);
            }
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }


    private void cargarPartidosCampPuntos(long diasDuracion, List<Club> lista) {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int cantEquipos = lista.size();
        int cantFechas = cantEquipos * 2 - 1;
        int fechaIda = 1;
        int fechaVuelta = cantFechas / 2 + 1;
        //int cantPartidosJugar = cantEquipos * (cantEquipos - 1);
        //int cantPartidosSimult = cantEquipos / 2;
        List<Club> clubesA = lista;
        List<Club> clubesB = lista;
        for (Club clubA : clubesA) {
            for (Club clubB : clubesB) {
                if (clubA.getIdClub() != clubB.getIdClub()) {
                    //controladorPartidos.crearPartido(fechaIda, 0, categoria, clubA.getIdClub(), clubB.getIdClub(), LocalDate.of(1,1,1), idCampeoanto);
                    //controladorPartidos.crearPartido(fechaVuelta, 0, categoria, clubB.getIdClub(), clubA.getIdClub(), LocalDate.of(1,1,1), idCampeoanto);
                    fechaIda++;
                    fechaVuelta++;
                }
            }
            fechaIda = 1;
            fechaVuelta = cantFechas / 2 + 1;
        }

    }

    private void cargarPartidoCampZonas(long diasDuracion, List<Club> lista) {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();


    }

    public void terminarCampeonato(Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            campeonato.setEstado("inactivo");
            campeonato.update();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Campeonato encontrarCampeonato(Integer idCampeonato) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato;
        try {
            campeonato = campeonatoDao.getCampeonato(idCampeonato);
            return campeonato;
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Campeonato> getCampeonatos() {
        try {
            return CampeonatoDao.getInstancia().getCampeonatos();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<Campeonato> getCampeonatosByEstado(String estado) {
        try {
            return CampeonatoDao.getInstancia().getCampeonatosByEstado(estado);
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    //PARTE DE CLUBES CAMPEONATO

    public void agregarClubACampeonato(Integer idClub, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            Club club = ControladorClubes.getInstancia().getClubById(idClub);
            if (club != null) {
                try {
                    ClubesCampeonatoDao.getInstancia().getClubCampeonato(idClub, idCampeonato);
                } catch (ClubesCampeonatoException e2) {
                    //LA COMPROBACIÓN LA HACE LA VISTA
                    ClubesCampeonato nuevocc = new ClubesCampeonato(club, campeonato);
                    nuevocc.save();
                }
            } else System.out.println("No existe el club ingresado");

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Campeonato> getCampeonatosByClub(Integer idClub) {
        try {
            return ClubesCampeonatoDao.getInstancia().getCampeonatosClub(idClub);
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
