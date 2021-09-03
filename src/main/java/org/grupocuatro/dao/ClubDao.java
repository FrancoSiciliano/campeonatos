package org.grupocuatro.dao;

import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Club;

import java.util.List;

public class ClubDao extends AbstractDao{
    private static ClubDao instancia;
    private ClubDao(){}

    public static ClubDao getInstancia(){
        if(instancia==null)
            instancia =  new ClubDao();
        return instancia;
    }

    public Club getClubPorId(Integer id) throws ClubException {
        Club result = (Club) getEntityManager().createQuery("FROM clubes WHERE id = " + id).getSingleResult();
        if (result != null)
            return result;
        throw new ClubException("No existe un club con ID " + id);
    }

    public Club getClubPorNombre(String nombre) throws ClubException {
        Club result = (Club) getEntityManager().createQuery("FROM clubes WHERE nombre = " + nombre).getSingleResult();
        if (result != null)
            return result;
        throw new ClubException("No existe un club con nombre " + nombre);
    }

    public List<Club> getClubes() {
        return (List<Club>) getEntityManager().createQuery("SELECT c FROM Club c").getResultList();
    }




}
