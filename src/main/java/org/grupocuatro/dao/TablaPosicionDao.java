package org.grupocuatro.dao;

import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;

import java.util.List;

public class TablaPosicionDao extends AbstractDao {

    private static TablaPosicionDao instancia;

    private TablaPosicionDao() {
    }

    public static TablaPosicionDao getInstancia() {
        if (instancia == null) instancia = new TablaPosicionDao();
        return instancia;
    }

    public List<TablaPosiciones> getTablaPosicionesByClub(int id) throws TablaPosicionException {
        List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE idClub = " + id).getResultList();
        if (!tablas.isEmpty()) return tablas;
        throw new TablaPosicionException("El club de id " + id + " no tiene tabla asociada");
    }

    public TablaPosiciones getTablaPosicionesByClubAndCampeonato(int idClub, int idCampeonato) throws TablaPosicionException {
        try {
            TablaPosiciones tabla = (TablaPosiciones) getEntityManager().createQuery("FROM TablaPosiciones WHERE idClub = " + idClub + "and idCampeonato = " + idCampeonato).getSingleResult();
            return tabla;
        } catch (Exception e) {
            throw new TablaPosicionException("El club " + idClub + " nó jugo el torneo " + idCampeonato);
        }

    }

    public List<TablaPosiciones> getTablaPosicionesByCampeonato(int id) throws TablaPosicionException {
        List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE idCampeonato = " + id).getResultList();
        if (!tablas.isEmpty()) return tablas;
        throw new TablaPosicionException("No existe el torneo " + id);
    }

    public List<TablaPosiciones> getTablaPosicionesByPuntos(int puntos) throws TablaPosicionException {
        List<TablaPosiciones> tablas = getEntityManager().createQuery("FROM TablaPosiciones WHERE puntos = " + puntos).getResultList();
        if (!tablas.isEmpty()) return tablas;
        throw new TablaPosicionException("No existe una Tabla con ese puntaje");
    }
}
