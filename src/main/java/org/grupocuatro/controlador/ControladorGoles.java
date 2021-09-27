package org.grupocuatro.controlador;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.ClubVO;
import org.grupocuatro.vo.GolVO;

import java.util.ArrayList;
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

    public List<GolVO> getGoles() throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGoles());

    }

    public GolVO getGolById(Integer idGol) throws GolException {
        return GolDao.getInstancia().getGolById(idGol).toVO();

    }

    public List<GolVO> getGolesByPartido(Integer idPartido) throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGolesByPartido(idPartido));

    }

    public List<GolVO> getGolesByPartidoAndClub(Integer idPartido, Integer idClubAContar, Integer idClubRival) throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClubAContar, idClubRival));

    }

    public List<GolVO> getGolesByPartidoAndSentido(Integer idPartido, String sentido) throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGolesByPartidoAndSentido(idPartido, sentido));
    }

    public List<GolVO> getGolesByJugadorAndPartido(Integer idPartido, Integer idJugador) throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGolesByJugadorAndPartido(idPartido, idJugador));

    }

    public List<GolVO> getGolesByJugador(Integer idJugador) throws GolException {
        return transformarAListaVO(GolDao.getInstancia().getGolesByJugador(idJugador));

    }

    private List<GolVO> transformarAListaVO(List<Gol> listaGoles) {
        List<GolVO> listaGolesVo = new ArrayList<>();
        for (Gol gol : listaGoles) {
            listaGolesVo.add(gol.toVO());
        }
        return listaGolesVo;
    }
}
