package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorTablasPosiciones;
import org.grupocuatro.modelo.TablaPosiciones;

import java.util.List;

public class ControladorTablasPosicionesTest extends TestCase {

    public void testGetTablasPosicionesByClub() {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablasPosicionesByClub(1);
        System.out.println(tablas);
    }

    public void testGetTablaPosicionesByClubAndCampeonato() {
        TablaPosiciones tabla = ControladorTablasPosiciones.getInstancia().getTablaPosicionesByClubAndCampeonato(1,1);
        if (tabla != null) System.out.println(tabla);
    }

    public void testGetTablaPosicionesByCampeonato() {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablasPosicionesByCampeonato(1);
        System.out.println(tablas);

    }

    public void testGetTablaPosicionesByPuntos() {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablaPosicionesByPuntos(4);
        System.out.println(tablas);
    }

}
