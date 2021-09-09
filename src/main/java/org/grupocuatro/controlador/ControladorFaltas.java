package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.FaltaDao;
import org.grupocuatro.dao.JugadorDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.modelo.Partido;

import java.util.List;

public class ControladorFaltas {
    private static ControladorFaltas instancia;
    private ControladorFaltas() {
    }

    public static ControladorFaltas getInstancia() {
        if (instancia == null)
            instancia = new ControladorFaltas();
        return instancia;
    }

    public Integer cargarFalta(int idJugador, int idPartido, int idCampeonato, int minuto, String tipo) {
        Jugador jugador = ControladorJugadores.getInstancia().encontrar_jugador(idJugador);
        Partido partido = ControladorPartidos.getInstancia().encontrar_partido(idPartido);
        Campeonato campeonato= ControladorCampeonatos.getInstancia().encontrar_campeonato(idCampeonato);
        if(jugador!=null && partido!= null && campeonato!=null){
            FaltaDao faltadao = FaltaDao.getInstancia();
            Falta falta = null;
            falta = new Falta(jugador, partido, campeonato, minuto, tipo);
            faltadao.save(falta);
            try{
                List<Falta> lista_faltas;
                lista_faltas = faltadao.getFaltasByJugadorAndPartidoAndTipoAndCampeonato(idJugador, idPartido, "Amarilla", idCampeonato);
                int cantidad = lista_faltas.size();
                if (cantidad == 2) {
                    falta = new Falta(jugador, partido, campeonato, minuto, "Roja");
                    faltadao.save(falta);
                    return falta.getIdFalta();
                }
                return falta.getIdFalta();
            } catch (FaltaException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
