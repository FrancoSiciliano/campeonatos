package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

import javax.persistence.NoResultException;

import javax.persistence.NoResultException;
import java.util.List;

public class ResponsableDao extends AbstractDao {

    private static ResponsableDao instancia;

    private ResponsableDao() {
    }

    public static ResponsableDao getInstancia() {
        if (instancia == null)
            instancia = new ResponsableDao();
        return instancia;
    }

    public List<Responsable> getResponsables() throws ResponsableException {
        List<Responsable> responsables = getEntityManager().createQuery("SELECT r FROM Responsable r").getResultList();
        if (!responsables.isEmpty()) return responsables;
        throw new ResponsableException("No existen responsables");
    }

    public List<Responsable> getResponsablesByClub(Integer club) throws ResponsableException {
        List<Responsable> responsables = getEntityManager().createQuery("FROM Responsable WHERE idClub = " + club).getResultList();
        if (!responsables.isEmpty()) return responsables;
        throw new ResponsableException("No existen responsables para el club de id: " + club);
    }

    public Responsable getResponsableByNroDocAndClub(Integer nroDoc, Integer club) throws ResponsableException {
        try {
            return (Responsable) getEntityManager().createQuery("FROM Responsable WHERE documento = '" + nroDoc + "' and idClub = " + club).getSingleResult();
        } catch (NoResultException e) {
            throw new ResponsableException("No existe un responsable con numero de documento " + nroDoc + " en el club de id: " + club);
        }

    }

    public Responsable getResponsable(Integer id) throws ResponsableException {
        try {
            return (Responsable) getEntityManager().createQuery("FROM Responsable WHERE idRepresentante = " + id).getSingleResult();
        } catch (Exception e) {
            throw new ResponsableException("No existe el responsable de id: " + id);
        }
    }

    public boolean existeResponsableEnClub(Integer documento, Integer idClub) {
        try {
            getEntityManager().createQuery("FROM Responsable WHERE documento = " + documento + " AND idClub = " + idClub).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public Integer validarResponsable(String mail, String password) throws ResponsableException {
        try {
            Responsable r = (Responsable) getEntityManager().createQuery("FROM Responsable WHERE mail = '" + mail + "' AND password = '" + password + "'").getSingleResult();
            return r.getLegajo();
        } catch (NoResultException c) {
            throw new ResponsableException("No existe un responsable con ese correo electr??nico o contrase??a");
        }
    }

    public boolean existeMailResponsable(String mail) {
        try {
           Responsable r = (Responsable) getEntityManager().createQuery("FROM Responsable WHERE mail = '" + mail + "'").getSingleResult();
           return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public boolean existeDocumentoResponsable(Integer documento) {
        try {
            Responsable r = (Responsable) getEntityManager().createQuery("FROM Responsable WHERE documento = " + documento).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }


}
