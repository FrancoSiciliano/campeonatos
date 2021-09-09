package org.grupocuatro.controlador;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.List;

public class ControladorGoles {
    private static ControladorGoles instancia;

    private ControladorGoles(){}

    public static ControladorGoles getInstancia(){
        if(instancia == null)
            instancia = new ControladorGoles();
        return instancia;
    }

    public Integer cargarGol(Integer idJugador, Integer idPartido, int minuto, String tipo) {
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
        GolDao goldao = GolDao.getInstancia();
        Gol gol = null;
        gol = new Gol(jugador, partido, minuto, tipo);
        goldao.save(gol);
        return gol.getIdGol();
    }

    public int contarCantidadGoles(int idClub, int idPartido) {
        int cantGoles = 0;
        try {
            List<Gol> goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub);
            cantGoles = goles.size();
            return cantGoles;
        } catch (GolException e) {
            cantGoles = 0;
            return cantGoles;
        }
    }
}
