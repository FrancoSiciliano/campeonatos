package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.modelo.Campeonato;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class ControladorCampeonatosTest extends TestCase {

    public void testgetCampeonatos(){
        System.out.println(ControladorCampeonatos.getInstancia().getCampeonatos());
    }

    public void testdefinirTipoCampeonato() {
        ControladorCampeonatos.getInstancia().definirTipoCampeonato("Puntos",1);
        ControladorCampeonatos.getInstancia().definirTipoCampeonato("Zona",2);
        ControladorCampeonatos.getInstancia().definirTipoCampeonato("Zona",3);
        ControladorCampeonatos.getInstancia().definirTipoCampeonato("Puntos",6);
        ControladorCampeonatos.getInstancia().definirTipoCampeonato("Puntos",7);
    }

    public void testterminarCampeonato() {
        ControladorCampeonatos.getInstancia().terminarCampeonato(1);
        ControladorCampeonatos.getInstancia().terminarCampeonato(5);
        ControladorCampeonatos.getInstancia().terminarCampeonato(3);

    }

    public void testgetCampeonatosByEstado() {
        ControladorCampeonatos.getInstancia().getCampeonatosByEstado("Activo");
        ControladorCampeonatos.getInstancia().getCampeonatosByEstado("Inactivo");
        ControladorCampeonatos.getInstancia().getCampeonatosByEstado("asdasdasd");

    }

    public void testencontrarCampeonato() {
        ControladorCampeonatos.getInstancia().encontrarCampeonato(1);
        ControladorCampeonatos.getInstancia().encontrarCampeonato(3);
        ControladorCampeonatos.getInstancia().encontrarCampeonato(2);
        ControladorCampeonatos.getInstancia().encontrarCampeonato(17);
    }

    public void testagregarClubACampeonato() {
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(1,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(2,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(3,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(4,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(5,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(6,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(7,1);
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(8,1);
    }

    public void testgetCampeonatosByClub() {
        System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(1));
        System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(2));
        System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(3));
        System.out.println(ControladorCampeonatos.getInstancia().getCampeonatosByClub(7));

    }

    public void testCrearCampeonatos(){
        System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("SuperLiga", LocalDate.of(2020,9,10),LocalDate.of(2021,9,10),"Activo",78));
        System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Champions", LocalDate.of(2020,9,10),LocalDate.of(2021,9,10),"Activo",86));
        System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La Premier", LocalDate.of(2020,9,10),LocalDate.of(2021,9,10),"Activo",76));
        System.out.println(ControladorCampeonatos.getInstancia().crearCampeonato("La EuroCopa", LocalDate.of(2020,9,10),LocalDate.of(2021,9,10),"Activo",79));
    }
}
