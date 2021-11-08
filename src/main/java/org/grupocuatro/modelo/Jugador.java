package org.grupocuatro.modelo;

import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.vo.JugadorVO;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private boolean estado;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    @OneToMany(mappedBy = "jugador")
    private List<Gol> goles;

    @OneToMany(mappedBy = "jugador")
    private List<Falta> faltas;

    @OneToMany(mappedBy = "jugador")
    private List<Miembro> partidos;

    @OneToMany(mappedBy = "jugador")
    private List<ListadoJugadoresDeshabilitados> listadoDeshabilitado;

    public Jugador(String tipoDocumento, int documento, String nombre, String apellido, Club club, LocalDate fechaNacimiento, String direccion, String mail, String telefono) {
        this.idJugador = null;
        this.documento = documento;
        this.nombre = nombre;
        this.fechaAlta = LocalDate.now();
        this.apellido = apellido;
        this.club = club;
        this.estado = true;
        this.faltas = new ArrayList<>();
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;

        int auxCategoria = fechaNacimiento.getYear();
        this.categoria = auxCategoria - 1900;
    }

    public Jugador() {
        goles = new ArrayList<>();
        faltas = new ArrayList<>();
        partidos = new ArrayList<>();
        listadoDeshabilitado = new ArrayList<>();
    }


    public String getEstadisticasCampeonato(Integer camp, int cantGoles, int cantAmarillas, int cantRojas, int cantJugados) {
        return "Jugador: \n" +
                "- Id: " + idJugador + "\n" +
                "- Documento: " + documento + "\n" +
                "- Nombre: " + nombre + "\n" +
                "- Apellido: " + apellido + "\n" +
                "- Club: " + this.getClub().getNombre() + "\n" +
                "- Campeonato: " + camp + "\n" +
                "- Partidos jugados: " + cantJugados + "\n" +
                "- Goles: " + cantGoles + "\n" +
                "- Amarillas: " + cantAmarillas + "\n" +
                "- Rojas: " + cantRojas + "\n";
    }

    public String getEstadisticasClub(int cantGoles, int cantAmarillas, int cantRojas, int cantJugados) {
        return "Jugador: \n" +
                "- Id: " + idJugador + "\n" +
                "- Documento: " + documento + "\n" +
                "- Nombre: " + nombre + "\n" +
                "- Apellido: " + apellido + "\n" +
                "- Club: " + this.getClub().getNombre() + "\n" +
                "- Partidos jugados: " + cantJugados + "\n" +
                "- Goles: " + cantGoles + "\n" +
                "- Amarillas: " + cantAmarillas + "\n" +
                "- Rojas: " + cantRojas + "\n";
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        setCategoria(fechaNacimiento.getYear()-1900);
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCategoria() {
        return categoria;
    }

    public List<Gol> getGoles() {
        return goles;
    }

    public List<Falta> getFaltas() {
        return faltas;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isSuClub(Integer idClub) {
        return Objects.equals(club.getIdClub(), idClub);
    }

    @Override
    public int compareTo(Jugador o) {
        return this.documento.compareTo(o.getDocumento());
    }

    public void save() {
        JugadorDao.getInstancia().save(this);
    }

    public void update() {
        JugadorDao.getInstancia().update(this);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                ", categoria=" + categoria +
                ", estado=" + estado +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

    public JugadorVO toVO() {
        return new JugadorVO(this.idJugador, this.tipoDocumento, this.documento, this.nombre, this.apellido, this.club.toVO(), this.fechaNacimiento, this.direccion, this.mail, this.telefono, this.estado, this.categoria);
    }

    //AGREGAR
    public void agregarGol(Gol gol) {
        gol.setJugador(this);
        gol.save();
    }

    public void agregarFalta(Falta falta) {
        falta.setJugador(this);
        falta.save();
    }

}
