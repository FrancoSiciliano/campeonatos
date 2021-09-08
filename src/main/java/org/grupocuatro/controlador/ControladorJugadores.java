package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import java.time.LocalDate;

public class ControladorJugadores {

    // No estaba el tipoDocumento, el documento era un String, no estaba el apellido.
    // Hay que agregarle el throw al método para que pueda manejar las excepciones
    // El método figuraba que devolvía un Integer como retorno.
    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, LocalDate fechaNacimiento) throws JugadorException {
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
    public void modificarJugador(int idJugador, int club){
        //COMPLETAR
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
        //HACER
    }

    //FIXME AGREGAR CONSULTA DE PROGRESO DEL EQUIPO DEL JUGADOR EN UN CAMPEONATO
//FIXME AGREGAR METODOS PARA OBTENER ESTADISTICAS JUGADORES (POR CAMP Y POR CLUB)

}
