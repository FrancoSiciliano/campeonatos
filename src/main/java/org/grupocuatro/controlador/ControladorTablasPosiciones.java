package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
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

    public void generarTablaIncial(List<Club> clubes, Campeonato campeonato) throws CampeonatoException {
        TablaPosiciones tp;

        for (Club c : clubes) {
            tp = new TablaPosiciones(c, campeonato);
            tp.update();
        }
    }

    public void actualizarTablaPosiciones(Integer idClub, Integer idCampeonato, int puntos, int golesFavor, int golesContra) throws ClubException, CampeonatoException, TablaPosicionException {
        TablaPosiciones tp;
        ControladorClubes controladorClubes = ControladorClubes.getInstancia();
        ControladorCampeonatos controladorCampeonatos = ControladorCampeonatos.getInstancia();

        tp = TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);


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
        return transformarAListaVO(TablaPosicionDao.getInstancia().getTablaPosicionesByPuntos(puntos));

    }

    public List<List<TablaPosicionesVO>> getTablaPosicionesPorZona (Integer idCampeonato) throws PartidoException, ClubesCampeonatoException, TablaPosicionException {
        int cantZonas = PartidoDao.getInstancia().getCantZonasCampeonato(idCampeonato);
        List<List<TablaPosicionesVO>> resultado = new ArrayList<>(cantZonas);
        for(int i = 0; i < cantZonas; i++){
            resultado.add(new ArrayList<>());
        }
        List<Club> clubes = ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(idCampeonato);
        for(Club c : clubes){
            int zona = PartidoDao.getInstancia().getZonaClubCampeonato(idCampeonato,c.getIdClub());
            resultado.get(zona-1).add(TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(c.getIdClub(),idCampeonato).toVO());
        }

        return resultado;
    }

    private List<TablaPosicionesVO> transformarAListaVO(List<TablaPosiciones> lista) {
        List<TablaPosicionesVO> result = new ArrayList<>();
        for (TablaPosiciones item : lista) {
            result.add(item.toVO());
        }
        return result;
    }

}
