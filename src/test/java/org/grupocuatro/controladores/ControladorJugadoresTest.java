package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.vo.JugadorVO;
import org.grupocuatro.vo.StatsVO;

import java.time.LocalDate;
import java.util.List;

public class ControladorJugadoresTest extends TestCase {

    public void testCrearJugador() {
        try {
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31222222, "Diego Alberto", "Milito", 3, LocalDate.of(1979, 6, 12), "Su casa 22", "dmilito@mail.com", "123456789");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 28754213, "Ricardo Enrique", "Bochini", 4, LocalDate.of(1954, 1, 25), "Su casa 10", "rbochini@mail.com", "987654321");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31123456, "Juan Roman", "Riquelme", 1, LocalDate.of(1978, 6, 24), "Su casa 5", "rriquelme@mail.com", "123789456");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30458741, "Marcelo Daniel", "Gallardo", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "mgallardo@mail.com", "456123789");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35487541, "Sebastian Alberto", "Torrico", 5, LocalDate.of(1980, 2, 22), "Su casa 1", "storrico@mail.com", "852741963");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36875123, "Luis Angel", "Salmeron", 6, LocalDate.of(1982, 3, 18), "Su casa 9", "lsalmeron@mail.com", "258147369");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40528741, "James David", "Rodriguez", 7, LocalDate.of(1991, 7, 12), "Su casa 100", "jrodriguez@mail.com", "963741852");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37852136, "Washington Fernando", "Camacho", 8, LocalDate.of(1986, 4, 8), "Su casa 8", "wcamacho@mail.com", "546712893");
        } catch (ClubException | JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadores() throws JugadorException {
        List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadores();
        for (JugadorVO j : jugadores)
            System.out.println(j.getNombre() + " " + j.getApellido() + " " + j.getCategoria());
    }

    public void testGetJugadoresByClub() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadoresByClub(3);
            for (JugadorVO j : jugadores)
                System.out.println("Club: " + j.getClub().getIdClub() + " - Jugador: " + j.getNombre() + " " + j.getApellido());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testEncontrarJugador() {
        try {
            Jugador j = ControladorJugadores.getInstancia().encontrarJugador(9).toModelo();
            System.out.println(j.getNombre());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByDocumento() {
        try {
            JugadorVO j = ControladorJugadores.getInstancia().getJugadorByDocumento(28754213, "DNI");
            System.out.println(j.getNombre());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByNombre() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadorByNombre("Diego Alberto", "Milito");
            for (JugadorVO j : jugadores)
                System.out.println(j.getNombre() + " " + j.getApellido());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByCategoria() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadoresByCategoria(78);
            for (JugadorVO j : jugadores)
                System.out.println(j.getNombre() + " " + j.getCategoria());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }


    public void testModificarDireccion() {
        try {
            ControladorJugadores.getInstancia().modificarDireccion(1, "Su casa siempre sera la 22 (modificado)");
            Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1).toModelo();
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getDireccion());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarMail() {
        try {
            ControladorJugadores.getInstancia().modificarMail(1, "elprincipe@mail.com");
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getMail());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarTelefono() {
        try {
            ControladorJugadores.getInstancia().modificarTelefono(1, "222222222");
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getTelefono());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarEstado() {
        try {
            ControladorJugadores.getInstancia().modificarEstado(1);
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).isEstado());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetStatsByCampeonato() {
        try {
            StatsVO a = ControladorJugadores.getInstancia().getStatsByCampeonato(15, 1);
            System.out.println(a.getIdJugador());
            System.out.println(a.getNombreJugador());
            System.out.println(a.getApellido());
            System.out.println(a.getIdClub());
            System.out.println(a.getNombreClub());
            System.out.println(a.getIdCampeonato());
            System.out.println(a.getDescripcion());
            System.out.println(a.getCantJugados());
            System.out.println(a.getCantGoles());
            System.out.println(a.getCantAmarillas());
            System.out.println(a.getCantRojas());
        } catch (JugadorException | CampeonatoException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testperteneceAlClub() {
        try {
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(1).toModelo(), 2));
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(2).toModelo(), -1));
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(3).toModelo(), 1));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testgetJugadoresHabilitadosCategoriaClub() {
        try {
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(1, 20));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(2, 30));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(3, 40));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetStatsByClub() {
        try {
            StatsVO a = ControladorJugadores.getInstancia().getStatsByClub(15, 1);
            System.out.println(a.getIdJugador());
            System.out.println(a.getNombreJugador());
            System.out.println(a.getApellido());
            System.out.println(a.getIdClub());
            System.out.println(a.getNombreClub());
            System.out.println(a.getCantJugados());
            System.out.println(a.getCantGoles());
            System.out.println(a.getCantAmarillas());
            System.out.println(a.getCantRojas());
        } catch (JugadorException | ClubException | PartidoException e) {
            System.out.println(e.getMessage());
        }

    }
}
