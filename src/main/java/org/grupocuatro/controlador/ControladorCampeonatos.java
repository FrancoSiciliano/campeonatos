package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    public void definirTipoCampeonato(String tipo, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            campeonato.setTipoCampeonato(tipo);
            campeonato.update();
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

    //PARTE DE CLUBES CAMPEONATO

    public void agregarClubACampeonato(Integer idClub, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            Club club = ControladorClubes.getInstancia().getClubById(idClub);
            if (club != null) {
                try {
                    ClubesCampeonatoDao.getInstancia().getClubCampeonato(idClub, idCampeonato);
                } catch (ClubesCampeonatoException e2) {
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
