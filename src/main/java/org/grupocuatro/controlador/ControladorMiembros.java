package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;

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
        FIXME
        CONTROLES:
        - Categoria: Que no participen en categorías menor que poseen (categoria >= categoriaPartido)
        - Partidos: Que no jueguen más de un partido en el mismo día.
        - Cantidad: 17 Jugadores por partido.
        - Habilitación: Que no haya sido expulsado en el partido anterior en el mismo torneo (en otro si).
        - Campeonato: No poder participar en campeonatos ya arrancados.
         */
    }

    private boolean habilitado(Jugador jugador, Integer idMiembro) {
        MiembroDao Miembrodao = MiembroDao.getInstancia();
        PartidoDao partidoDao = PartidoDao.getInstancia();
        List<Partido> lista_partido_nroFecha = null;
        ControladorFaltas controlador = ControladorFaltas.getInstancia();
        try {
            Integer idjugador = jugador.getIdJugador();
            Miembro miembro = Miembrodao.getMiembroById(idMiembro);
            Club club = miembro.getClub();
            Integer idclub = club.getIdClub();
            Partido partido = miembro.getPartido();
            int nro_fecha_anterior = partido.getNroFecha() - 1;
            Campeonato campeonato = partido.getCampeonato();
            Integer idCampeonato = campeonato.getIdCampeonato();
            List<Partido> lista_partido = partidoDao.getPartidosByCampeonato(idCampeonato);//partidosDelCampeonato
            for (int pos = 0; pos < lista_partido.size(); pos++) {
                int nro_fecha = lista_partido.get(pos).getNroFecha();
                if (nro_fecha == nro_fecha_anterior) {
                    Integer idclub_local = lista_partido.get(pos).getClubLocal().getIdClub();
                    Integer idclub_visitante = lista_partido.get(pos).getClubVisitante().getIdClub();
                    if (idclub_local == idclub || idclub_visitante == idclub)
                        lista_partido_nroFecha.add(lista_partido.get(pos));//partidosDelCampeonato en fecha y club
                }
            }
            int roja = 0;
            for (int pos = 0; pos < lista_partido_nroFecha.size(); pos++) {
                Integer idPartido = lista_partido_nroFecha.get(pos).getIdPartido();
                roja = roja + controlador.falta_de_expulsion(idjugador, idPartido, idCampeonato);
            }
            if (roja == 0) {
                return false;
            }
            return true;
        } catch (MiembroException | PartidoException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean categoria_valida(Jugador jugador, Integer idMiembro) {
        MiembroDao dao = MiembroDao.getInstancia();
        try {
            Miembro miembro = dao.getMiembroById(idMiembro);
            Partido partido = miembro.getPartido();
            int categoria_partido = partido.getCategoria();
            int categoria_jugador = jugador.getCategoria();
            if (categoria_jugador <= categoria_partido) {
                return true;
            } else {
                return false;
            }
        } catch (MiembroException e) {
            e.printStackTrace();
            return false;
        }

    }
}
