package org.grupocuatro.modelo;

import org.grupocuatro.dao.AdministradorDao;
import org.grupocuatro.dao.GolDao;
import org.grupocuatro.vo.AdministradorVO;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private Integer documento;
    private String mail;
    private String password;

    public Administrador(){}

    public Administrador(String nombre, String apellido, String tipoDocumento, Integer documento, String mail, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.mail = mail;
        this.password = password;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Integer getIdAdmin() {return idAdmin;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getTipoDocumento() {return tipoDocumento;}

    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}

    public Integer getDocumento() {return documento;}

    public void setDocumento(Integer documento) {this.documento = documento;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public void save() {
        AdministradorDao.getInstancia().save(this);
    }

    public void update() {
        AdministradorDao.getInstancia().update(this);
    }

    public AdministradorVO toVO() {
        return new AdministradorVO(this.idAdmin, this.nombre, this.apellido, this.tipoDocumento, this.documento, this.mail, this.password);
    }
}
