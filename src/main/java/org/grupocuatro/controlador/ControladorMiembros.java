package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
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

    public Integer crearListaJugadores(Club club, Partido partido) {
        MiembroDao dao = MiembroDao.getInstancia();
        Miembro m = new Miembro(club, partido);
        dao.save(m);
        return m.getIdLista();
    }

    public void agregarJugadoresEnLista(Integer idMiembro, Jugador jugador) throws MiembroException {
        /*
        FIXME FALTA IMPLEMENTAR LOS CONTROLES PARA LAS FUTURAS ENTREGAS
        CONTROLES:
        - Categoria: Que no participen en categorías menor que poseen (categoria >= categoriaPartido)
        - Partidos: Que no jueguen más de un partido en el mismo día.
        - Cantidad: 17 Jugadores por partido.
        - Habilitación: Que no haya sido expulsado en el partido anterior en el mismo torneo (en otro si).
        - Campeonato: No poder participar en campeonatos ya arrancados.
         */
        Miembro miembro = MiembroDao.getInstancia().getMiembroById(idMiembro);
        Partido partido = miembro.getPartido();
        Campeonato campeonato = partido.getCampeonato();

        if (puedeJugarPorCategoria(partido, jugador) &&
                puedeJugarPorDia(partido, jugador, campeonato.getIdCampeonato()) &&
                hayLugarEnElEquipo(jugador.getClub().getIdClub(), partido.getIdPartido()) &&
                !elCampeonatoComenzo(campeonato, jugador)) { //FIXME FALTA CHEQUEAR HABILITACION

            miembro.setJugador(jugador);
            miembro.update();

        } else {
            System.out.println("El jugador no puede ser inscripto en el partido");
        }
    }

    //TODO ver que onda el egreso/ingreso para hacer el modificar
    //TODO hacer gets de los daos

    private boolean puedeJugarPorCategoria(Partido partido, Jugador jugador) {
        int categoriaPartido = partido.getCategoria();
        int categoriaJugador = jugador.getCategoria();

        return categoriaPartido <= categoriaJugador;
    }

    private boolean puedeJugarPorDia(Partido partido, Jugador jugador, Integer idCampeonato) {
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

    //FIXME FALTA CHEQUEAR SI ESTA HABILITADO PARA JUGAR
}
