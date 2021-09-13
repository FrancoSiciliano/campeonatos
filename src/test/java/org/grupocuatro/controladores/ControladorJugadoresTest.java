package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Jugador;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.List;

public class ControladorJugadoresTest extends TestCase {

    public void testCrearJugador() {

            ControladorJugadores.getInstancia().agregarJugador("DNI", 31222222, "Diego Alberto", "Milito", 3, LocalDate.of(1979, 6, 12), "Su casa 22", "dmilito@mail.com", "123456789");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 28754213, "Ricardo Enrique", "Bochini", 4, LocalDate.of(1954, 1, 25), "Su casa 10", "rbochini@mail.com", "987654321");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31123456, "Juan Roman", "Riquelme", 1, LocalDate.of(1978, 6, 24), "Su casa 5", "rriquelme@mail.com", "123789456");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30458741, "Marcelo Daniel", "Gallardo", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "mgallardo@mail.com", "456123789");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35487541, "Sebastian Alberto", "Torrico", 5, LocalDate.of(1980, 2, 22), "Su casa 1", "storrico@mail.com", "852741963");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36875123, "Luis Angel", "Salmeron", 6, LocalDate.of(1982, 3, 18), "Su casa 9", "lsalmeron@mail.com", "258147369");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40528741, "James David", "Rodriguez", 7, LocalDate.of(1991, 7, 12), "Su casa 100", "jrodriguez@mail.com", "963741852");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37852136, "Washington Fernando", "Camacho", 8, LocalDate.of(1986, 4, 8), "Su casa 8", "wcamacho@mail.com", "546712893");

    }

    public void testGetJugadores() {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadores();
        for (Jugador j : jugadores)
            System.out.println(j.getNombre() + " " + j.getApellido() + " " + j.getCategoria());
    }

    public void testGetJugadoresByClub() {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByClub(3);
        for (Jugador j : jugadores)
            System.out.println(j.getNombre() + " " + j.getApellido());
    }

    public void testEncontrarJugador() {
        Jugador j = ControladorJugadores.getInstancia().encontrarJugador(9);
        if (j != null)
            System.out.println(j.getNombre());
    }

    public void testGetJugadorByDocumento() {
        Jugador j = ControladorJugadores.getInstancia().getJugadorByDocumento(28754213, "DNI");
        if (j != null)
            System.out.println(j.getNombre());
    }

    public void testGetJugadorByNombre() {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadorByNombre("Diego Alberto", "Milito");
        for (Jugador j : jugadores)
            System.out.println(j.getNombre() + " " + j.getApellido());
    }

    public void testGetJugadorByCategoria() {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByCategoria(78);
        for (Jugador j : jugadores)
            System.out.println(j.getNombre() + " " + j.getCategoria());
    }


    public void testModificarDireccion() {
        ControladorJugadores.getInstancia().modificarDireccion(1, "Su casa siempre sera la 22 (modificado)");
        Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1);
        if (j != null)
            System.out.println(j.getDireccion());
    }

    public void testModificarMail() {
        ControladorJugadores.getInstancia().modificarMail(1, "elprincipe@mail.com");
        Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1);
        if (j != null)
            System.out.println(j.getMail());
    }

    public void testModificarTelefono() {
        ControladorJugadores.getInstancia().modificarTelefono(1, "222222222");
        Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1);
        if (j != null)
            System.out.println(j.getTelefono());
    }

    public void testModificarEstado() {
        ControladorJugadores.getInstancia().modificarEstado(1);
        Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1);
        if (j != null)
            System.out.println(j.isEstado());
    }
}
