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
            ControladorResponsables.getInstancia().crearResponsable(35754562, "Jorge Ameal", 1);
            ControladorResponsables.getInstancia().crearResponsable(32457412, "Rodolfo Donofrio", 2);
            ControladorResponsables.getInstancia().crearResponsable(34852369, "Horacio Lopez", 3);
            ControladorResponsables.getInstancia().crearResponsable(35412789, "Rodolfo Mendez", 4);
            ControladorResponsables.getInstancia().crearResponsable(24478954, "Marcelo Tinelli", 5);
            ControladorResponsables.getInstancia().crearResponsable(21548796, "Daniel Pandolfi", 6);
            ControladorResponsables.getInstancia().crearResponsable(25654789, "Lucía Barbuto", 7);
            ControladorResponsables.getInstancia().crearResponsable(30214754, "Steven Zhang", 8);
            ControladorResponsables.getInstancia().crearResponsable(23545687, "Nasser Al-Khelaifi", 9);
            ControladorResponsables.getInstancia().crearResponsable(30254879, "Victor Blanco", 10);
        } catch (ClubException | ResponsableException e) {
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