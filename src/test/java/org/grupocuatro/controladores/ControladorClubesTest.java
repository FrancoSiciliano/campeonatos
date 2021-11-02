package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Club;

import java.util.List;

public class ControladorClubesTest extends TestCase {

    public void testCrearClub() {
        try {
            ControladorClubes.getInstancia().crearClub(1, "Boca", "La Boca 100");
            ControladorClubes.getInstancia().crearClub(2, "River", "Nuñez 200");
            ControladorClubes.getInstancia().crearClub(3, "Racing", "Pasaje Corbatta 300");
            ControladorClubes.getInstancia().crearClub(4, "Independiente", "Avellaneda 400");
            ControladorClubes.getInstancia().crearClub(5, "San Lorenzo", "Boedo 440");
            ControladorClubes.getInstancia().crearClub(6, "Ferrocarril Oeste", "Caballito 505");
            ControladorClubes.getInstancia().crearClub(7, "Banfield", "Banfield 1450");
            ControladorClubes.getInstancia().crearClub(8, "Defensa y Justicia", "Florencio Varela 30");
            ControladorClubes.getInstancia().crearClub(9, "Inter", "Piazzale Angelo Moratti");
            ControladorClubes.getInstancia().crearClub(10, "PSG", "Parc Des Princes");
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarClub() {
        try {
            ControladorClubes.getInstancia().modificarClub(1, "Boca Juniors", "La Boca 50");
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetClubes() {
        try {
            System.out.println(ControladorClubes.getInstancia().getClubes());
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetClubById() {
        try {
            System.out.println(ControladorClubes.getInstancia().getClubById(3).toModelo());
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testgetClubesByCampeonato() {
        try {
            System.out.println(ControladorClubes.getInstancia().getClubesByCampeonato(1));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testgetClubesHabilitadosPorCategoria() {
        try {
            System.out.println(ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(85));
            System.out.println(ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(100));
            System.out.println(ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(0));
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }

    }
}
