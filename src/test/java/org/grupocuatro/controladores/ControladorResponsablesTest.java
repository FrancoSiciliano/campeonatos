package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

import java.util.List;

public class ControladorResponsablesTest extends TestCase {


    public void testCrearResponsable() {
        try {
            ControladorResponsables.getInstancia().crearResponsable(35785412,"Jorge Perez", 1);
            ControladorResponsables.getInstancia().crearResponsable(34521879, "Gerardo Gonzalez", 2);
            ControladorResponsables.getInstancia().crearResponsable(34852369, "Horacio Lopez", 3);
            ControladorResponsables.getInstancia().crearResponsable(35412789, "Rodolfo Mendez", 4);
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarResponsable() {
        ControladorResponsables.getInstancia().modificarResponsable(1, 35785412, "Jorge Perez Modificado", 1);
        try {
            System.out.println(ResponsableDao.getInstancia().getResponsable(1).getNombre());
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetResponsable() {
        Responsable r = ControladorResponsables.getInstancia().getResponsable(1);
        if (r != null) System.out.println(r.getNombre());
    }

    public void testGetResponsableByNroDocumentoAndClub() {
        Responsable r = ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(35785412, 1);
        if (r != null) System.out.println(r.getNombre());
    }

    public void testGetResponsablesByClub() {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsablesByClub(1);
        System.out.println(responsables);
    }

    public void testGetResponsables() {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsables();
        System.out.println(responsables);
    }
}