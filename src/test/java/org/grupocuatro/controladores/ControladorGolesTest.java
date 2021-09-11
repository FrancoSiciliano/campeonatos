package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorGoles;

public class ControladorGolesTest extends TestCase {

    public void testGetInstancia() {
    }

    public void testCargarGol() {
        ControladorGoles controladorGoles = ControladorGoles.getInstancia();
        System.out.println(controladorGoles.cargarGol(3, 1, 5, "a favor"));
        System.out.println(controladorGoles.cargarGol(3, 1, 10, "a favor"));
        System.out.println(controladorGoles.cargarGol(3, 1, 15, "a favor"));
        System.out.println(controladorGoles.cargarGol(4, 1, 12, "a favor"));
        System.out.println(controladorGoles.cargarGol(4, 1, 12, "en contra"));
    }

    public void testContarCantidadGoles() {
        ControladorGoles controladorGoles = ControladorGoles.getInstancia();
        System.out.println(controladorGoles.contarCantidadGoles(1,1));
        System.out.println(controladorGoles.contarCantidadGoles(2,1));
    }

    public void testGetGoles() {
    }

    public void testGetGolesByPartido() {
    }

    public void testGetGolesByPartidoAndClub() {
    }

    public void testGetGolesByPartidoAndSentido() {
    }

    public void testGetGolesByJugadorAndPartido() {
    }

    public void testGetGolesByJugador() {
    }

    public void testGetGolById() {
    }
}