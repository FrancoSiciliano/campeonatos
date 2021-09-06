package org.grupocuatro.modelo;


import org.grupocuatro.dao.ResponsableDao;

import javax.persistence.*;

@Entity
@Table(name = "representantes")
public class Responsable implements Comparable<Responsable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRepresentante")
    private Integer legajo;

    private String documento;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;


    public Responsable(String documento, String nombre, Club club) {
        this.legajo = null;
        this.documento = documento;
        this.nombre = nombre;
        this.club = club;
    }

    public Responsable() {

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

    public void setDocumento (String doc) { this.documento = doc; }

    public void setNombre (String nombre) { this.nombre = nombre; }

    @Override
    public int compareTo(Responsable o) {
        return this.documento.compareTo(o.getDocumento());
    }

    public Integer getLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "legajo=" + legajo +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", club=" + club +
                '}';
    }

    public void save(){
        ResponsableDao.getInstancia().save(this);
    }
    public void update(){
        ResponsableDao.getInstancia().update(this);
    }
}
