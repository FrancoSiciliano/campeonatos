package org.grupocuatro.controlador;

import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.List;

public class ControladorFaltas {
    private static ControladorFaltas instancia;

    private ControladorFaltas() {
    }

    public static ControladorFaltas getInstancia() {
        if (instancia == null)
            instancia = new ControladorFaltas();
        return instancia;
    }


    public Integer cargarFalta(Integer idJugador, Integer idPartido, Integer idCampeonato, Integer minuto, String tipo) {
        Jugador jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador);
        Partido partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido);
        Campeonato campeonato = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato);

        if (jugador != null && partido != null && campeonato != null) {
            FaltaDao faltadao = FaltaDao.getInstancia();
            Falta falta = null;
            falta = new Falta(jugador, partido, campeonato, minuto, tipo);
            faltadao.save(falta);

            if (tipo != "rojo") {
                try {
                    if (correspondeRoja(idJugador, idPartido, idCampeonato)) {
                        falta = new Falta(jugador, partido, campeonato, minuto, "roja");
                        faltadao.save(falta);
                        return falta.getIdFalta();
                    }
                    return falta.getIdFalta();
                } catch (FaltaException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                return falta.getIdFalta();
            }
        }
        return null;
    }

    private boolean correspondeRoja(Integer idJugador, Integer idPartido, Integer idCampeonato) throws FaltaException {
        List<Falta> listaFaltas = FaltaDao.getInstancia().getFaltasByJugadorAndPartidoAndTipoAndCampeonato(idJugador, idPartido, "amarilla", idCampeonato);
        return listaFaltas.size() == 2;
    }


    public List<Falta> getFaltasPartido(Integer idPartido) {
        try {
            return FaltaDao.getInstancia().getFaltasByPartido(idPartido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByTipoAndPartido(Integer idPartido, String tipo) {
        try {
            return FaltaDao.getInstancia().getFaltasByPartidoAndTipo(idPartido, tipo);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByCampeonato(Integer idCampeonato) {
        try {
            return FaltaDao.getInstancia().getFaltasByCampeonato(idCampeonato);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByJugadorAndPartido(Integer idJugador, Integer idPartido) {
        try {
            return FaltaDao.getInstancia().getFaltasByJugadorAndPartido(idJugador,idPartido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
