package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.Date;

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
		Club club = ClubDao.getInstancia().getClubPorNombre(nombre);
		if (club != null) {
			club.setNombre(nombre);
			club.setDireccion(direccion);
			ClubDao.getInstancia().update(club);
		}
	}


	// No estaba el tipoDocumento, el documento era un String, no estaba el apellido.
	// Hay que agregarle el throw al método para que pueda manejar las excepciones
	// El método figuraba que devolvía un Integer como retorno.

	public void agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, Date fechaNacimiento) throws ClubException, JugadorException {
		if (JugadorDao.getInstancia().getJugadorByDocumento(documento, tipoDocumento) == null) {
			Club club = ClubDao.getInstancia().getClubPorId(idClub);
			if (club != null)
				JugadorDao.getInstancia().save(new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento));
		}
	}


	public void eliminarJugador(int idJugador, int idClub) throws JugadorException {
		Jugador player = JugadorDao.getInstancia().getJugadorByID(idJugador);
		if(player != null){
			if(player.getClub().getIdClub() == idClub)
				JugadorDao.getInstancia().delete(player);
		}
	}
	
	public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {	}
	
	public Integer crearListaJugadores(Club club, Partido partido) { return null;}
	
	public void agregarJugadoresEnLista() {}
}
