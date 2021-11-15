package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorTablasPosiciones;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.TablaPosiciones;

import java.util.List;

public class ControladorTablasPosicionesTest extends TestCase {

    public void testgetTablaPosZonas(){
        try{
            System.out.println(ControladorTablasPosiciones.getInstancia().getTablaPosicionesPorZona(8));
        } catch (PartidoException | ClubesCampeonatoException | TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }
    public void testGetTablasPosicionesByClub() {
        try {
            System.out.println(ControladorTablasPosiciones.getInstancia().getTablasPosicionesByClub(1));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetTablaPosicionesByClubAndCampeonato() {
        try {
            System.out.println(ControladorTablasPosiciones.getInstancia().getTablaPosicionesByClubAndCampeonato(1, 1));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetTablaPosicionesByCampeonato() {
        try {
            System.out.println(ControladorTablasPosiciones.getInstancia().getTablasPosicionesByCampeonato(1));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetTablaPosicionesByPuntos() {
        try {
            System.out.println(ControladorTablasPosiciones.getInstancia().getTablaPosicionesByPuntos(4));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }

    }

}
