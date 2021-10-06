package org.grupocuatro.controlador;

import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;
import org.grupocuatro.vo.TablaPosicionesVO;

import javax.persistence.NoResultException;
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

    public void actualizarTablaPosiciones(Integer idClub, Integer idCampeonato, int puntos, int golesFavor, int golesContra) throws ClubException, CampeonatoException, TablaPosicionException {
        TablaPosiciones tp;
        ControladorClubes controladorClubes = ControladorClubes.getInstancia();
        ControladorCampeonatos controladorCampeonatos = ControladorCampeonatos.getInstancia();

        try {
            tp = TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);
        } catch (NoResultException e) {
            tp = new TablaPosiciones(controladorClubes.getClubById(idClub).toModelo(), controladorCampeonatos.encontrarCampeonato(idCampeonato).toModelo());
            tp.save();
        }


        switch (puntos) {
            case 0:
                tp.setCantidadPerdidos(tp.getCantidadPerdidos() + 1);
                break;
            case 1:
                tp.setCantidadEmpatados(tp.getCantidadEmpatados() + 1);
                break;
            case 3:
                tp.setCantidadGanados(tp.getCantidadGanados() + 1);
                break;
        }

        tp.setPuntos(tp.getPuntos() + puntos);

        int difGoles = golesFavor - golesContra;

        tp.setDiferenciaGoles(tp.getDiferenciaGoles() + difGoles);
        tp.setGolesFavor(tp.getGolesFavor() + golesFavor);
        tp.setGolesContra(tp.getGolesContra() + golesContra);

        float ptos = tp.getPuntos();
        float partidosJugados = tp.getCantidadJugados();

        tp.setPromedio(ptos / partidosJugados);
        tp.update();
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
