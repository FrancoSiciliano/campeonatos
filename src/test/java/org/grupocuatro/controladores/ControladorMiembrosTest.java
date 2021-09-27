package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.controlador.ControladorMiembros;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.*;

import java.time.LocalDate;

public class ControladorMiembrosTest extends TestCase {
    ControladorMiembros controladorMiembros = ControladorMiembros.getInstancia();
    ControladorClubes controladorClubes = ControladorClubes.getInstancia();
    ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
    ControladorJugadores controladorJugadores = ControladorJugadores.getInstancia();


    public void testAgregarJugadoresEnLista() throws FaltaException, ClubException, PartidoException, JugadorException {
        controladorMiembros.agregarJugadoresEnLista(9, 1, 3);
        controladorMiembros.agregarJugadoresEnLista(9, 4, 4);
        controladorMiembros.agregarJugadoresEnLista(9, 6, 1);
    }

    public void testGetMiembroById() {
        try {
            System.out.println(controladorMiembros.getMiembroById(1));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembros() {
        try {
            System.out.println(controladorMiembros.getMiembros());
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembrosByClub() {
        try {
            System.out.println(controladorMiembros.getMiembrosByClub(1));
            System.out.println(controladorMiembros.getMiembrosByClub(2));
            System.out.println(controladorMiembros.getMiembrosByClub(4));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetMiembrosByClubAndPartido() {
        try {
            System.out.println(controladorMiembros.getMiembrosByClubAndPartido(1,1));
            System.out.println(controladorMiembros.getMiembrosByClubAndPartido(2,1));
            System.out.println(controladorMiembros.getMiembrosByClubAndPartido(1,2));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetMiembroByPartidoAndJugador() {
        try {
            System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,3));
            System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,4));
            System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,5));
            System.out.println(controladorMiembros.getMiembroByPartidoAndJugador(1,35));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetMiembroByClubAndPartidoAndJugador() {
        try {
            System.out.println(controladorMiembros.getMiembroByClubAndPartidoAndJugador(1,1,3));
            System.out.println(controladorMiembros.getMiembroByClubAndPartidoAndJugador(3,1,3));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetMiembroByJugadorAndFecha() {
        try {
            System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(3, LocalDate.of(2020,8,10)));
            System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(3, LocalDate.of(2020,8,13)));
            System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(4, LocalDate.of(2020,8,10)));
            System.out.println(controladorMiembros.getMiembroByJugadorAndFecha(2, LocalDate.of(2020,8,10)));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testDefinirIngresoEgreso() {
        controladorMiembros.definirIngresoEgreso(1, 0, 90);
    }
}