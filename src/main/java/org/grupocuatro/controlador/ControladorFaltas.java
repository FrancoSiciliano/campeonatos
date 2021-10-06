package org.grupocuatro.controlador;

import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.FaltaVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorFaltas {
    private static ControladorFaltas instancia;

    private ControladorFaltas() {
    }

    public static ControladorFaltas getInstancia() {
        if (instancia == null)
            instancia = new ControladorFaltas();
        return instancia;
    }

    public Integer cargarFalta(Integer idJugador, Integer idPartido, Integer minuto, String tipo) throws MiembroException, JugadorException, PartidoException, FaltaException {
        Jugador jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador).toModelo();
        Partido partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido).toModelo();
        Miembro miembro = ControladorMiembros.getInstancia().getMiembroByPartidoAndJugador(idPartido, idJugador).toModelo();
        Falta falta = null;

        if (minuto >= miembro.getIngreso() && minuto <= miembro.getEgreso()) {
            falta = new Falta(jugador, partido, minuto, tipo);
            falta.save();

            if (!tipo.equals("roja")) {
                if (correspondeRoja(idJugador, idPartido)) {
                    falta = new Falta(jugador, partido, minuto, "roja");
                    falta.save();
                }
            }

        }
        return falta.getIdFalta();
    }

    private boolean correspondeRoja(Integer idJugador, Integer idPartido) throws FaltaException {
        List<Falta> listaFaltas = FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "amarilla", idPartido);
        return listaFaltas.size() == 2;
    }

    public List<FaltaVO> getFaltas() throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltas());

    }

    public FaltaVO getFaltaById(Integer id) throws FaltaException {
        return FaltaDao.getInstancia().getFaltaById(id).toVO();

    }

    public List<FaltaVO> getFaltasPartido(Integer idPartido) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByPartido(idPartido));

    }

    public List<FaltaVO> getFaltasByTipoAndPartido(Integer idPartido, String tipo) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByPartidoAndTipo(idPartido, tipo));

    }

    public List<FaltaVO> getFaltasByCampeonato(Integer idCampeonato) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByCampeonato(idCampeonato));

    }

    public List<FaltaVO> getFaltasByJugadorAndPartido(Integer idJugador, Integer idPartido) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByJugadorAndPartido(idJugador, idPartido));

    }

    public List<FaltaVO> getFaltasByJugadorAndTipoAndPartido(Integer jugador, String tipo, Integer partido) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador, tipo, partido));

    }

    public List<FaltaVO> getFaltasByJugadorAndCampeonato(Integer jugador, Integer campeonato) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByJugadorAndCampeonato(jugador, campeonato));

    }

    public List<FaltaVO> getFaltasByJugadorAndPartidoAndTipo(Integer jugador, Integer partido, String tipo) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador, tipo, partido));

    }

    public List<FaltaVO> getFaltasByJugador(Integer idJugador) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByJugador(idJugador));

    }

    public List<FaltaVO> getFaltasByTipo(String tipo) throws FaltaException {
        return transformarAListaVO(FaltaDao.getInstancia().getFaltasByTipo(tipo));

    }
    public List<Falta> transformarALista(List<FaltaVO> lista) {
        List<Falta> result = new ArrayList<>();
        for (FaltaVO item : lista) {
            result.add(item.toModelo());
        }
        return result;
    }

    private List<FaltaVO> transformarAListaVO(List<Falta> lista) {
        List<FaltaVO> result = new ArrayList<>();
        for (Falta item : lista) {
            result.add(item.toVO());
        }
        return result;
    }


}
