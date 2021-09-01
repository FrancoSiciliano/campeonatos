package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

import java.util.List;

public class ResponsableDao extends AbstractDao{

    private static ResponsableDao instancia;

    private ResponsableDao () {}

    public static ResponsableDao getInstancia(){
        if(instancia == null)
            instancia = new ResponsableDao();
        return instancia;
    }

    public List<Responsable> getResponsables() throws ResponsableException {
        List<Responsable> responsables = getEntityManager().createQuery("SELECT r FROM Responsable r").getResultList();
        if(responsables != null)
            return responsables;
        throw new ResponsableException("No existen responsables");
    }

    public List<Responsable> getResponsabesByClub(Integer club) throws ResponsableException {
        List<Responsable> responsables = getEntityManager().createQuery("FROM Responsable WHERE idClub = " + club).getResultList();
        if(responsables != null)
            return responsables;
        throw new ResponsableException("No existen responsables para ese club");
    }

    // Prueba

    public Responsable getResponsable(Integer id) throws ResponsableException {
        Responsable responsable = (Responsable) getEntityManager().createQuery("FROM Responsable WHERE idRepresentante = " + id).getSingleResult();
        if(responsable != null)
            return responsable;
        throw new ResponsableException("No existe el responsable que esta buscando");
    }
}
