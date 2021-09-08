package org.grupocuatro.controlador;

import org.grupocuatro.dao.MiembroDao;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

public class ControladorMiembros {

    public Integer crearListaJugadores(Club club, Partido partido) {
        MiembroDao dao = MiembroDao.getInstancia();
        Miembro m = new Miembro(club, partido);
        dao.save(m);
        return m.getIdLista();
    }
    public void agregarJugadoresEnLista(int idMiembro, Jugador jugador) throws MiembroException {
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
}
