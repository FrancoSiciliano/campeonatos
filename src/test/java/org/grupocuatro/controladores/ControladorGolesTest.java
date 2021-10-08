package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorGoles;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;

public class ControladorGolesTest extends TestCase {
    ControladorGoles controladorGoles = ControladorGoles.getInstancia();

    public void testCargarGol() {
        try {
            System.out.println(controladorGoles.cargarGol(15, 8, 5, "a favor"));
        } catch (JugadorException | PartidoException | GolException | MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testContarCantidadGoles() throws GolException, PartidoException {
        System.out.println(controladorGoles.contarCantidadGoles(1,1));
        System.out.println(controladorGoles.contarCantidadGoles(2,1));
    }

    public void testGetGoles() throws GolException {
        System.out.println(controladorGoles.getGoles());
    }

    public void testGetGolesByPartido() throws GolException {
        System.out.println(controladorGoles.getGolesByPartido(1));
    }

    public void testGetGolesByPartidoAndClub() throws GolException {
        System.out.println(controladorGoles.getGolesByPartidoAndClub(1, 1,2));
        System.out.println(controladorGoles.getGolesByPartidoAndClub(1,2,1));
    }

    public void testGetGolesByPartidoAndSentido() throws GolException {
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "en contra"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "a favor"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(1, "sentidoDesconocido"));
        System.out.println(controladorGoles.getGolesByPartidoAndSentido(2, "a favor"));

    }

    public void testGetGolesByJugadorAndPartido() throws GolException {
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,3));
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,4));
        System.out.println(controladorGoles.getGolesByJugadorAndPartido(1,5));
    }

    public void testGetGolesByJugador() throws GolException {
        System.out.println(controladorGoles.getGolesByJugador(1));
        System.out.println(controladorGoles.getGolesByJugador(2));
        System.out.println(controladorGoles.getGolesByJugador(3));
        System.out.println(controladorGoles.getGolesByJugador(4));
        System.out.println(controladorGoles.getGolesByJugador(5));
        System.out.println(controladorGoles.getGolesByJugador(6));
        System.out.println(controladorGoles.getGolesByJugador(7));
        System.out.println(controladorGoles.getGolesByJugador(8));
    }

    public void testGetGolById() throws GolException {
        System.out.println(controladorGoles.getGolById(1));
        System.out.println(controladorGoles.getGolById(2));
        System.out.println(controladorGoles.getGolById(3));
        System.out.println(controladorGoles.getGolById(4));
        System.out.println(controladorGoles.getGolById(5));
        System.out.println(controladorGoles.getGolById(6));
    }
}