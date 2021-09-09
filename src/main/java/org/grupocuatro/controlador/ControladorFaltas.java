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

    private Jugador encontrar_jugador(int idJugador){//tiene q estar en el controlador y no aca
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador = null;
        try{
            jugador = jugadordao.getJugadorById(idJugador);
            return jugador;
        }catch (JugadorException e){
            return null;
        }
    }
    private Partido encontrar_partido(int idPartido){//tiene q estar en el controlador y no aca
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try{
            partido = partidodao.getInstancia().getPartidoById(idPartido);
            return partido;
        } catch (PartidoException e) {
            e.printStackTrace();
            return null;
        }
    }
    private  Campeonato encontrar_campeonato(int idCampeonato){//tiene q estar en el controlador y no aca
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato = null;
        try{
            campeonato = campeonatoDao.getCampeonato(idCampeonato);
            return campeonato;
        } catch (CampeonatoException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Integer cargarFalta(int idJugador, int idPartido, int idCampeonato, int minuto, String tipo) {
        Jugador jugador = encontrar_jugador(idJugador);
        Partido partido = encontrar_partido(idPartido);
        Campeonato campeonato=encontrar_campeonato(idCampeonato);
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

    public Integer cargarFaltapete(int idJugador, int idPartido, int idCampeonato, int minuto, String tipo) {
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador = null;
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato = null;
        try {
            jugador = jugadordao.getJugadorById(idJugador);
            partido = partidodao.getInstancia().getPartidoById(idPartido);
            campeonato = campeonatoDao.getCampeonato(idCampeonato);
        } catch (CampeonatoException | JugadorException | PartidoException e) {
            e.printStackTrace();
            FaltaDao faltadao = FaltaDao.getInstancia();
            Falta falta = null;
            falta = new Falta(jugador, partido, campeonato, minuto, tipo);
            faltadao.save(falta);
            try {//si se agrega automaticamente la roja a las 2 faltas va,si es manual entonces no
                List<Falta> lista_falta;
                lista_falta = faltadao.getFaltasByJugadorAndPartidoAndTipoAndCampeonato(idJugador, idPartido, "Amarilla", idCampeonato);
                int cantidad = lista_falta.size();
                if (cantidad == 2) {
                    falta = new Falta(jugador, partido, campeonato, minuto, "Roja");
                    faltadao.save(falta);
                    return falta.getIdFalta();
                }
                return falta.getIdFalta();
            } catch (FaltaException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
