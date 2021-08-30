package org.grupocuatro.modelo;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @ManyToOne
    private Club club;
    private Date fechaNacimiento;
    private int categoria;

    @OneToMany(mappedBy = "idPartido")
    private List<Gol> goles;

    @OneToMany(mappedBy = "idJugador")
    private List<Falta> faltas;

    @OneToMany(mappedBy = "idJugador")
    private List<Miembro> partidos;

    public Jugador(String tipoDocumento, int documento, String nombre, Club club, Date fechaNacimiento) {
        this.idJugador = null;
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int auxCategoria = Integer.parseInt(getYearFormat.format(this.fechaNacimiento));
        if (auxCategoria > 1999)
            this.categoria = auxCategoria - 1900;
        else
            this.categoria = auxCategoria - 2000;
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
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

    public Date getFechaNacimiento() {
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
