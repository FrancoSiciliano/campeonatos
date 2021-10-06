package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.PartidoVO;

import java.time.LocalDate;
import java.util.List;

public class ControladorPartidosTest extends TestCase {

    public void testcrearPartido(){
        try {
            ControladorPartidos.getInstancia().crearPartido(1,1,80,1,2);
            ControladorPartidos.getInstancia().crearPartido(2,1,78,3,4);
            ControladorPartidos.getInstancia().crearPartido(3,1,86,5,6);
            ControladorPartidos.getInstancia().crearPartido(4,1,83,7,8);
        } catch (PartidoException | CampeonatoException | ClubException  e) {
            System.out.println(e.getMessage());
        }

    }

    public void testEncontrarPartido(){
        try {
            System.out.println(ControladorPartidos.getInstancia().encontrarPartido(1));
            System.out.println(ControladorPartidos.getInstancia().encontrarPartido(2));
            System.out.println(ControladorPartidos.getInstancia().encontrarPartido(5));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testcargarResultadoPartido(){
        try {
            ControladorPartidos.getInstancia().cargarResultadoPartido(1,"Ingreso un hincha al estadio");
            ControladorPartidos.getInstancia().cargarResultadoPartido(2, "");
            ControladorPartidos.getInstancia().cargarResultadoPartido(3, "");
            ControladorPartidos.getInstancia().cargarResultadoPartido(4, "El arbitro resulto agredido");
            ControladorPartidos.getInstancia().cargarResultadoPartido(9, "");
        } catch (PartidoException | GolException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testvalidadoPorClubVisitante(){
        try {
            ControladorPartidos.getInstancia().validadoPorClubVisitante(2,1);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(4,2);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(6,3);
            ControladorPartidos.getInstancia().validadoPorClubVisitante(8,4);
        } catch (CampeonatoException | ClubException | TablaPosicionException | PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testvalidadoPorClubLocal()  {
        try {
            ControladorPartidos.getInstancia().validadoPorClubLocal(1,1);
            ControladorPartidos.getInstancia().validadoPorClubLocal(3,2);
            ControladorPartidos.getInstancia().validadoPorClubLocal(5,3);
            ControladorPartidos.getInstancia().validadoPorClubLocal(7,4);
        } catch (CampeonatoException | ClubException | TablaPosicionException | PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetAllPartidos() {
        try {
            System.out.println(ControladorPartidos.getInstancia().getAllPartidos());
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByCategoria(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByCategoria(78));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByNroZona(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByNroZona(1));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByClubLocal(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByClubLocal(1));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByClubVisitante(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByClubVisitante(2));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByCampeonato(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByCampeonato(1));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetUltimoPartidoByClubAndCampeonato(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(ControladorClubes.getInstancia().getClubById(1).getIdClub(), ControladorCampeonatos.getInstancia().encontrarCampeonato(1).getIdCampeonato(), 1));
        } catch (PartidoException | ClubException | CampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByNroFechaAndCampeonato(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(1, 1));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetPartidosByNroFechaAndCampeonatoAndClub(){
        try {
            System.out.println(ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(1,1,1));
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
