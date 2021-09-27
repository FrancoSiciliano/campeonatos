package org.grupocuatro.controlador;

import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;
import org.grupocuatro.vo.MiembroVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorMiembros {

    private static ControladorMiembros instancia;

    private ControladorMiembros() {
    }

    public static ControladorMiembros getInstancia() {
        if (instancia == null)
            instancia = new ControladorMiembros();
        return instancia;
    }

    public void agregarJugadoresEnLista(Integer idClub, Integer idPartido, Integer idJugador) throws PartidoException, JugadorException, ClubException, FaltaException {
        /*
        CONTROLES:
        - Categoria: Que no participen en categorías menor que poseen (categoria >= categoriaPartido)
        - Partidos: Que no jueguen más de un partido en el mismo día.
        - Cantidad: 17 Jugadores por partido.
        - Habilitación: Que no haya sido expulsado en el partido anterior en el mismo torneo (en otro si).
        - Campeonato: No poder participar en campeonatos ya arrancados.
         */

        Club club = ControladorClubes.getInstancia().getClubById(idClub).toModelo();
        Partido partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido).toModelo();
        Jugador jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador).toModelo();

        Miembro miembro = new Miembro(club, partido);

        if (club != null && jugador != null && partido != null &&
                perteneceAlEquipo(miembro.getClub().getIdClub(), jugador) &&
                puedeJugarPorCategoria(partido, jugador) &&
                puedeJugarPorDia(partido, jugador) &&
                hayLugarEnElEquipo(jugador.getClub().getIdClub(), partido.getIdPartido()) &&
                !elCampeonatoComenzo(partido.getCampeonato(), jugador) &&
                estaHabilitadoParaJugar(partido, jugador)) {

            miembro.setJugador(jugador);
            miembro.save();

        } else {
            System.out.println("El jugador no puede ser inscripto en el partido");
        }

    }

    public void definirIngresoEgreso(Integer idMiembro, int ingreso, int egreso) {
        try {
            Miembro m = MiembroDao.getInstancia().getMiembroById(idMiembro);
            if (ingreso < egreso) {
                m.setIngreso(ingreso);
                m.setEgreso(egreso);
                m.update();
            } else {
                throw new MiembroException("El minuto de ingreso no puede ser mayor o igual al de egreso");
            }
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<MiembroVO> getMiembros() throws MiembroException {
        return transformarAListaVO(MiembroDao.getInstancia().getMiembros());

    }

    public MiembroVO getMiembroById(Integer idMiembro) throws MiembroException {
        return MiembroDao.getInstancia().getMiembroById(idMiembro).toVO();

    }

    public List<MiembroVO> getMiembrosByClub(Integer idClub) throws MiembroException {
        return transformarAListaVO(MiembroDao.getInstancia().getMiembrosByClub(idClub));

    }

    public List<MiembroVO> getMiembrosByClubAndPartido(Integer idClub, Integer idPartido) throws MiembroException {
        return transformarAListaVO(MiembroDao.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido));

    }

    public MiembroVO getMiembroByPartidoAndJugador(Integer idPartido, Integer idJugador) throws MiembroException {
        return MiembroDao.getInstancia().getMiembroByPartidoAndJugador(idPartido, idJugador).toVO();

    }

    public MiembroVO getMiembroByClubAndPartidoAndJugador(Integer idClub, Integer idPartido, Integer idJugador) throws MiembroException {
        return MiembroDao.getInstancia().getMiembroByClubAndPartidoAndJugador(idClub, idPartido, idJugador).toVO();
    }

    public List<MiembroVO> getMiembroByJugadorAndFecha(Integer idJugador, LocalDate fecha) throws MiembroException {
        return transformarAListaVO(MiembroDao.getInstancia().getMiembroByJugadorAndFecha(idJugador, fecha));

    }

    private boolean perteneceAlEquipo(Integer idClub, Jugador jugador) {
        return jugador.isSuClub(idClub);
    }

    private boolean puedeJugarPorCategoria(Partido partido, Jugador jugador) {
        int categoriaPartido = partido.getCategoria();
        int categoriaJugador = jugador.getCategoria();

        return categoriaPartido <= categoriaJugador;
    }

    private boolean puedeJugarPorDia(Partido partido, Jugador jugador) {
        LocalDate fechaPartido = partido.getFechaPartido();
        try {
            MiembroDao.getInstancia().getMiembroByJugadorAndFecha(jugador.getIdJugador(), fechaPartido);
            return false;
        } catch (MiembroException e) {
            return true;
        }
    }

    private boolean hayLugarEnElEquipo(Integer idClub, Integer idPartido) {
        try {
            return MiembroDao.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido).size() < 17;
        } catch (MiembroException e) {
            return true;
        }
    }

    private boolean elCampeonatoComenzo(Campeonato campeonato, Jugador jugador) {
        return !campeonato.getFechaInicio().isAfter(jugador.getFechaAlta());
    }

    private boolean estaHabilitadoParaJugar(Partido partido, Jugador jugador) throws PartidoException, FaltaException {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int nroFecha = partido.getNroFecha();
        Campeonato campeonato = partido.getCampeonato();

        if (jugador.isEstado()) {
            Partido ultimoPartido = controladorPartidos.getUltimoPartidoByClubAndCampeonato(jugador.getClub().getIdClub(), campeonato.getIdCampeonato(), nroFecha).toModelo();
            List<Falta> faltas = ControladorFaltas.getInstancia().transformarALista(ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador.getIdJugador(), "roja", ultimoPartido.getIdPartido())) ;
            return faltas.isEmpty();
        }
        return false;
    }

    private List<MiembroVO> transformarAListaVO(List<Miembro> lista) {
        List<MiembroVO> result = new ArrayList<>();
        for (Miembro item : lista) {
            result.add(item.toVO());
        }
        return result;
    }


}
