package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

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
        throw new ResponsableException("No existen responsables para el club " + club);
    }

    public Responsable getResponsable(Integer id) throws ResponsableException {
        try {
            Responsable responsable = (Responsable) getEntityManager().createQuery("FROM Responsable WHERE idRepresentante = " + id).getSingleResult();
            return responsable;
        } catch (Exception e) {
            throw new ResponsableException("No existe el responsable de id " + id);
        }

    }
}
