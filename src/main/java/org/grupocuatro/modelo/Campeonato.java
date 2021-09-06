package org.grupocuatro.modelo;

import org.grupocuatro.dao.CampeonatoDao;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String estado;

	@OneToMany(mappedBy = "idClub")
	private List<Club> inscriptos;

	@OneToMany(mappedBy = "campeonato")
	private List<Partido> partidos;

	@OneToMany(mappedBy = "campeonato")
	private List<Falta> faltas;


	@OneToMany(mappedBy = "campeonato")
	private List<TablaPosiciones> tablaPosiciones;
	
	public Campeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
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
		tablaPosiciones = new ArrayList<>();
	}

	public List<TablaPosiciones> getTablaPosiciones(){
		return tablaPosiciones;
	}

	public void setTablaPosiciones(List<TablaPosiciones> tablaPosiciones) {
		this.tablaPosiciones = tablaPosiciones;
	}

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {this.estado = estado;}

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

	public void save() {
		CampeonatoDao.getInstancia().save(this);
	}

	public void update() {
		CampeonatoDao.getInstancia().update(this);
	}
}
