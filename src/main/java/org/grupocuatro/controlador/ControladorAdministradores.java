package org.grupocuatro.controlador;

import org.grupocuatro.dao.AdministradorDao;
import org.grupocuatro.excepciones.AdministradorException;
import org.grupocuatro.modelo.Administrador;

public class ControladorAdministradores {

    private static ControladorAdministradores instancia;

    private ControladorAdministradores() {}

    public static ControladorAdministradores getInstancia() {
        if (instancia == null)
            instancia = new ControladorAdministradores();
        return instancia;
    }

    public void crearAdministrador(String nombre, String apellido, String tipoDoc, Integer documento, String mail, String password) throws AdministradorException {
        if (!AdministradorDao.getInstancia().existeAdministrador(documento)) {
            Administrador a = new Administrador(nombre, apellido, tipoDoc, documento, mail, password);
            a.save();
        } else {
            throw new AdministradorException("Ya existe un administrador con el documento " + documento);
        }
    }

    public boolean validarAdministrador(String mail, String password) {
        if (AdministradorDao.getInstancia().validarAdministrador(mail, password))
            return true;
        return false;
    }

    public void cambiarPassword(Integer idAdmin, String password) throws AdministradorException {
        Administrador a = AdministradorDao.getInstancia().getAdministrador(idAdmin);
        a.setPassword(password);
        a.update();
    }


}
