package org.grupocuatro.dao;

import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;

import javax.persistence.NoResultException;
import java.util.List;

public class TablaPosicionDao extends AbstractDao {

    private static TablaPosicionDao instancia;

    private TablaPosicionDao() {
    }

    public static TablaPosicionDao getInstancia() {
        if (instancia == null) instancia = new TablaPosicionDao();
        return instancia;
    }

    public List<TablaPosiciones> getTablasPosicionesByClub(Integer id) throws TablaPosicionException {
        List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE idClub = " + id).getResultList();
        if (!tablas.isEmpty()) return tablas;
        throw new TablaPosicionException("El club de id: " + id + " no tiene tabla asociada");
    }

    public TablaPosiciones getTablaPosicionesByClubAndCampeonato(Integer idClub, Integer idCampeonato) throws TablaPosicionException {
        try {
            return (TablaPosiciones) getEntityManager().createQuery("FROM TablaPosiciones WHERE idClub = " + idClub + "and idCampeonato = " + idCampeonato).getSingleResult();
        } catch (NoResultException e) {
            throw new TablaPosicionException("El club de id: " + idClub + " nó jugo el torneo " + idCampeonato);
        }

    }

    public List<TablaPosiciones> getTablaPosicionesByCampeonato(Integer id) throws TablaPosicionException {
       List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE idCampeonato = " + id).getResultList();
       if (!tablas.isEmpty()) return tablas;
       throw new TablaPosicionException("No existe el torneo de id: " + id);
    }


    public List<TablaPosiciones> getTablaPosicionesByPuntos(int puntos) throws TablaPosicionException {
        List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE puntos = " + puntos).getResultList();
        if (!tablas.isEmpty()) return tablas;
        throw new TablaPosicionException("No existe una tabla con ese puntaje");
    }
}
