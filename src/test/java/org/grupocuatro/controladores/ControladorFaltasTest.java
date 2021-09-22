package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.modelo.Falta;

import java.util.List;

public class ControladorFaltasTest extends TestCase {



    public void testCargarFalta() {
        ControladorFaltas.getInstancia().cargarFalta(2, 2, 78, "amarilla");
        ControladorFaltas.getInstancia().cargarFalta(3, 1, 23, "roja");
    }

    public void testGetFaltasPartido() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasPartido(1);
        System.out.println(faltas);
    }

    public void testGetFaltasByTipoAndPartido() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByTipoAndPartido(2, "amarilla");
        System.out.println(faltas);
    }

    public void testGetFaltasByCampeonato() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByCampeonato(1);
        System.out.println(faltas);
    }

    public void testGetFaltasByJugadorAndPartido() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugadorAndPartido(2, 2);
        System.out.println(faltas);
    }

    public void testGetFaltasByJugadorAndTipoAndPartido() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(2, "amarilla", 2);
        System.out.println(faltas);
    }

    public void testGetFaltasByJugadorAndCampeonato() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugadorAndCampeonato(2, 1);
        System.out.println(faltas);
    }

    public void testGetFaltasByJugadorAndPartidoAndTipoAndCampeonato() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugadorAndPartidoAndTipo(2, 2, "amarilla");
        System.out.println(faltas);
    }

    public void testGetFaltas() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltas();
        System.out.println(faltas);
    }

    public void testGetFaltasById() {
        Falta falta = ControladorFaltas.getInstancia().getFaltaById(1);
        System.out.println(falta.getJugador().getNombre());
    }

    public void testGetFaltasByJugador() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByJugador(2);
        System.out.println(faltas);
    }

    public void testGetFaltasByTipo() {
        List<Falta> faltas = ControladorFaltas.getInstancia().getFaltasByTipo("amarilla");
        System.out.println(faltas);
    }
}