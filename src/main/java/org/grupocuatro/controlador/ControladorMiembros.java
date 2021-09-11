package org.grupocuatro.controlador;

import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
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

    public Integer crearListaJugadores(Club club, Partido partido) {
        Miembro m = new Miembro(club, partido);
        if (ControladorClubes.getInstancia().getClubes().contains(club) && ControladorPartidos.getInstancia().getAllPartidos().contains(partido))
            m.save();
        return m.getIdLista();
    }

    public void agregarJugadoresEnLista(Integer idMiembro, Jugador jugador) {
        /*
        FIXME FALTA IMPLEMENTAR LOS CONTROLES PARA LAS FUTURAS ENTREGAS
        CONTROLES:
        - Categoria: Que no participen en categorías menor que poseen (categoria >= categoriaPartido)
        - Partidos: Que no jueguen más de un partido en el mismo día.
        - Cantidad: 17 Jugadores por partido.
        - Habilitación: Que no haya sido expulsado en el partido anterior en el mismo torneo (en otro si).
        - Campeonato: No poder participar en campeonatos ya arrancados.
         */

        try {
            Miembro miembro = MiembroDao.getInstancia().getMiembroById(idMiembro);
            Partido partido = miembro.getPartido();
            Campeonato campeonato = partido.getCampeonato();

            if (    pertenecAlEquipo(miembro.getClub().getIdClub(), jugador) &&
                    puedeJugarPorCategoria(partido, jugador) &&
                    puedeJugarPorDia(partido, jugador) &&
                    hayLugarEnElEquipo(jugador.getClub().getIdClub(), partido.getIdPartido()) &&
                    !elCampeonatoComenzo(campeonato, jugador) &&
                    estaHabilitadoParaJugar(partido, jugador)) { //FIXME FALTA CHEQUEAR HABILITACION

                miembro.setJugador(jugador);
                miembro.update();

            } else {
                System.out.println("El jugador no puede ser inscripto en el partido");
            }
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO ver que onda el egreso/ingreso para hacer el modificar

    private boolean pertenecAlEquipo(Integer idClub, Jugador jugador){
        Integer clubJugador = jugador.getClub().getIdClub();
        return Objects.equals(clubJugador, idClub);
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
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean elCampeonatoComenzo(Campeonato campeonato, Jugador jugador) {
        return !campeonato.getFechaInicio().isAfter(jugador.getFechaAlta());
    }

    private boolean estaHabilitadoParaJugar(Partido partido, Jugador jugador) {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int nroFecha = partido.getNroFecha();
        Campeonato campeonato = partido.getCampeonato();

        if (jugador.isEstado()) {
            Partido ultimoPartido = controladorPartidos.getUltimoPartidoByClubAndCampeonato(jugador.getClub(), campeonato, nroFecha);
            if (ultimoPartido != null) {
                List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(jugador.getIdJugador(), "roja", ultimoPartido.getIdPartido());
                return faltas == null;
            } else {
                return true;
            }
        }
        return false;
    }

    public Miembro getMiembroById(Integer idMiembro) {
        try {
            return MiembroDao.getInstancia().getMiembroById(idMiembro);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Miembro> getMiembros() {
        try {
            return MiembroDao.getInstancia().getMiembros();
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Miembro> getMiembrosByClub(Integer idClub) {
        try {
            return MiembroDao.getInstancia().getMiembrosByClub(idClub);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Miembro> getMiembrosByClubAndPartido(Integer idClub, Integer idPartido) {
        try {
            return MiembroDao.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Miembro getMiembroByPartidoAndJugador(Integer idPartido, Integer idJugador) {
        try {
            return MiembroDao.getInstancia().getMiembroByPartidoAndJugador(idPartido, idJugador);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Miembro getMiembroByClubAndPartidoAndJugador(Integer idClub, Integer idPartido, Integer idJugador) {
        try {
            return MiembroDao.getInstancia().getMiembroByClubAndPartidoAndJugador(idClub, idPartido, idJugador);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Miembro> getMiembroByJugadorAndFecha(Integer idJugador, LocalDate fecha) {
        try {
            return MiembroDao.getInstancia().getMiembroByJugadorAndFecha(idJugador, fecha);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
