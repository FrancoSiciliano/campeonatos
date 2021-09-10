package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.modelo.Club;

import java.util.List;

public class ControladorClubesTest extends TestCase {

    public void testCrearClub() {
        ControladorClubes.getInstancia().crearClub(1, "Boca", "La Boca 100");
        ControladorClubes.getInstancia().crearClub(2, "River", "Nuñez 200");
        ControladorClubes.getInstancia().crearClub(3, "Racing", "Pasaje Corbatta 300");
        ControladorClubes.getInstancia().crearClub(4, "Independiente", "Avellaneda 400");
        ControladorClubes.getInstancia().crearClub(5, "San Lorenzo", "Unknown");
        ControladorClubes.getInstancia().crearClub(6, "Ferrocarril Oeste", "Caballito 505");
        ControladorClubes.getInstancia().crearClub(7, "Banfield", "Banfield 1450");
        ControladorClubes.getInstancia().crearClub(8, "Defensa y Justicia", "Florencio Varela 30");
    }

    public void testModificarClub() {
        ControladorClubes.getInstancia().modificarClub(1, "Boca Juniors", "La Boca 50");
    }

    public void testGetClubes() {
        List<Club> clubes = ControladorClubes.getInstancia().getClubes();
        for (Club c : clubes)
            System.out.println(c.getNombre());
    }

    public void testGetClubById() {
        Club c = ControladorClubes.getInstancia().getClubById(3);
        System.out.println(c.getNombre());
    }

    //TODO FALTA TESTEAR ESTO CUANDO EXISTAN CAMPEONATOS

    public void getClubesByCampeonato() {
        List<Club> clubes = ControladorClubes.getInstancia().getClubesByCampeonato(1);
    }

}