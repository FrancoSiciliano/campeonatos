package modelo;

import java.util.Date;
import java.util.List;

public class Partido {

	private Integer idPartido;
	private int nroFecha;
	private int nroZona;
	private int categoria;
	private Club clubLocal;
	private Club clubVisitante;
	private Integer golesLocal;
	private Integer golesVisitante;
	private Date fechaPartido;
	private boolean convalidaLocal;
	private boolean convalidaVisitante;
	private Campeonato campeonato;
	private List<Miembro> jugadoresLocales;
	private List<Miembro> jugadoresVisitantes;

	public Partido(int nroFecha, int nroZona, int categoria, Club clubLocal, Club clubVisitante, 
			       Date fechaPartido, Campeonato campeonato) {
		this.nroFecha = nroFecha;
		this.nroZona = nroZona;
		this.categoria = categoria;
		this.clubLocal = clubLocal;
		this.clubVisitante = clubVisitante;
		this.golesLocal = null;
		this.golesVisitante = null;
		this.fechaPartido = fechaPartido;
		this.convalidaLocal = false;
		this.convalidaVisitante = false;
		this.campeonato = campeonato;
	}

	public Integer getIdPartido() {
		return idPartido;
	}

	public int getNroFecha() {
		return nroFecha;
	}

	public int getNroZona() {
		return nroZona;
	}

	public int getCategoria() {
		return categoria;
	}

	public Club getClubLocal() {
		return clubLocal;
	}

	public Club getClubVisitante() {
		return clubVisitante;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public Integer getGolesVisitante() {
		return golesVisitante;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public boolean isConvalidaLocal() {
		return convalidaLocal;
	}

	public boolean isConvalidaVisitante() {
		return convalidaVisitante;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public List<Miembro> getJugadoresLocales() {
		return jugadoresLocales;
	}

	public List<Miembro> getJugadoresVisitantes() {
		return jugadoresVisitantes;
	}

	public void setNroFecha(int nroFecha) {
		this.nroFecha = nroFecha;
	}

	public void setNroZona(int nroZona) {
		this.nroZona = nroZona;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void setClubLocal(Club clubLocal) {
		this.clubLocal = clubLocal;
	}

	public void setClubVisitante(Club clubVisitante) {
		this.clubVisitante = clubVisitante;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public void setConvalidaLocal() {
		this.convalidaLocal = true;
	}

	public void setConvalidaVisitante() {
		this.convalidaVisitante = true;
	}

	public void agregarJugadoresLocales(Miembro miembro) {
		this.jugadoresLocales.add(miembro);
	}

	public void agregarJugadoresVisitantes(Miembro miembro) {
		this.jugadoresVisitantes.add(miembro);
	}
	
	
	
}
