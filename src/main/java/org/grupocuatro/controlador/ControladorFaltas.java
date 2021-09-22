package org.grupocuatro.controlador;

import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.excepciones.FaltaException;
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

    public Integer cargarFalta(Integer idJugador, Integer idPartido, Integer minuto, String tipo) {
        Jugador jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador);
        Partido partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido);

        if (jugador != null && partido != null) {
            FaltaDao faltadao = FaltaDao.getInstancia();
            Falta falta = null;
            falta = new Falta(jugador, partido, minuto, tipo);
            faltadao.save(falta);

            if (!tipo.equals("roja")) {
                try {
                    if (correspondeRoja(idJugador, idPartido)) {
                        falta = new Falta(jugador, partido, minuto, "roja");
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

    private boolean correspondeRoja(Integer idJugador, Integer idPartido) throws FaltaException {
        List<Falta> listaFaltas = FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "amarilla", idPartido);
        return listaFaltas.size() == 2;
    }

    public List<Falta> getFaltas() {
        try {
            return FaltaDao.getInstancia().getFaltas();
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Falta getFaltaById(Integer id) {
        try {
            return FaltaDao.getInstancia().getFaltaById(id);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
            return FaltaDao.getInstancia().getFaltasByJugadorAndPartido(idJugador, idPartido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByJugadorAndTipoAndPartido(Integer jugador, String tipo, Integer partido) {
        try {
            return FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador,tipo, partido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByJugadorAndCampeonato(Integer jugador, Integer campeonato) {
        try {
            return FaltaDao.getInstancia().getFaltasByJugadorAndCampeonato(jugador, campeonato);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<Falta> getFaltasByJugadorAndPartidoAndTipo(Integer jugador, Integer partido, String tipo) {
        try {
            return FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador, tipo, partido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByJugador(Integer idJugador) {
        try {
            return FaltaDao.getInstancia().getFaltasByJugador(idJugador);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Falta> getFaltasByTipo(String tipo) {
        try {
            return FaltaDao.getInstancia().getFaltasByTipo(tipo);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
