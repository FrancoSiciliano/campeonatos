package org.grupocuatro.controlador;

import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;

import java.util.List;

public class ControladorTablasPosiciones {

    private static ControladorTablasPosiciones instancia;

    private ControladorTablasPosiciones() {
    }

    public static ControladorTablasPosiciones getInstancia() {
        if (instancia == null)
            instancia = new ControladorTablasPosiciones();
        return instancia;
    }

    public List<TablaPosiciones> getTablasPosicionesByClub(Integer idClub) {
        try {
            List<TablaPosiciones> tablas = TablaPosicionDao.getInstancia().getTablasPosicionesByClub(idClub);
            return tablas;
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public TablaPosiciones getTablaPosicionesByClubAndCampeonato(Integer idClub, Integer idCampeonato) {
        try {
            TablaPosiciones tabla = TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);
            return tabla;
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<TablaPosiciones> getTablasPosicionesByCampeonato(Integer idCampeonato) {
        try {
            List<TablaPosiciones> tablas = TablaPosicionDao.getInstancia().getTablaPosicionesByCampeonato(idCampeonato);
            return tablas;
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<TablaPosiciones> getTablaPosicionesByPuntos(int puntos) {
        try {
            List<TablaPosiciones> tablas = TablaPosicionDao.getInstancia().getTablaPosicionesByPuntos(puntos);
            return tablas;
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
