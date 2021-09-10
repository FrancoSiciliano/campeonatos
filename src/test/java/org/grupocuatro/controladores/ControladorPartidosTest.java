package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorPartidos;

import java.time.LocalDate;

public class ControladorPartidosTest extends TestCase {

    public void testcrearPartido() {
        ControladorPartidos.getInstancia().crearPartido(1,1,80,1,2, LocalDate.of(2020,8,10),1);
        ControladorPartidos.getInstancia().crearPartido(2,1,78,3,4, LocalDate.of(2020,9,4),1);
        ControladorPartidos.getInstancia().crearPartido(3,1,86,5,6, LocalDate.of(2020,6,17),1);
        ControladorPartidos.getInstancia().crearPartido(4,1,83,7,8, LocalDate.of(2020,7,6),1);

    }
    public void testencontrarPartido() {
        ControladorPartidos.getInstancia().encontrarPartido(1);
        ControladorPartidos.getInstancia().encontrarPartido(2);
        ControladorPartidos.getInstancia().encontrarPartido(5);
    }
    public void testvalidadoPorClubLocal(){
        ControladorPartidos.getInstancia().validadoPorClubLocal(1,1);
        ControladorPartidos.getInstancia().validadoPorClubLocal(5,1);
        ControladorPartidos.getInstancia().validadoPorClubLocal(1,4);

    }

//    public void testcargarResultadoPartido() {//tiene un fixme
//        ControladorPartidos.getInstancia().cargarResultadoPartido(1);
//        ControladorPartidos.getInstancia().cargarResultadoPartido(2);
//        ControladorPartidos.getInstancia().cargarResultadoPartido(3);
//        ControladorPartidos.getInstancia().cargarResultadoPartido(8);
//        ControladorPartidos.getInstancia().cargarResultadoPartido(9);
//    }

    public void testactualizarTablaPosiciones() {
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,1,0,2,1);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,1,1,2,2);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(1,2,1,0,0);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(2,1,2,1,0);
        ControladorPartidos.getInstancia().actualizarTablaPosiciones(3,3,2,3,2);
    }

    public void testvalidadoPorClubVisitante(){
        ControladorPartidos.getInstancia().validadoPorClubVisitante(1,1);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(5,1);
        ControladorPartidos.getInstancia().validadoPorClubVisitante(1,4);
    }
}
