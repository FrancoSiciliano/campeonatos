package org.grupocuatro.modelo;


import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.vo.ResponsableVO;

import javax.persistence.*;

@Entity
@Table(name = "representantes")
public class Responsable implements Comparable<Responsable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRepresentante")
    private Integer legajo;

    private Integer documento;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;


    public Responsable(Integer documento, String nombre, String apellido, Club club, String mail, String password) {
        this.legajo = null;
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public Responsable() {

    }

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Integer getDocumento() {
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

    public void setDocumento(Integer doc) {
        this.documento = doc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Responsable o) {
        return this.documento.compareTo(o.getDocumento());
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void save() {
        ResponsableDao.getInstancia().save(this);
    }

    public void update() {
        ResponsableDao.getInstancia().update(this);
    }

    public ResponsableVO toVO() {
        return new ResponsableVO(legajo, documento, nombre, apellido, mail, password, club.toVO());
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "legajo=" + legajo +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", club=" + club +
                '}';
    }
}
