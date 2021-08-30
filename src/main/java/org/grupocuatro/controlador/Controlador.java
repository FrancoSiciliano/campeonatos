package controlador;

import java.util.Date;

import modelo.Club;
import modelo.Partido;

public class Controlador {

	public Controlador() { }
	
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
	public void modificarClub(String nombre, String direccion) { }
	
	public Integer agregarJugador(String documento, String nombre, int idClub, Date fechaNacimiento) { return null; }
	
	public void eliminarJugador(int idJugador, int idClub) { }
	
	public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {	}
	
	public Integer crearListaJugadores(Club club, Partido partido) { return null;}	
	
	public void agregarJugadoresEnLista() {}
}
