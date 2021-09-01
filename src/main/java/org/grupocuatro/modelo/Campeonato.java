package org.grupocuatro.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "campeonatos")
public class Campeonato implements Comparable<Campeonato>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCampeonato")
	private Integer idCampeonato;

	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;

	@OneToMany(mappedBy = "idClub")
	private List<Club> inscriptos;

	@OneToMany(mappedBy = "campeonato")
	private List<Partido> partidos;

	@OneToMany(mappedBy = "campeonato")
	private List<Falta> faltas;


	@OneToOne(mappedBy = "campeonato")
	private TablaPosiciones tablaPosiciones;
	
	public Campeonato(String descripcion, Date fechaInicio, Date fechaFin, String estado) {
		this.idCampeonato = null;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public Campeonato() {
		partidos = new ArrayList<>();
		inscriptos = new ArrayList<>();
		faltas = new ArrayList<>();
	}

	public TablaPosiciones getTablaPosiciones(){
		return tablaPosiciones;
	}

	public void setTablaPosiciones(TablaPosiciones tablaPosiciones) {
		this.tablaPosiciones = tablaPosiciones;
	}

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public int compareTo(Campeonato o) {
		return this.getIdCampeonato().compareTo(o.getIdCampeonato());
	}
	
	public void inscribirClub(Club club) {
		inscriptos.add(club);
		if(!club.participa(this))
			club.participar(this);
	}

	@Override
	public String toString() {
		return "Campeonato{" +
				"idCampeonato=" + idCampeonato +
				", descripcion='" + descripcion + '\'' +
				", fechaInicio=" + fechaInicio +
				", fechaFin=" + fechaFin +
				", estado='" + estado + '\'' +
				'}';
	}
}
