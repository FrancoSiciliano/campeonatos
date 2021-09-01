package org.grupocuatro.modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clubes")
public class Club implements Comparable<Club>{

	@Id
	@Column(name = "idClub")
	private Integer idClub;
	private String nombre;
	private String direccion;

	@OneToMany(mappedBy = "club")
	private List<Responsable> responsables;

	@OneToMany(mappedBy = "club")
	private List<Jugador> jugadores;

	@OneToMany(mappedBy = "idCampeonato")
	private List<Campeonato> participaciones;

	@OneToMany(mappedBy = "clubLocal")
	private List<Partido> partidosLocal;

	@OneToMany(mappedBy = "clubVisitante")
	private List<Partido> partidosVisitante;

	@OneToMany(mappedBy = "club")
	private List<Miembro> miembros;

	@OneToMany(mappedBy = "id")
	private List<TablaPosiciones> tablasPosiciones;


	public List<Responsable> getResponsables() {
		return responsables;
	}

	public Club(int idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
		jugadores = new ArrayList<Jugador>();
	}

	public Club() {
		participaciones = new ArrayList<>();
		partidosVisitante = new ArrayList<>();
		miembros = new ArrayList<>();
		partidosLocal = new ArrayList<>();
		tablasPosiciones = new ArrayList<>();
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
		return participaciones.contains(campeonato);
	}
	public void participar(Campeonato campeonato) {
		participaciones.add(campeonato);
	}
	
	public void agregarJugadoresToListaLocal(Jugador jugador, Partido partido) {
		partido.agregarJugadoresLocales(new Miembro(this, partido, jugador));
	}
	
	public void agregarJugadoresToListaVisitante(Jugador jugador, Partido partido) {
		partido.agregarJugadoresVisitantes(new Miembro(this, partido, jugador));
	}
}
