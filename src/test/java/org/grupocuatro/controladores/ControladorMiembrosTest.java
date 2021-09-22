package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.controlador.ControladorMiembros;
import org.grupocuatro.controlador.ControladorPartidos;

import java.time.LocalDate;

public class ControladorMiembrosTest extends TestCase {
    ControladorMiembros controladorMiembros = ControladorMiembros.getInstancia();
    ControladorClubes controladorClubes = ControladorClubes.getInstancia();
    ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
    ControladorJugadores controladorJugadores = ControladorJugadores.getInstancia();


    public void testAgregarJugadoresEnLista() {
        controladorMiembros.agregarJugadoresEnLista(controladorClubes.getClubById(9), controladorPartidos.encontrarPartido(1), controladorJugadores.encontrarJugador(3));
        controladorMiembros.agregarJugadoresEnLista(controladorClubes.getClubById(9), controladorPartidos.encontrarPartido(4), controladorJugadores.encontrarJugador(4));
        controladorMiembros.agregarJugadoresEnLista(controladorClubes.getClubById(9), controladorPartidos.encontrarPartido(6), controladorJugadores.encontrarJugador(1));
    }

    public void testGetMiembroById() {
        System.out.println(controladorMiembros.getMiembroById(1));
    }

    public void testGetMiembros() {
        System.out.println(controladorMiembros.getMiembros());
    }

    public void testGetMiembrosByClub() {
        System.out.println(controladorMiembros.getMiembrosByClub(1));
        System.out.println(controladorMiembros.getMiembrosByClub(2));
        System.out.println(controladorMiembros.getMiembrosByClub(4));
    }

    public void testGetMiembrosByClubAndPartido() {
        System.out.println(controladorMiembros.getMiembrosByClubAndPartido(1,1));
        System.out.println(controladorMiembros.getMiembrosByClubAndPartido(2,1));
        System.out.println(controladorMiembros.getMiembrosByClubAndPartido(1,2));
    }

    public void testGetMiembroByPartidoAndJugador() {
        System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,3));
        System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,4));
        System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,5));
        System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,35));
    }

    public void testGetMiembroByClubAndPartidoAndJugador() {
        System.out.println(controladorMiembros.getMiembroByClubAndPartidoAndJugador(1,1,3));
        System.out.println(controladorMiembros.getMiembroByClubAndPartidoAndJugador(3,1,3));
    }

    public void testGetMiembroByJugadorAndFecha() {
        System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(3, LocalDate.of(2020,8,10)));
        System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(3, LocalDate.of(2020,8,13)));
        System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(4, LocalDate.of(2020,8,10)));
        System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(2, LocalDate.of(2020,8,10)));
    }

    public void testDefinirIngresoEgreso() {
        controladorMiembros.definirIngresoEgreso(1, 0, 90);
    }
}