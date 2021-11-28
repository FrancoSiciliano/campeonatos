package org.grupocuatro.controlador;

import org.grupocuatro.dao.GolDao;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;
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

    public Integer cargarGol(Integer idJugador, Integer idPartido, int minuto, String tipo) throws JugadorException, PartidoException, GolException, MiembroException {
        ControladorJugadores controladorJugadores = ControladorJugadores.getInstancia();
        Jugador jugador = controladorJugadores.encontrarJugador(idJugador).toModelo();
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        Partido partido = controladorPartidos.encontrarPartido(idPartido).toModelo();


        Miembro miembro = ControladorMiembros.getInstancia().getMiembroByPartidoAndJugador(idPartido,idJugador).toModelo();
        if(miembro.getIngreso()<= minuto && miembro.getEgreso() >= minuto){
            Gol gol = new Gol(null, partido, minuto, tipo);
            jugador.agregarGol(gol);
            return gol.getIdGol();
        }
        throw new GolException("El jugador de id: " + idJugador + " no se encontraba en el campo en el minuto indicado (" + minuto + ")");

    }

    public int contarCantidadGoles(Integer idClub, Integer idPartido) throws PartidoException, GolException {
        Partido partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido).toModelo();
        int cantGoles;

        List<Gol> goles;

        if (Objects.equals(idClub, partido.getClubLocal().getIdClub())) {
            goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub, partido.getClubVisitante().getIdClub());

        } else {
            goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub, partido.getClubLocal().getIdClub());
        }

        cantGoles = goles.size();
        return cantGoles;
    }

    public void resetearGolesPartido(Integer idPartido){
        List<Gol> goles = null;
        try {
            goles = GolDao.getInstancia().getGolesByPartido(idPartido);
            for(Gol gol : goles ){
                gol.delete();
                gol.update();
            }
        } catch (GolException e) {
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
