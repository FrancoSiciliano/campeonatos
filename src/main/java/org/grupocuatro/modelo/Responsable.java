package org.grupocuatro.modelo;

public class Responsable implements Comparable<Responsable>{

	private Integer legajo;
	private String documento;
	private String nombre;
	private Club club;
	
	
	public Responsable(String documento, String nombre, Club club) {
		this.legajo = null;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public int compareTo(Responsable o) {
		return this.documento.compareTo(o.getDocumento());
	}

	public Integer getLegajo() {
		return legajo;
	}
}
