package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;
import org.grupocuatro.strategy.*;
import org.grupocuatro.vo.CampeonatoVO;
import org.grupocuatro.vo.ClubVO;


import java.time.LocalDate;
import java.util.*;

public class ControladorCampeonatos {
    private static ControladorCampeonatos instancia;

    private ControladorCampeonatos() {
    }

    public static ControladorCampeonatos getInstancia() {
        if (instancia == null)
            instancia = new ControladorCampeonatos();
        return instancia;
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) throws CampeonatoException {
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, estado);

        if (CampeonatoDao.getInstancia().existeCampeonato(descripcion, fechaInicio, fechaFin, estado))
            throw new CampeonatoException("Ya existe el campeonato que se está intentando crear");
        else
            nuevoCampeonato.save();

        return nuevoCampeonato.getIdCampeonato();
    }

    // TODO LA CATEGORIA LA CONTROLA LA VISTA
    // SI SE LE PASA 0 COMO CANTIDAD DE ZONAS EL TORNEO ES POR PUNTOS.

    public void definirTipoCampeonatoAndCategoria(int cantidadZonas, Integer idCampeonato, int categoria) throws ClubesCampeonatoException, PartidoException, CampeonatoException, ClubException {
        Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);

        List<ClubVO> equiposVO = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);
        List<Club> equipos = new ArrayList<>();

        for(ClubVO c : equiposVO) {
            equipos.add(c.toModelo());
        }

        int cantEquipos = equipos.size();

        generarPartidos(campeonato, categoria, cantidadZonas, cantEquipos);
        ControladorTablasPosiciones.getInstancia().generarTablaIncial(equipos, campeonato);
    }

    private void generarPartidos(Campeonato campeonato, int categoria, float cantidadZonas, float cantEquipos) throws CampeonatoException, ClubesCampeonatoException, ClubException, PartidoException {
        GeneracionPartidosStrategy strategy;

        if ((cantidadZonas == 0)) {
            campeonato.setTipoCampeonato("Puntos");

            if (cantEquipos % 2 == 0)
                strategy = new GenerarPuntosPar();
            else
                strategy = new GenerarPuntosImpar();

        } else if (cantEquipos % 2 == 0) {
            campeonato.setTipoCampeonato("Zonas");

            if ((cantEquipos / cantidadZonas) % 2 == 0)
                strategy = new GenerarZonasPar((int) cantidadZonas);
            else
                strategy = new GenerarZonasImpar((int)cantidadZonas);

        } else {
            throw new PartidoException("No pueden generase los partidos");

        }

        campeonato.update();
        strategy.generarPartidosCampeonato(campeonato, categoria);
    }

    public void terminarCampeonato(Integer idCampeonato) throws CampeonatoException {

        Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
        campeonato.setEstado("inactivo");
        campeonato.update();

    }

    public CampeonatoVO encontrarCampeonato(Integer idCampeonato) throws CampeonatoException {
        return CampeonatoDao.getInstancia().getCampeonato(idCampeonato).toVO();

    }

    public List<CampeonatoVO> getCampeonatos() throws CampeonatoException {
        return transformarAListaVO(CampeonatoDao.getInstancia().getCampeonatos());

    }

    public List<CampeonatoVO> getCampeonatosByEstado(String estado) throws CampeonatoException {
        return transformarAListaVO(CampeonatoDao.getInstancia().getCampeonatosByEstado(estado));

    }

    public boolean estaEnLaFecha(Campeonato campeonato, LocalDate fecha) {
        return campeonato.estaEnLaFecha(fecha);
    }

    public List<CampeonatoVO> campeonatosADefinir () throws CampeonatoException {
        List<CampeonatoVO> resultado = new ArrayList<>();
        List<Campeonato> campeonatos = CampeonatoDao.getInstancia().getCampeonatosZonasActivos();
        for(Campeonato c : campeonatos) {

            if (PartidoDao.getInstancia().getCantPartidosByCampeonato(c.getIdCampeonato()) == PartidoDao.getInstancia().getCantPartidosByCampeonatoValidados(c.getIdCampeonato()))
                resultado.add(c.toVO());
        }

        return resultado;
    }


    public int getCategoriaCampeonato(Integer idCampeonato) throws PartidoException {
        return PartidoDao.getInstancia().getCategoriaCampeonato(idCampeonato);
    }

    //PARTE DE CLUBES CAMPEONATO

    public void agregarClubACampeonato(Integer idClub, Integer idCampeonato) throws CampeonatoException, ClubException {
        Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
        Club club = ControladorClubes.getInstancia().getClubById(idClub).toModelo();
        campeonato.inscribirClub(club);

    }

    public List<CampeonatoVO> getCampeonatosByClub(Integer idClub) throws ClubesCampeonatoException {
        return transformarAListaVO(ClubesCampeonatoDao.getInstancia().getCampeonatosClub(idClub));
    }

    private List<CampeonatoVO> transformarAListaVO(List<Campeonato> lista) {
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato item : lista) {
            result.add(item.toVO());
        }
        return result;
    }


}
