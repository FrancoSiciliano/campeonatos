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

    public void testCrearCampeonatos() {
        try {
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("SuperLiga", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Champions", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
            System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Premier", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 9, 10), "activo"));
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testagregarClubACampeonato() {
        try {
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(1, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(2, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(3, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(4, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(5, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(6, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(7, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(8, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(9, 1);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(10, 1);

            ControladorCampeonatos.getInstancia().agregarClubACampeonato(1, 2);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(2, 2);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(3, 2);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(4, 2);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(5, 2);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(6, 2);

            ControladorCampeonatos.getInstancia().agregarClubACampeonato(7, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(8, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(9, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(10, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(1, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(2, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(3, 3);
            ControladorCampeonatos.getInstancia().agregarClubACampeonato(4, 3);

        } catch (CampeonatoException | ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testdefinirTipoCampeonatoAndCategoria() {
        try {
            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(0, 1, 90);
            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(2, 2, 90);
            ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(4, 3, 90);
        } catch (ClubesCampeonatoException | PartidoException | CampeonatoException | ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testterminarCampeonato() {
        try {
            ControladorCampeonatos.getInstancia().terminarCampeonato(1);
            ControladorCampeonatos.getInstancia().terminarCampeonato(2);
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


}
