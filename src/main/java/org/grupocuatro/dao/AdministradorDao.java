package org.grupocuatro.dao;

import org.grupocuatro.excepciones.AdministradorException;
import org.grupocuatro.modelo.Administrador;

import javax.persistence.NoResultException;

public class AdministradorDao extends AbstractDao {

    private static AdministradorDao instancia;

    private AdministradorDao() {}

    public static AdministradorDao getInstancia() {
        if (instancia == null)
            instancia = new AdministradorDao();
        return instancia;
    }

    public Administrador getAdministrador(Integer idAdmin) throws AdministradorException {
        try {
            Administrador a = (Administrador) getEntityManager().createQuery("FROM Administrador WHERE idAdmin = " + idAdmin).getSingleResult();
            return a;
        } catch (NoResultException c) {
            throw new AdministradorException("No existe un administrador con el id " + idAdmin);
        }
    }

    public boolean existeMailAdministrador(String mail) {
        try {
            Administrador a = (Administrador) getEntityManager().createQuery("FROM Administrador WHERE mail = '" + mail + "'").getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public boolean existeAdministrador(Integer documento) {
        try {
            getEntityManager().createQuery("FROM Administrador WHERE documento = " + documento).getSingleResult();
            return true;
        } catch (NoResultException c) {
            return false;
        }
    }

    public Integer loginAdministrador(String mail, String password) throws AdministradorException {
        try {
            Administrador a = (Administrador) getEntityManager().createQuery("FROM Administrador WHERE mail = '" + mail + "' AND password = '" + password + "'").getSingleResult();
            return a.getIdAdmin();

        } catch (NoResultException c) {
            throw new AdministradorException("No existe un administrador con ese correo electrónico o contraseña");
        }
    }

}
