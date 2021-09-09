package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;

import static java.time.temporal.ChronoUnit.DAYS;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.List;

public class ControladorCampeonatos {
    private static ControladorCampeonatos instancia;

    private ControladorCampeonatos() {
    }

    public static ControladorCampeonatos getInstancia() {
        if (instancia == null)
            instancia = new ControladorCampeonatos();
        return instancia;
    }

    // PARTE DE PERSISTENCIA BASICA

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado, Integer categoria) {
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, estado, categoria);
        nuevoCampeonato.save();
        return nuevoCampeonato.getIdCampeonato();
    }

    public void definirTipoCampeonato(String tipo, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            campeonato.setTipoCampeonato(tipo);
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

    public Campeonato encontrarCampeonato(int idCampeonato) {//tiene q estar en el controlador y no aca
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato = null;
        try {
            campeonato = campeonatoDao.getCampeonato(idCampeonato);
            return campeonato;
        } catch (CampeonatoException e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO FUNCIONALIDADES PARA LAS PROXIMAS ENTREGAS (EN PROCESO)
    public void agregarClubCampeonato(Integer idClub, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            Club club = ClubDao.getInstancia().getClubById(idClub);

            ClubesCampeonato nuevocc = new ClubesCampeonato(club, campeonato);
            nuevocc.save();

        } catch (CampeonatoException | ClubException e) {
            System.out.println(e.getMessage());
        }

    }


}
