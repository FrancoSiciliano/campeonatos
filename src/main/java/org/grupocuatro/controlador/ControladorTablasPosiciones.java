package org.grupocuatro.controlador;

import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;
import org.grupocuatro.vo.TablaPosicionesVO;

import java.util.ArrayList;
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

    public List<TablaPosicionesVO> getTablasPosicionesByClub(Integer idClub) throws TablaPosicionException {
        return transformarAListaVO(TablaPosicionDao.getInstancia().getTablasPosicionesByClub(idClub));

    }

    public TablaPosicionesVO getTablaPosicionesByClubAndCampeonato(Integer idClub, Integer idCampeonato) throws TablaPosicionException {
        return TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato).toVO();
    }

    public List<TablaPosicionesVO> getTablasPosicionesByCampeonato(Integer idCampeonato) throws TablaPosicionException {
        return transformarAListaVO(TablaPosicionDao.getInstancia().getTablaPosicionesByCampeonato(idCampeonato));
    }

    public List<TablaPosicionesVO> getTablaPosicionesByPuntos(int puntos) throws TablaPosicionException {
        return transformarAListaVO (TablaPosicionDao.getInstancia().getTablaPosicionesByPuntos(puntos));

    }

    private List<TablaPosicionesVO> transformarAListaVO(List<TablaPosiciones> lista) {
        List<TablaPosicionesVO> result = new ArrayList<>();
        for (TablaPosiciones item : lista) {
            result.add(item.toVO());
        }
        return result;
    }

}
