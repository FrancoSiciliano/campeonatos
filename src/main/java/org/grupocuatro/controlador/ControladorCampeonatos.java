package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.*;
import org.grupocuatro.strategy.*;


import java.time.LocalDate;
import java.util.*;

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
    // SI SE LE PASA 0 COMO CANTIDAD DE ZONAS EL TORNEO ES POR PUNTOS.

    public void definirTipoCampeonatoAndCategoria(int cantidadZonas, Integer idCampeonato, int categoria) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            int cantEquipos = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato).size();

            GeneracionPartidosStrategy strategy;

            if ((cantidadZonas == 0)) {
                campeonato.setTipoCampeonato("Puntos");

                if (cantEquipos % 2 == 0)
                    strategy = new GenerarPuntosPar();
                else
                    strategy = new GenerarPuntosImpar();
            } else {
                campeonato.setTipoCampeonato("Zonas");

                if ((cantEquipos / cantidadZonas) % 2 == 0)
                    strategy = new GenerarZonasPar(cantidadZonas);
                else
                    strategy = new GenerarZonasImpar(cantidadZonas);
            }

            campeonato.update();
            strategy.generarPartidosCampeonato(campeonato, categoria);

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
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

    public boolean estaEnLaFecha(Campeonato campeonato, LocalDate fecha) {
        return campeonato.estaEnLaFecha(fecha);
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
