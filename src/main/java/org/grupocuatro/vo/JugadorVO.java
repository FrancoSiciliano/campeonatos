package org.grupocuatro.vo;

import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class JugadorVO implements Serializable {
    private static final long serialVersionUID = -5107004978447553182L;
    private Integer idJugador;
    private String tipoDocumento;
    private Integer documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String mail;
    private String password;
    private String telefono;
    private int categoria;
    private boolean estado;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
    private ClubVO club;

    public JugadorVO () {

    }
    public JugadorVO(Integer idJugador,String tipoDocumento, int documento, String nombre, String apellido, ClubVO club, LocalDate fechaNacimiento, String direccion, String mail, String telefono, boolean estado, int categoria, String password){
        this.idJugador = idJugador;
        this.documento = documento;
        this.nombre = nombre;
        this.fechaAlta = LocalDate.now();
        this.apellido = apellido;
        this.club = club;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
        this.categoria = categoria;
        this.password = password;
    }

    public String getPassword(){return password;}

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public ClubVO getClub() {
        return club;
    }

    public void setClub(ClubVO club) {
        this.club = club;
    }

    public Jugador toModelo(){
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            return j;
        } catch (JugadorException e) {
            return new Jugador(this.tipoDocumento, this.documento, this.nombre, this.apellido, this.club.toModelo(), this.fechaNacimiento, this.direccion, this.mail, this.telefono, this.password);
        }

    }

    @Override
    public String toString() {
        return "JugadorVO{" +
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
                ", club=" + club +
                '}';
    }
}
