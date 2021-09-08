package org.grupocuatro.modelo;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador implements Comparable<Jugador> {

    //FIXME AGREGAR DIRECCION DE  CASA, MAIL Y TELEFONO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJugador")
    private Integer idJugador;
    private String tipoDocumento;

    @Column(name = "numeroDocumento")
    private Integer documento;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;
    private LocalDate fechaNacimiento;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private int categoria;

    @OneToMany(mappedBy = "jugador")
    private List<Gol> goles;

    @OneToMany(mappedBy = "jugador")
    private List<Falta> faltas;

    @OneToMany(mappedBy = "jugador")
    private List<Miembro> partidos;

    public Jugador(String tipoDocumento, int documento, String nombre, String apellido, Club club, LocalDate fechaNacimiento) {
        this.idJugador = null;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.club = club;
        this.faltas = new ArrayList<>();
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int auxCategoria = Integer.parseInt(getYearFormat.format(this.fechaNacimiento));
        if (auxCategoria > 1999)
            this.categoria = auxCategoria - 1900;
        else
            this.categoria = auxCategoria - 2000;
        this.goles = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", club=" + club +
                ", fechaNacimiento=" + fechaNacimiento +
                ", categoria=" + categoria +
                '}';
    }

    public Jugador() {
        goles = new ArrayList<>();
        faltas = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public int getDocumento() {
        return documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getCategoria() {
        return categoria;
    }

    public List<Gol> getGoles() {
        return goles;
    }

    public void agregarGol(Gol gol) {
        goles.add(gol);
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void agregarFalta(Falta falta) {
        faltas.add(falta);
    }

    public boolean isClub(int idClub) {
        return getClub().getIdClub() == idClub;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public int compareTo(Jugador o) {
        return this.documento.compareTo(o.getDocumento());
    }


}
