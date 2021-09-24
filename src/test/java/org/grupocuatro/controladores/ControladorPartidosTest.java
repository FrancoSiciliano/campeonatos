package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.modelo.Partido;

import java.time.LocalDate;
import java.util.List;

public class ControladorPartidosTest extends TestCase {

    public void testcrearPartido() {
        ControladorPartidos.getInstancia().crearPartido(1,1,80,1,2);
        ControladorPartidos.getInstancia().crearPartido(2,1,78,3,4);
        ControladorPartidos.getInstancia().crearPartido(3,1,86,5,6);
        ControladorPartidos.getInstancia().crearPartido(4,1,83,7,8);

    }

    public void testEncontrarPartido() {
        ControladorPartidos.getInstancia().encontrarPartido(1);
        ControladorPartidos.getInstancia().encontrarPartido(2);
        ControladorPartidos.getInstancia().encontrarPartido(5);
    }

    public void testcargarResultadoPartido() {
        ControladorPartidos.getInstancia().cargarResultadoPartido(1,"Ingreso un hincha al estadio");
        ControladorPartidos.getInstancia().cargarResultadoPartido(2, "");
        ControladorPartidos.getInstancia().cargarResultadoPartido(3, "");
        ControladorPartidos.getInstancia().cargarResultadoPartido(4, "El arbitro resulto agredido");
        ControladorPartidos.getInstancia().cargarResultadoPartido(9, "");
    }

    public void testactualizarTablaPosiciones() {
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,1,0,2,1);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,1,1,2,2);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,2,1,0,0);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(2,1,2,1,0);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(3,3,2,3,2);
    }

    public void testvalidadoPorClubVisitante(){
        ControladorPartidos.getInstancia().validadoPorClubVisitante(2,1);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(4,2);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(6,3);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(8,4);
    }

    public void testvalidadoPorClubLocal(){
        ControladorPartidos.getInstancia().validadoPorClubLocal(1,1);
        ControladorPartidos.getInstancia().validadoPorClubLocal(3,2);
        ControladorPartidos.getInstancia().validadoPorClubLocal(5,3);
        ControladorPartidos.getInstancia().validadoPorClubLocal(7,4);
    }

    public void testGetAllPartidos() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getAllPartidos();
        System.out.println(partidos);
    }

    public void testGetPartidosByCategoria() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByCategoria(78);
        System.out.println(partidos);
    }

    public void testGetPartidosByNroZona() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroZona(1);
        System.out.println(partidos);
    }

    public void testGetPartidosByClubLocal() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByClubLocal(1);
        System.out.println(partidos);
    }

    public void testGetPartidosByClubVisitante() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByClubVisitante(2);
        System.out.println(partidos);
    }

    public void testGetPartidosByCampeonato() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByCampeonato(1);
        System.out.println(partidos);
    }

    public void testGetUltimoPartidoByClubAndCampeonato() {
        Partido partido = ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(ControladorClubes.getInstancia().getClubById(1), ControladorCampeonatos.getInstancia().encontrarCampeonato(1), 1);
        if (partido != null) System.out.println(partido.getIdPartido());
    }

    public void testGetPartidosByNroFechaAndCampeonato() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(1, 1);
        for (Partido partido : partidos)
            System.out.println(partido.getIdPartido());
    }

    public void testGetPartidosByNroFechaAndCampeonatoAndClub() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(1,1,1);
        for (Partido partido : partidos)
            System.out.println(partido.getIdPartido());
    }

    public void testCargarNroFechaYFecha() {
        ControladorPartidos.getInstancia().cargarNroFechaYFecha(1, 1, LocalDate.of(2021,5,2));
    }

}
