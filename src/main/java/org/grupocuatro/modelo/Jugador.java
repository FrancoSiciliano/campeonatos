package org.grupocuatro.modelo;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador implements Comparable<Jugador> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJugador")
    private Integer idJugador;
    private String tipoDocumento;

    @Column(name = "numeroDocumento")
    private Integer documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String mail;
    private String telefono;
    private int categoria;
    private LocalDate fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    @OneToMany(mappedBy = "jugador")
    private List<Gol> goles;

    @OneToMany(mappedBy = "jugador")
    private List<Falta> faltas;

    @OneToMany(mappedBy = "jugador")
    private List<Miembro> partidos;


    public Jugador(String tipoDocumento, int documento, String nombre, String apellido, Club club, LocalDate fechaNacimiento, String direccion, String mail, String telefono) {
        this.idJugador = null;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.club = club;
        this.faltas = new ArrayList<>();
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int auxCategoria = Integer.parseInt(getYearFormat.format(this.fechaNacimiento));
        if (auxCategoria > 1999)
            this.categoria = auxCategoria - 1900;
        else
            this.categoria = auxCategoria - 2000;
        this.goles = new ArrayList<>();                 // Está en el constructor de abajo, ¿hay que sacarlo de acá?
    }

    public Jugador() {
        goles = new ArrayList<>();
        faltas = new ArrayList<>();
        partidos = new ArrayList<>(); //FIXME Este arreglo no va acá, no corresponde
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

    public String getEstadisticasCampeonato(Integer camp, int cantGoles, int cantAmarillas, int cantRojas, int cantJugados) {
        return "Jugador {" +
                "Id: " + idJugador + ", " +
                "Documento: " + documento + ", " +
                "Nombre: " + nombre + ", " +
                "Apellido: " + apellido + ", " +
                "Club: '" + this.getClub().getNombre() + "', " +
                "Campeonato: " + camp + ", " +
                "Partidos jugados: " + cantJugados + ", " +
                "Goles: " + cantGoles + ", " +
                "Amarillas: " + cantAmarillas + ", " +
                "Rojas: " + cantRojas + ", " +
                "}";
    }

    public String getEstadisticasClub(int cantGoles, int cantAmarillas, int cantRojas, int cantJugados) {
        return "Jugador {" +
                "Id: " + idJugador + ", " +
                "Documento: " + documento + ", " +
                "Nombre: " + nombre + ", " +
                "Apellido: " + apellido + ", " +
                "Club: '" + this.getClub().getNombre() + "', " +
                "Partidos jugados: " + cantJugados + ", " +
                "Goles: " + cantGoles + ", " +
                "Amarillas: " + cantAmarillas + ", " +
                "Rojas: " + cantRojas + ", " +
                "}";
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public int getCategoria() {
        return categoria;
    }

    public List<Gol> getGoles() {return goles;}

    public void agregarGol(Gol gol) {goles.add(gol);}

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
