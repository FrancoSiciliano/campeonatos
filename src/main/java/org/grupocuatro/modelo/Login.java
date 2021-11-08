package org.grupocuatro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLogin;
    private String mail;
    private String password;
    private String rol;
    private Integer documento;

    public Login(){}

    public Login(String mail, String password, String rol, Integer documento) {
        this.mail = mail;
        this.password = password;
        this.rol = rol;
        this.documento = documento;
    }



}
