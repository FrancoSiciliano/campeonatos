package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.PartidoVO;

import java.time.LocalDate;
import java.util.List;

public class ControladorPartidosTest extends TestCase {

    public void testcrearPartido() throws PartidoException {
        ControladorPartidos.getInstancia().crearPartido(1,1,80,1,2);
        ControladorPartidos.getInstancia().crearPartido(2,1,78,3,4);
        ControladorPartidos.getInstancia().crearPartido(3,1,86,5,6);
        ControladorPartidos.getInstancia().crearPartido(4,1,83,7,8);

    }

    public void testEncontrarPartido() throws PartidoException {
        ControladorPartidos.getInstancia().encontrarPartido(1);
        ControladorPartidos.getInstancia().encontrarPartido(2);
        ControladorPartidos.getInstancia().encontrarPartido(5);
    }

    public void testcargarResultadoPartido() throws PartidoException, GolException {
        ControladorPartidos.getInstancia().cargarResultadoPartido(1,"Ingreso un hincha al estadio");
        ControladorPartidos.getInstancia().cargarResultadoPartido(2, "");
        ControladorPartidos.getInstancia().cargarResultadoPartido(3, "");
        ControladorPartidos.getInstancia().cargarResultadoPartido(4, "El arbitro resulto agredido");
        ControladorPartidos.getInstancia().cargarResultadoPartido(9, "");
    }



    public void testvalidadoPorClubVisitante() throws PartidoException {
        ControladorPartidos.getInstancia().validadoPorClubVisitante(2,1);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(4,2);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(6,3);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(8,4);
    }

    public void testvalidadoPorClubLocal() throws PartidoException {
        ControladorPartidos.getInstancia().validadoPorClubLocal(1,1);
        ControladorPartidos.getInstancia().validadoPorClubLocal(3,2);
        ControladorPartidos.getInstancia().validadoPorClubLocal(5,3);
        ControladorPartidos.getInstancia().validadoPorClubLocal(7,4);
    }

    public void testGetAllPartidos() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getAllPartidos();
        System.out.println(partidos);
    }

    public void testGetPartidosByCategoria() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByCategoria(78);
        System.out.println(partidos);
    }

    public void testGetPartidosByNroZona() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByNroZona(1);
        System.out.println(partidos);
    }

    public void testGetPartidosByClubLocal() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByClubLocal(1);
        System.out.println(partidos);
    }

    public void testGetPartidosByClubVisitante() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByClubVisitante(2);
        System.out.println(partidos);
    }

    public void testGetPartidosByCampeonato() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByCampeonato(1);
        System.out.println(partidos);
    }

    public void testGetUltimoPartidoByClubAndCampeonato() throws PartidoException {
        PartidoVO partido = ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(ControladorClubes.getInstancia().getClubById(1).getIdClub(), ControladorCampeonatos.getInstancia().encontrarCampeonato(1).getIdCampeonato(), 1);
        if (partido != null) System.out.println(partido.getIdPartido());
    }

    public void testGetPartidosByNroFechaAndCampeonato() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(1, 1);
        for (PartidoVO partido : partidos)
            System.out.println(partido.getIdPartido());
    }

    public void testGetPartidosByNroFechaAndCampeonatoAndClub() throws PartidoException {
        List<PartidoVO> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(1,1,1);
        for (PartidoVO partido : partidos)
            System.out.println(partido.getIdPartido());
    }

    public void testCargarNroFechaYFecha() {
        ControladorPartidos.getInstancia().cargarNroFechaYFecha(1, 1, LocalDate.of(2021,5,2));
    }

}
