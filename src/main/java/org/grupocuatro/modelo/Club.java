package org.grupocuatro.modelo;


import java.util.ArrayList;
import java.util.List;

public class Club implements Comparable<Club>{

	private Integer idClub;
	private String nombre;
	private String direccion;
	private List<Responsable> responsables;
	private List<Jugador> jugadores;
	private List<Campeonato> participanciones;
	
	public Club(int idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
		jugadores = new ArrayList<Jugador>();
	}
	
	public void asignarResponsable(Responsable responsable) {
		responsables.add(responsable);
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public Integer getIdClub() {
		return idClub;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Responsable> getResponsable() {
		return responsables;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public int compareTo(Club o) {
		return this.getIdClub().compareTo(o.getIdClub());
	}
	
	public boolean participa(Campeonato campeonato) {
		return participanciones.contains(campeonato);
	}
	public void participar(Campeonato campeonato) {
		participanciones.add(campeonato);
	}
	
	public void agregarJugadoresToListaLocal(Jugador jugador, Partido partido) {
		partido.agregarJugadoresLocales(new Miembro(this, partido, jugador));
	}
	
	public void agregarJugadoresToListaVisitante(Jugador jugador, Partido partido) {
		partido.agregarJugadoresVisitantes(new Miembro(this, partido, jugador));
	}
}
