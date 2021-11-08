package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

import java.util.List;

public class ControladorResponsablesTest extends TestCase {


    public void testCrearResponsable() {
        try {
            ControladorResponsables.getInstancia().crearResponsable(35754562, "Jorge", "Ameal", "jameal@mail.com", "1234",1);
            ControladorResponsables.getInstancia().crearResponsable(32457412, "Rodolfo", "Donofrio", "rdonofrio@mail.com", "river", 2);
            ControladorResponsables.getInstancia().crearResponsable(34852369, "Horacio", "Lopez", "hlopez@mail.com", "1234",3);
            ControladorResponsables.getInstancia().crearResponsable(35412789, "Rodolfo", "Mendez", "rmendez@mail.com", "1234" ,4);
            ControladorResponsables.getInstancia().crearResponsable(24478954, "Marcelo", "Tinelli", "mtinelli@mail.com", "sanlore", 5);
            ControladorResponsables.getInstancia().crearResponsable(21548796, "Daniel", "Pandolfi", "dpandolfi@mail.com", "1234", 6);
            ControladorResponsables.getInstancia().crearResponsable(25654789, "Lucía", "Barbuto", "lbarbuto@mail.com", "1234", 7);
            ControladorResponsables.getInstancia().crearResponsable(30214754, "Steven", "Zhang", "szhang@mail.com", "1234", 8);
            ControladorResponsables.getInstancia().crearResponsable(23545687, "Nasser", "Al-Khelaifi", "nkgelaifi@mail.com", "psg", 9);
            ControladorResponsables.getInstancia().crearResponsable(30254879, "Victor", "Blanco", "vblanco@mail.com", "laacademia", 10);
        } catch (ClubException | ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testValidarLogin() {
        System.out.println(ControladorResponsables.getInstancia().validarResponsable("jameal@mail.com", "1234"));
        System.out.println(ControladorResponsables.getInstancia().validarResponsable("jameal@mail.com", "password"));
    }

    public void testCambiarPassword() {
        try {
            ControladorResponsables.getInstancia().cambiarPassword(1, "nuevapassword");
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }


    public void testModificarResponsable() {
        try {
            ControladorResponsables.getInstancia().modificarResponsable(10, "Pablo Modificado", 2);
            System.out.println(ResponsableDao.getInstancia().getResponsable(10).getNombre());
        } catch (ResponsableException | ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetResponsable() {
        try {
            System.out.println(ControladorResponsables.getInstancia().getResponsable(1));
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetResponsableByNroDocumentoAndClub() {
        try {
            System.out.println(ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(35785412, 1));
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetResponsablesByClub() {
        try {
            System.out.println(ControladorResponsables.getInstancia().getResponsablesByClub(1));
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetResponsables() {
        try {
            System.out.println(ControladorResponsables.getInstancia().getResponsables());
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }

    }
}