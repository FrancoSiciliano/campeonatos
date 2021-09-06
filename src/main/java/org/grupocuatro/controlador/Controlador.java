package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;

import java.util.Date;
import java.util.List;

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
        Miembro m = new Miembro(club, partido);
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

    public Integer crearPartido(int nroFecha, int nroZona, int categoria, int idClubLocal, int idClubVisitante, Date fechaPartido, int idCampeonato) throws PartidoException {
        try {
            Campeonato c = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            try {
                Club local = ClubDao.getInstancia().getClubById(idClubLocal);
                Club visitante = ClubDao.getInstancia().getClubById(idClubVisitante);
                Partido p = new Partido(nroFecha, nroZona, categoria, local, visitante, fechaPartido, c);
                PartidoDao.getInstancia().save(p);
                return p.getIdPartido();
            } catch (ClubException e) {
                System.out.println(e.getMessage());
            }
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
        throw new PartidoException("No se pudo agregar el partido");
    }

    public void cargarResultadoPartido(int idPartido) {
        try {
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);
            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    private int contarCantidadGoles(int idClub, int idPartido) {
        int cantGoles = 0;
        try {
            List<Gol> goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub);
            cantGoles = goles.size();
            return cantGoles;
        } catch (GolException e) {
            cantGoles = 0;
            return cantGoles;
        }
    }


}