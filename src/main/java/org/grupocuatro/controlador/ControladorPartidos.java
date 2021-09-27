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
import org.grupocuatro.vo.PartidoVO;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    // SE SACÓ EL NROFECHA Y LA FECHA COMO PARÁMETROS, YA QUE SE ASIGNAN A POSTERIORI DE LA CREACIÓN DE LOS PARTIDOS

    public Integer crearPartido(int nroZona, int categoria, Integer idClubLocal, Integer idClubVisitante, Integer idCampeonato) throws PartidoException, CampeonatoException, ClubException {

        ControladorCampeonatos cc = ControladorCampeonatos.getInstancia();
        ControladorPartidos cp = ControladorPartidos.getInstancia();
        ControladorClubes clubes = ControladorClubes.getInstancia();

        Campeonato c = cc.encontrarCampeonato(idCampeonato).toModelo();
        Club local = clubes.getClubById(idClubLocal).toModelo();
        Club visitante = clubes.getClubById(idClubVisitante).toModelo();

        Partido p;
        if (PartidoDao.getInstancia().existePartido(nroZona, categoria, idClubLocal, idClubVisitante, idCampeonato)) {
            p = new Partido(nroZona, categoria, local, visitante, c);
            p.save();

        } else {
            throw new PartidoException("Ya existe el partido que se esta intentando crear. Sugerencia: Si debe jugarse el mismo partido, cambiar el nroZona a uno no existente");
        }

        return p.getIdPartido();

    }

    //SE ASUME QUE UNA FECHA NO DURA MAS DE UN DIA, ES DECIR QUE 1 FECHA = 1 DIA
    public void cargarNroFechaYFecha(Integer idPartido, int nroFecha, LocalDate fecha) throws PartidoException {
        Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);

        if (ControladorCampeonatos.getInstancia().estaEnLaFecha(p.getCampeonato(), fecha) && p.getNroFecha() == 0 && p.getFechaPartido() == null) {
            List<Partido> partidosLocal = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(p.getClubLocal().getIdClub(), p.getCampeonato().getIdCampeonato());
            List<Partido> partidosVisitante = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(p.getClubVisitante().getIdClub(), p.getCampeonato().getIdCampeonato());


            for (Partido pp : partidosLocal) {
                if (pp.getNroFecha() == nroFecha) {
                    throw new PartidoException("El club: " + pp.getClubLocal().getIdClub() + " ya juega en la fecha: " + nroFecha);
                }
            }

            for (Partido pp : partidosVisitante) {
                if (pp.getNroFecha() == nroFecha) {
                    throw new PartidoException("El club: " + pp.getClubVisitante().getIdClub() + " ya juega en la fecha: " + nroFecha);
                }
            }

            p.setNroFecha(nroFecha);
            p.setFechaPartido(fecha);
            p.update();

        } else {

            if (p.getNroFecha() != 0)
                throw new PartidoException("El partido: " + nroFecha + " ya posee una fecha");
            else
                throw new PartidoException("La fecha: " + nroFecha + " no esta comprendida entre las fechas del torneo");
        }


    }

    public void cargarResultadoPartido(Integer idPartido, String incidentes) throws PartidoException {
        ControladorGoles cont = ControladorGoles.getInstancia();
        Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);

        int clubLocal = p.getClubLocal().getIdClub();
        int clubVisitante = p.getClubVisitante().getIdClub();
        int cantGolesLocal = cont.contarCantidadGoles(clubLocal, idPartido);
        int cantGolesVisitante = cont.contarCantidadGoles(clubVisitante, idPartido);

        p.setGolesLocal(cantGolesLocal);
        p.setGolesVisitante(cantGolesVisitante);
        p.setIncidentes(incidentes);
        p.update();
    }

    public void validadoPorClubLocal(Integer idClubL, Integer idPartido) throws PartidoException, CampeonatoException, ClubException {
        Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);

        if (Objects.equals(idClubL, partido.getClubLocal().getIdClub())) {
            partido.setConvalidaLocal();
            partido.update();
            cargarResultadoEnTabla(partido);

        } else {
            throw new PartidoException("El club: " + idClubL + " no es el club local en el partido: " + idPartido);
        }
    }

    public void validadoPorClubVisitante(Integer idClubV, Integer idPartido) throws PartidoException, CampeonatoException, ClubException {
        Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);

        if (Objects.equals(idClubV, partido.getClubVisitante().getIdClub())) {
            partido.setConvalidaVisitante();
            partido.update();
            cargarResultadoEnTabla(partido);

        } else {
            throw new PartidoException("El club: " + idClubV + " no es el club local en el partido: " + idPartido);
        }

    }

    private void cargarResultadoEnTabla(Partido partido) throws CampeonatoException, ClubException {
        ControladorTablasPosiciones controladorTablasPosiciones = ControladorTablasPosiciones.getInstancia();

        if (chequearValidacion(partido)) {
            if (partido.isEmpate()) {
                controladorTablasPosiciones.actualizarTablaPosiciones(partido.getClubLocal().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesLocal(), partido.getGolesVisitante());
                controladorTablasPosiciones.actualizarTablaPosiciones(partido.getClubVisitante().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesVisitante(), partido.getGolesLocal());
            } else {
                controladorTablasPosiciones.actualizarTablaPosiciones(partido.getGanador().getIdClub(), partido.getCampeonato().getIdCampeonato(), 3, partido.getGolesGanador(), partido.getGolesPerdedor());
                controladorTablasPosiciones.actualizarTablaPosiciones(partido.getPerdedor().getIdClub(), partido.getCampeonato().getIdCampeonato(), 0, partido.getGolesPerdedor(), partido.getGolesGanador());
            }
        }
    }

    private boolean chequearValidacion(Partido partido) {
        return partido.isValidado();
    }

    public List<PartidoVO> getAllPartidos() throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getAllPartidos());
    }

    public PartidoVO encontrarPartido(Integer idPartido) throws PartidoException {
        return PartidoDao.getInstancia().getPartidoById(idPartido).toVO();
    }

    public List<PartidoVO> getPartidosByCampeonato(Integer idCampeonato) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByCampeonato(idCampeonato));
    }

    public List<PartidoVO> getPartidosByCategoria(int categoria) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByCategoria(categoria));
    }

    public PartidoVO getUltimoPartidoByClubAndCampeonato(Integer idClub, Integer idCampeonato, int nroFechaActual) throws PartidoException {
        return PartidoDao.getInstancia().getUltimoPartidoByClubAndCampeonato(idClub, idCampeonato, nroFechaActual).toVO();
    }

    public List<PartidoVO> getPartidosByNroFechaAndCampeonato(Integer idCampeonato, int nroFecha) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonato(idCampeonato, nroFecha));
    }

    public List<PartidoVO> getPartidosByNroZona(int NroZona) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByNroZona(NroZona));
    }

    public List<PartidoVO> getPartidosByClubLocal(int idClub) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByClubLocal(idClub));
    }

    public List<PartidoVO> getPartidosByClubVisitante(int idClub) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByClubVisitante(idClub));
    }

    public List<PartidoVO> getPartidosByNroFechaAndCampeonatoAndClub(Integer idCampeonato, int nroFecha, Integer idClub) throws PartidoException {
        return transformarAListaVO(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(idCampeonato, nroFecha, idClub));
    }

    private List<PartidoVO> transformarAListaVO(List<Partido> listaModelo) {
        List<PartidoVO> listaVO = new ArrayList<>();
        for (Partido p : listaModelo)
            listaVO.add(p.toVO());
        return listaVO;
    }


}
