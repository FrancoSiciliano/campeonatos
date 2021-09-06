package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

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

    public void modificarClub(String nombre, String direccion) {
        ClubDao dao = ClubDao.getInstancia();
        Club club = null;
        try {
            club = dao.getClubByNombre(nombre);
            club.setNombre(nombre);
            club.setDireccion(direccion);
            dao.update(club);

        } catch (ClubException e) {
            System.out.printf(e.getMessage());
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
        Miembro m = new Miembro(club,partido);
        dao.save(m);
        return m.getIdLista();
    }


    // REVISAR ESTE METODO!

    public void agregarJugadoresEnLista(int idMiembro, Jugador jugador) throws MiembroException {
        MiembroDao dao = MiembroDao.getInstancia();
        Miembro miembro = dao.getMiembroById(idMiembro);
        if (miembro.getJugador() == null) {
            miembro.setJugador(jugador);
            dao.update(miembro);
        }
        throw new MiembroException("No existe una lista de jugadores con el id: " + idMiembro);
    }


}