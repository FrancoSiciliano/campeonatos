package org.grupocuatro.dao;

import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Miembro;

import java.util.List;

public class MiembroDao extends AbstractDao {

    private static MiembroDao instancia;

    private MiembroDao() {
    }

    public static MiembroDao getInstancia() {
        if (instancia == null)
            instancia = new MiembroDao();
        return instancia;
    }

    public Miembro getMiembroById(Integer id) throws MiembroException {
        Miembro miembro = (Miembro) getEntityManager().createQuery("FROM Miembro WHERE idLista = " + id).getSingleResult();
        if (miembro != null) return miembro;
        throw new MiembroException("No existe un miembro con id: " + id);
    }

    public List<Miembro> getMiembros() throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("SELECT m FROM Miembro m").getResultList();
        if (miembros != null) return miembros;
        throw new MiembroException("No existen listas");
    }

    public List<Miembro> getMiembrosByClub(Integer idClub) throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("FROM Miembro WHERE idClub = " + idClub).getResultList();
        if (miembros != null) return miembros;
        throw new MiembroException("El club " + idClub + " no posee una lista");
    }

    public List<Miembro> getMiembrosByClubAndPartido(Integer idClub, Integer idPartido) throws MiembroException {
        List<Miembro> miembros = getEntityManager().createQuery("FROM Miembro WHERE idClub = " + idClub + " and idPartido = " + idPartido).getResultList();
        if (miembros != null) return miembros;
        throw new MiembroException("El club " + idClub + "no posee una lista para el partido " + idPartido);
    }

}
