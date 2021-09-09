package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.modelo.TablaPosiciones;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.stream.Stream;

public class ControladorPartidos {
    private static ControladorPartidos instancia;

    private ControladorPartidos() {
    }

    public static ControladorPartidos getInstancia() {
        if (instancia == null)
            instancia = new ControladorPartidos();
        return instancia;
    }

    //FIXME actualizar tabla de goles, faltas y tabla posicion

    public Integer crearPartido(int nroFecha, int nroZona, int categoria, Integer idClubLocal, Integer idClubVisitante, LocalDate fecha, Integer idCampeonato) {
        ControladorCampeonatos cc = ControladorCampeonatos.getInstancia();
        ControladorPartidos cp = ControladorPartidos.getInstancia();
        ControladorClubes cclubes = ControladorClubes.getInstancia();

        Campeonato c = cc.encontrarCampeonato(idCampeonato);
        Club local = cclubes.getClubById(idClubLocal);
        Club visitante = cclubes.getClubById(idClubVisitante);

        Partido p = null;

        if (c != null && local != null && visitante != null) {
            p = new Partido(nroFecha, nroZona, categoria, local, visitante, fecha, c);
            p.save();
        }

        return (p == null) ? p.getIdPartido() : null;

    }

    public Partido encontrarPartido(Integer idPartido) {
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try {
            partido = partidodao.getInstancia().getPartidoById(idPartido);
            return partido;
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void cargarResultadoPartido(int idPartido) { //FIXME pensar como manejar las faltas en la carga de rdos
        try {
            ControladorGoles cont = ControladorGoles.getInstancia();
            ControladorFaltas controladorFaltas = ControladorFaltas.getInstancia();
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);

            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = cont.contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = cont.contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validadoPorClubLocal(Integer idClubL, Integer idPartido) {
        try {
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if (idClubL == partido.getClubLocal().getIdClub()) {
                partido.setConvalidaLocal();
                partido.update();
            } else {
                System.out.println("El club ingresado no corresponde al club local");
            }

            modificarTablaPosiciones(partido);

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void validadoPorClubVisitante(Integer idClubV, Integer idPartido) {
        try {
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if (idClubV == partido.getClubVisitante().getIdClub()) {
                partido.setConvalidaVisitante();
                partido.update();
            } else {
                System.out.println("El club ingresado no corresponde al club visitante");
            }

            modificarTablaPosiciones(partido);

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarTablaPosiciones(Partido partido) {

        if (chequearValidacion(partido)){
            if (partido.isEmpate()) {
                actualizarTablaPosiciones(partido.getClubLocal().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesLocal(), partido.getGolesVisitante());
                actualizarTablaPosiciones(partido.getClubVisitante().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesVisitante(), partido.getGolesLocal());
            } else {
                actualizarTablaPosiciones(partido.getGanador().getIdClub(), partido.getCampeonato().getIdCampeonato(), 3, partido.getGolesGanador(), partido.getGolesPerdedor());
                actualizarTablaPosiciones(partido.getPerdedor().getIdClub(), partido.getCampeonato().getIdCampeonato(), 0, partido.getGolesPerdedor(), partido.getGolesGanador());
            }
        }
    }

    private boolean chequearValidacion(Partido partido) {
        return  partido.isValidado();
    }

    public void actualizarTablaPosiciones(Integer idClub, Integer idCampeonato, int puntos, int golesContra, int golesFavor) {
        TablaPosiciones tp = null;
        try {
            tp = TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
            //TODO aca habría que crear la tabla posiciones
            return;
        }

        switch (puntos) {
            case 0:
                tp.setCantidadPerdidos(tp.getCantidadPerdidos() + 1);
                break;
            case 1:
                tp.setCantidadEmpatados(tp.getCantidadEmpatados() + 1);
                break;
            case 3:
                tp.setCantidadGanados(tp.getCantidadGanados() + 1);
                break;
            default:
                tp.setPuntos(tp.getPuntos() + puntos);
        }

        int difGoles = golesFavor - golesContra;
        tp.setDiferenciaGoles(tp.getDiferenciaGoles() + difGoles);
        tp.setGolesFavor(tp.getGolesFavor() + golesFavor);
        tp.setGolesContra(tp.getGolesContra() + golesContra);
        //TODO  promedio???

    }
    //TODO hacer gets


}
