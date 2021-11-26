package org.grupocuatro.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class JugadorCampeonatoVO implements Serializable {

    private static final long serialVersionUID = -6983185710268483982L;
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
    private Integer idClub;
    private boolean estadoCampeonato;
    private Integer idCampeonato;

    public JugadorCampeonatoVO(){}

    public JugadorCampeonatoVO(Integer idJugador, String tipoDocumento, Integer documento, String nombre,
                               String apellido, String direccion, String mail, String password,
                               String telefono, int categoria, boolean estado, LocalDate fechaNacimiento,
                               LocalDate fechaAlta, Integer idClub, boolean estadoCampeonato, Integer idCampeonato) {
        this.idJugador = idJugador;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.mail = mail;
        this.password = password;
        this.telefono = telefono;
        this.categoria = categoria;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.idClub = idClub;
        this.estadoCampeonato = estadoCampeonato;
        this.idCampeonato = idCampeonato;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}

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

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public boolean getEstadoCampeonato() {
        return estadoCampeonato;
    }

    public void setEstadoCampeonato(boolean estadoCampeonato) {
        this.estadoCampeonato = estadoCampeonato;
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    @Override
    public String toString() {
        return "JugadorCampeonatoVO{" +
                "idJugador=" + idJugador +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                ", categoria=" + categoria +
                ", estado=" + estado +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaAlta=" + fechaAlta +
                ", idClub=" + idClub +
                ", estadoCampeonato=" + estadoCampeonato +
                ", idCampeonato=" + idCampeonato +
                '}';
    }
}
