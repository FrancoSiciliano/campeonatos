package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import java.util.Date;
import java.util.List;

public class Controlador {

	private static Controlador instancia;

	private Controlador() { }

	public static Controlador getInstancia(){
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

	public void modificarClub(String nombre, String direccion) throws ClubException {
		ClubDao dao = ClubDao.getInstancia();
		Club club = dao.getClubPorNombre(nombre);
		if (club != null) {
			club.setNombre(nombre);
			club.setDireccion(direccion);
			dao.update(club);
		}
	}


	// No estaba el tipoDocumento, el documento era un String, no estaba el apellido.
	// Hay que agregarle el throw al método para que pueda manejar las excepciones
	// El método figuraba que devolvía un Integer como retorno.

	public void agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, Date fechaNacimiento) throws ClubException, JugadorException {
		JugadorDao dao = JugadorDao.getInstancia();
		if (dao.getJugadorByDocumento(documento, tipoDocumento) == null) {
			Club club = ClubDao.getInstancia().getClubPorId(idClub);
			if (club != null)
				dao.save(new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento));
		}
	}


	public void eliminarJugador(int idJugador, int idClub) throws JugadorException {
		JugadorDao dao = JugadorDao.getInstancia();
		Jugador player = dao.getJugadorByID(idJugador);
		if(player != null){
			if(player.isClub(idClub))
				dao.delete(player);
		}
	}

	public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {
	}

	// El método vino con el Integer como retorno, pero se lo cambió a void.

	public void crearListaJugadores(Club club, Partido partido) {
		MiembroDao dao = MiembroDao.getInstancia();
		if (dao.getListaByClubAndPartido(club.getIdClub(), partido.getIdPartido()) == null) {
			dao.save(new Miembro(club, partido));
		}
	}


	// REVISAR ESTE METODO!

	public void agregarJugadoresEnLista(int idMiembro, Jugador jugador) {
		MiembroDao dao = MiembroDao.getInstancia();
		Miembro lista = dao.getListaById(idMiembro);
		if (lista.getJugador() == null) {
			dao.save(lista.setJugador(jugador));
		}
		throw new MiembroException("No existe una lista de jugadores con el id: " + idMiembro);
	}


}