package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorGoles;

public class ControladorGolesTest extends TestCase {
    ControladorGoles controladorGoles = ControladorGoles.getInstancia();

    public void testCargarGol() {
        System.out.println(controladorGoles.cargarGol(3, 1, 5, "a favor"));
        System.out.println(controladorGoles.cargarGol(3, 1, 10, "a favor"));
        System.out.println(controladorGoles.cargarGol(3, 1, 15, "a favor"));
        System.out.println(controladorGoles.cargarGol(4, 1, 12, "a favor"));
        System.out.println(controladorGoles.cargarGol(4, 1, 12, "en contra"));
    }

    public void testContarCantidadGoles() {
        System.out.println(controladorGoles.contarCantidadGoles(1,1));
        System.out.println(controladorGoles.contarCantidadGoles(2,1));
    }

    public void testGetGoles() {
        System.out.println(controladorGoles.getGoles());
    }

    public void testGetGolesByPartido() {
        System.out.println(controladorGoles.getGolesByPartido(1));
    }

    public void testGetGolesByPartidoAndClub() {
        System.out.println(controladorGoles.getGolesByPartidoAndClub(1, 1,2));
        System.out.println(controladorGoles.getGolesByPartidoAndClub(1,2,1));
    }

    public void testGetGolesByPartidoAndSentido() {
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "en contra"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "a favor"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "a favofsar"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(2, "a favor"));

    }

    public void testGetGolesByJugadorAndPartido() {
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,3));
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,4));
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,5));
    }

    public void testGetGolesByJugador() {
        System.out.println(controladorGoles.getGolesByJugador(1));
        System.out.println(controladorGoles.getGolesByJugador(2));
        System.out.println(controladorGoles.getGolesByJugador(3));
        System.out.println(controladorGoles.getGolesByJugador(4));
        System.out.println(controladorGoles.getGolesByJugador(5));
        System.out.println(controladorGoles.getGolesByJugador(6));
        System.out.println(controladorGoles.getGolesByJugador(7));
        System.out.println(controladorGoles.getGolesByJugador(8));
    }

    public void testGetGolById() {
        System.out.println(controladorGoles.getGolById(1));
        System.out.println(controladorGoles.getGolById(2));
        System.out.println(controladorGoles.getGolById(3));
        System.out.println(controladorGoles.getGolById(4));
        System.out.println(controladorGoles.getGolById(5));
        System.out.println(controladorGoles.getGolById(6));
    }
}