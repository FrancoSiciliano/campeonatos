package org.grupocuatro.controlador;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.List;
import java.util.Objects;

public class ControladorGoles {
    private static ControladorGoles instancia;

    private ControladorGoles() {
    }

    public static ControladorGoles getInstancia() {
        if (instancia == null)
            instancia = new ControladorGoles();
        return instancia;
    }

    public Integer cargarGol(Integer idJugador, Integer idPartido, int minuto, String tipo) {

        ControladorJugadores controladorJugadores = ControladorJugadores.getInstancia();
        Jugador jugador = controladorJugadores.encontrarJugador(idJugador);

        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        Partido partido = controladorPartidos.encontrarPartido(idPartido);

        Gol gol = null;

        if (jugador != null && partido != null) {
            gol = new Gol(jugador, partido, minuto, tipo);
            gol.save();
        }

        return (gol != null) ? gol.getIdGol() : null;
    }

    public int contarCantidadGoles(Integer idClub, Integer idPartido) {

        Partido p = ControladorPartidos.getInstancia().encontrarPartido(idPartido);

        int cantGoles = 0;

        if (p != null) {
            try {
                List<Gol> goles;

                if (Objects.equals(idClub, p.getClubLocal().getIdClub())) {
                    goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub, p.getClubVisitante().getIdClub());
                } else {
                    goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub, p.getClubLocal().getIdClub());
                }

                cantGoles = goles.size();
                return cantGoles;

            } catch (GolException e) {
                return cantGoles;
            }
        } else {
            System.out.println("No existe el partido indicado");
            return 0;
        }
    }

    public List<Gol> getGoles() {
        try {
            return GolDao.getInstancia().getGoles();
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Gol getGolById(Integer idGol) {
        try {
            return GolDao.getInstancia().getGolById(idGol);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Gol> getGolesByPartido(Integer idPartido) {
        try {
            return GolDao.getInstancia().getGolesByPartido(idPartido);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Gol> getGolesByPartidoAndClub(Integer idPartido, Integer idClubAContar, Integer idClubRival) {
        try {
            return GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClubAContar, idClubRival);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Gol> getGolesByPartidoAndSentido(Integer idPartido, String sentido) {
        try {
            return GolDao.getInstancia().getGolesByPartidoAndSentido(idPartido, sentido);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Gol> getGolesByJugadorAndPartido(Integer idPartido, Integer idJugador) {
        try {
            return GolDao.getInstancia().getGolesByJugadorAndPartido(idPartido, idJugador);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Gol> getGolesByJugador(Integer idJugador) {
        try {
            return GolDao.getInstancia().getGolesByJugador(idJugador);
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
