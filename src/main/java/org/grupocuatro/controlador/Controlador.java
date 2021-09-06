package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Controlador {

    private static Controlador instancia;

    private Controlador() {
    }

    public static Controlador getInstancia() {
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    /*
     * Notas:
     *
     * -Pueden si lo desean convertir el controlador en un Singleton
     *
     * -Deberan completar los metodos del controlador para que cumplan con los requerimientos
     *  del trabajo, Recuerden siempre aplicar los patrones GRASP para verificar la correcta
     *  asignacion de lasresponsabilidades
     *
     * -En la segunda parate del trabajo deber'an agragar los metodos y controles que
     *  considen necesarios. */


    // Se agregaron 2 setters en el Club para poder modificar el nombre y la dirección.
    // Se agregó el throw de la excepción del ClubDAO.

    public void crearClub(Integer id, String nombre, String direccion) {
        try {
            Club club = ClubDao.getInstancia().getClubById(id);
        } catch (ClubException e) {
            Club c = new Club(id, nombre, direccion);
            c.save();
        }
    }

    public void modificarClub(String nombre, String direccion) {
        ClubDao dao = ClubDao.getInstancia();
        Club club = null;
        try {
            club = dao.getClubByNombre(nombre);
            club.setNombre(nombre);
            club.setDireccion(direccion);
            club.update();

        } catch (ClubException e) {
            System.out.printf(e.getMessage());
        }
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, "activo");
        nuevoCampeonato.save();
        return nuevoCampeonato.getIdCampeonato();
    }

    public void terminarCampeonato(Integer id) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(id);
            campeonato.setEstado("inactivo");
            campeonato.update();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }


    // No estaba el tipoDocumento, el documento era un String, no estaba el apellido.
    // Hay que agregarle el throw al método para que pueda manejar las excepciones
    // El método figuraba que devolvía un Integer como retorno.
    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, Date fechaNacimiento) throws JugadorException {
        JugadorDao dao = JugadorDao.getInstancia();
        try {
            dao.getJugadorByDocumento(documento, tipoDocumento);
            System.out.println("Ya existe el jugador que se esta intentando agregar");
        } catch (JugadorException e) {
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                Jugador j = new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento);
                dao.save(j);
                return j.getIdJugador();
            } catch (ClubException e2) {
                System.out.println(e2.getMessage());
            }
        }
        throw new JugadorException("No se pudo agregar el jugador deseado");
    }

    public void eliminarJugador(int idJugador, int idClub) {
        JugadorDao dao = JugadorDao.getInstancia();
        Jugador player = null;
        try {
            player = dao.getJugadorById(idJugador);
            if (player.isClub(idClub)) dao.delete(player);

        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {
    }

    // El método vino con el Integer como retorno, pero se lo cambió a void.
    // Agregar el retorno como Integer

    public Integer crearListaJugadores(Club club, Partido partido) {
        MiembroDao dao = MiembroDao.getInstancia();
        Miembro m = new Miembro(club, partido);
        dao.save(m);
        return m.getIdLista();
    }


    // REVISAR ESTE METODO!

    public void agregarJugadoresEnLista(int idMiembro, Jugador jugador) throws MiembroException {
        MiembroDao dao = MiembroDao.getInstancia();
        PartidoDao daoP = PartidoDao.getInstancia();
        try {
            Miembro nuevoMiembro = dao.getMiembroById(idMiembro);
            if(nuevoMiembro.getJugador() == null){
                if (dao.getMiembrosByClub(nuevoMiembro.getClub().getIdClub()).size() < 17) {

                }
            }
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }


}