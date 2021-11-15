package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.PartidoVO;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.time.LocalDate;
import java.util.List;

public class ControladorPartidosTest extends TestCase {

    public void testcrearPartido(){
        try {
            ControladorPartidos.getInstancia().crearPartido(1,90,1,2,2008);
            ControladorPartidos.getInstancia().crearPartido(2,1,78,3,4);
            ControladorPartidos.getInstancia().crearPartido(3,1,86,5,6);
            ControladorPartidos.getInstancia().crearPartido(4,1,83,7,8);
        } catch (CampeonatoException | ClubException | PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testEncontrarPartido(){
        try {
            ControladorPartidos.getInstancia().encontrarPartido(1);
            ControladorPartidos.getInstancia().encontrarPartido(2);
            ControladorPartidos.getInstancia().encontrarPartido(5);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testcargarResultadoPartido(){
        try {
            ControladorPartidos.getInstancia().cargarResultadoPartido(134,"");

        } catch (PartidoException | GolException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testvalidadoPorClubVisitante(){
        try {
            ControladorPartidos.getInstancia().validadoPorClubVisitante(2,132);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(1,133);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(4,134);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(3,135);
        } catch (CampeonatoException | ClubException | TablaPosicionException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testvalidadoPorClubLocal(){
        try {
            ControladorPartidos.getInstancia().validadoPorClubLocal(1,132);
            ControladorPartidos.getInstancia().validadoPorClubLocal(2,133);
            ControladorPartidos.getInstancia().validadoPorClubLocal(3,134);
            ControladorPartidos.getInstancia().validadoPorClubLocal(4,135);
        } catch (CampeonatoException | ClubException | TablaPosicionException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetAllPartidos(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getAllPartidos();
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByCategoria(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByCategoria(78);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByNroZona(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByNroZona(1);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByClubLocal(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByClubLocal(1);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByClubVisitante(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByClubVisitante(2);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByCampeonato(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByCampeonato(2008);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetUltimoPartidoByClubAndCampeonato(){
        PartidoVO partido = null;
        try {
            partido = ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(ControladorClubes.getInstancia().getClubById(1).getIdClub(), ControladorCampeonatos.getInstancia().encontrarCampeonato(1).getIdCampeonato(), 1);
            System.out.println(partido);
        } catch (PartidoException | ClubException | CampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByNroFechaAndCampeonato(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(1, 1);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByNroFechaAndCampeonatoAndClub(){
        List<PartidoVO> partidos = null;
        try {
            partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(1,1,1);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testCargarNroFechaYFecha() {
        try {
            ControladorPartidos.getInstancia().cargarNroFechaYFecha(1, 1, LocalDate.of(2021,5,2));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

}
