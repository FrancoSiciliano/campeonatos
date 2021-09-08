package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.List;

public class ControladorFaltas {

    public Integer cargarFalta(Integer idJugador, Integer idPartido, Integer idCameponato, int minuto, String tipo) {
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador = null;
        try {
            jugador = jugadordao.getJugadorById(idJugador);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try {
            partido = partidodao.getInstancia().getPartidoById(idPartido);
        } catch (PartidoException e) {
            e.printStackTrace();
        }
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato = null;
        try {
            campeonato = campeonatoDao.getCampeonato(idCameponato);

        } catch (CampeonatoException e) {
            e.printStackTrace();
        }
        FaltaDao faltadao = FaltaDao.getInstancia();
        Falta falta = null;
        falta = new Falta(jugador, partido, campeonato, minuto, tipo);
        faltadao.save(falta);
        List<Falta> lista_falta = null;
        try {
            lista_falta = faltadao.getFaltasByJugadorAndPartido(idJugador, idPartido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        int cantidad = lista_falta.size();
        if (cantidad == 2) {
            falta = new Falta(jugador, partido, campeonato, minuto, "Roja");
            faltadao.save(falta);
        }
        return falta.getIdFalta();
    }
}
