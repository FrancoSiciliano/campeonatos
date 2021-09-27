package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Falta;

import java.util.List;

public class ControladorFaltasTest extends TestCase {



    public void testCargarFalta() {
        try {
            ControladorFaltas.getInstancia().cargarFalta(2, 2, 78, "amarilla");
            ControladorFaltas.getInstancia().cargarFalta(3, 1, 23, "roja");
        } catch (MiembroException | JugadorException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasPartido() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasPartido(1));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByTipoAndPartido() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByTipoAndPartido(2, "amarilla")) ;
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByCampeonato() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByCampeonato(1));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByJugadorAndPartido() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByJugadorAndPartido(2, 2));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugadorAndTipoAndPartido() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(2, "amarilla", 2));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByJugadorAndCampeonato() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByJugadorAndCampeonato(2, 1));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByJugadorAndPartidoAndTipoAndCampeonato() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByJugadorAndPartidoAndTipo(2, 2, "amarilla")) ;
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltas() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltas());
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasById() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltaById(1));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugador() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByJugador(2));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByTipo() {
        try {
            System.out.println(ControladorFaltas.getInstancia().getFaltasByTipo("amarilla"));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }
}