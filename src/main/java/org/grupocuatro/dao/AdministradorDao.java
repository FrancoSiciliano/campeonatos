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

    public Administrador getAdministradorByMail(String mail) throws AdministradorException {
        try {
            Administrador a = (Administrador) getEntityManager().createQuery("FROM Administrador WHERE mail = '" + mail + "'").getSingleResult();
            return a;
        } catch (NoResultException e) {
            throw new AdministradorException("No existe un administrador con el mail " + mail);
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

    public boolean validarAdministrador(String mail, String password) {
        try {
            getEntityManager().createQuery("FROM Administrador WHERE mail = '" + mail + "' AND password = '" + password + "'").getSingleResult();
            return true;
        } catch (NoResultException c) {
            return false;
        }
    }

}
