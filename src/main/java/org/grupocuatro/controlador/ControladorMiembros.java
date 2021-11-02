package org.grupocuatro.controlador;

import org.grupocuatro.dao.ListadoJugadoresDeshabilitadosDao;
import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;
import org.grupocuatro.vo.FaltaVO;
import org.grupocuatro.vo.MiembroVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorMiembros {

    private static ControladorMiembros instancia;

    private ControladorMiembros() {
    }

    public static ControladorMiembros getInstancia() {
        if (instancia == null)
            instancia = new ControladorMiembros();
        return instancia;
    }

    public void agregarJugadorEnLista(Integer idClub, Integer idPartido, Integer idJugador) throws PartidoException, JugadorException, MiembroException, FaltaException, ClubException {
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

        if (perteneceAlEquipo(miembro.getClub().getIdClub(), jugador, partido) &&
                puedeJugarPorCategoria(partido, jugador) &&
                puedeJugarPorDia(partido, jugador) &&
                hayLugarEnElEquipo(jugador.getClub().getIdClub(), partido.getIdPartido()) &&
                elCampeonatoNoComenzo(partido.getCampeonato(), jugador) &&
                estaHabilitadoParaJugar(partido, jugador)) {

            if (partido.isClubLocal(club))
                club.agregarJugadoresToListaLocal(jugador, partido);
            else
                club.agregarJugadoresToListaVisitante(jugador, partido);

        }
    }

    public void definirIngresoEgreso(Integer idMiembro, int ingreso, int egreso) throws MiembroException {
        Miembro m = MiembroDao.getInstancia().getMiembroById(idMiembro);
        if (ingreso < egreso) {
            m.setIngreso(ingreso);
            m.setEgreso(egreso);
            m.update();
        } else {
            throw new MiembroException("El minuto de ingreso no puede ser mayor o igual al de egreso");
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

    private boolean perteneceAlEquipo(Integer idClub, Jugador jugador, Partido partido) throws MiembroException {
        if (jugador.isSuClub(idClub) && (Objects.equals(idClub, partido.getClubLocal().getIdClub()) || Objects.equals(idClub, partido.getClubVisitante().getIdClub())))
            return true;
        else {
            if (jugador.isSuClub(idClub))
                throw new MiembroException("El club: " + idClub + " no juega el partido: " + partido.getIdPartido());
            else
                throw new MiembroException("El jugador: " + idClub + " no peretenece al club: " + idClub);
        }
    }

    private boolean puedeJugarPorCategoria(Partido partido, Jugador jugador) throws MiembroException {
        int categoriaPartido = partido.getCategoria();
        int categoriaJugador = jugador.getCategoria();
        if (categoriaPartido <= categoriaJugador) {
            return true;
        } else {
            throw new MiembroException("No se puede registrar al jugador ya que su categoria (" + categoriaJugador + ") es menor a la del partido (" + categoriaPartido + ")");
        }
    }

    private boolean puedeJugarPorDia(Partido partido, Jugador jugador) throws MiembroException {
        LocalDate fechaPartido = partido.getFechaPartido();
        List<Miembro> miembro = MiembroDao.getInstancia().getMiembroByJugadorAndFecha(jugador.getIdJugador(), fechaPartido);
        if (miembro.isEmpty())
            return true;
        else
            throw new MiembroException("El jugador no puede registrarse ya que juega otro partido el mismo dia");
    }

    private boolean hayLugarEnElEquipo(Integer idClub, Integer idPartido) throws MiembroException {
        if (MiembroDao.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido).size() < 17)
            return true;
        else
            throw new MiembroException("El equipo ya cuenta con 17 jugadores, el nuevo jugador no puede ser registrado");

    }

    private boolean elCampeonatoNoComenzo(Campeonato campeonato, Jugador jugador) throws MiembroException {
        if (campeonato.getFechaInicio().isAfter(jugador.getFechaAlta()))
            return true;
        else
            throw new MiembroException("El jugador no puede registrarse ya que fue inscripto en una fecha posterior a la creación del torneo");
    }

    private boolean estaHabilitadoParaJugar(Partido partido, Jugador jugador) throws MiembroException {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int nroFecha = partido.getNroFecha();
        Campeonato campeonato = partido.getCampeonato();
        ListadoJugadoresDeshabilitadosDao listadoDeshabilitados = ListadoJugadoresDeshabilitadosDao.getInstancia();
        if (jugador.isEstado() && !listadoDeshabilitados.isJugadorDeshabilitado(jugador.getIdJugador(), campeonato.getIdCampeonato())) {
            try {
                Partido ultimoPartido = controladorPartidos.getUltimoPartidoByClubAndCampeonato(jugador.getClub().getIdClub(), campeonato.getIdCampeonato(), nroFecha).toModelo();
                List<Falta> faltas = transformarAListaModelo(ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador.getIdJugador(), "roja", ultimoPartido.getIdPartido()));
            } catch (PartidoException | FaltaException e) {
                return true;
            }
        }
        throw new MiembroException("El miembro no se encuentra habilitado para jugar el partido");
    }

    private List<MiembroVO> transformarAListaVO(List<Miembro> listaMiembro) {
        List<MiembroVO> listaMiembroVo = new ArrayList<>();
        for (Miembro miembro : listaMiembro) {
            listaMiembroVo.add(miembro.toVO());
        }
        return listaMiembroVo;
    }

    private List<Falta> transformarAListaModelo(List<FaltaVO> lista) {
        List<Falta> result = new ArrayList<>();
        for (FaltaVO item : lista) {
            result.add(item.toModelo());
        }
        return result;
    }
}
