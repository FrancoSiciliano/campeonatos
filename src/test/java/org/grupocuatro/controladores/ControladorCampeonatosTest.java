package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;

import java.time.LocalDate;

public class ControladorCampeonatosTest extends TestCase {

    public void testgetCampeonatos() {
        try {
            System.out.println(ControladorCampeonatos.getInstancia().getCampeonatos());
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testdefinirTipoCampeonatoAndCategoria() {
        try {
            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(0, 6, 90);
//            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(2, 2, 90);
//            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(4, 3, 90);
//            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(0, 4, 90);
//            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(4, 6, 90);

        } catch (ClubesCampeonatoException | PartidoException | CampeonatoException | ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testterminarCampeonato() {
        try {
            ControladorCampeonatos.getInstancia().terminarCampeonato(1);
            ControladorCampeonatos.getInstancia().terminarCampeonato(5);
            ControladorCampeonatos.getInstancia().terminarCampeonato(3);
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testgetCampeonatosByEstado() {
        try {
            ControladorCampeonatos.getInstancia().getCampeonatosByEstado("activo");
            ControladorCampeonatos.getInstancia().getCampeonatosByEstado("inactivo");
            ControladorCampeonatos.getInstancia().getCampeonatosByEstado("estadofalso");
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }


    }

    public void testencontrarCampeonato() {
        try {
            ControladorCampeonatos.getInstancia().encontrarCampeonato(1);
            ControladorCampeonatos.getInstancia().encontrarCampeonato(3);
            ControladorCampeonatos.getInstancia().encontrarCampeonato(2);
            ControladorCampeonatos.getInstancia().encontrarCampeonato(17);
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testagregarClubACampeonato() {

        try {
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(1, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(2, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(3, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(4, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(5, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(6, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(7, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(8, 6);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(1, 4);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(2, 4);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(3, 4);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(4, 4);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(5, 4);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(8, 3);
        } catch (CampeonatoException | ClubException | ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testgetCampeonatosByClub() {
        try {
            System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(1));
            System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(2));
            System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(3));
            System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(7));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testCrearCampeonatos() {
        try {
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("SuperLiga", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Champions", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Premier", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La EuroCopa", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("Campeonato Seis Clubes 222", LocalDate.of(2021, 9, 30), LocalDate.of(2021, 10, 30), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("Campeonato Ocho CON ZONAS INVALIDAS", LocalDate.of(2027, 9, 30), LocalDate.of(2027, 10, 30), "activo"));

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }
}
