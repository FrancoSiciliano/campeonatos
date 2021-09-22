package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.JugadorException;

public class JugadorDaoTest extends TestCase {

    public void testGetJugadorByID() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadorById(1));
            System.out.println(JugadorDao.getInstancia().getJugadorById(10));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByDocumento() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadorByDocumento(12345678, "DNI"));
            System.out.println(JugadorDao.getInstancia().getJugadorByDocumento(2, "DNI"));
            System.out.println(JugadorDao.getInstancia().getJugadorByDocumento(12345678, "OLA"));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByNombre() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadorByNombre("Juan", "Perez"));
            System.out.println(JugadorDao.getInstancia().getJugadorByNombre("Juan", "Lopez"));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadores() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadores());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadoresByClub() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadoresByClub(1));
            System.out.println(JugadorDao.getInstancia().getJugadoresByClub(5));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadoresByCategoria() {
        try {
            System.out.println(JugadorDao.getInstancia().getJugadoresByCategoria(121));
            System.out.println(JugadorDao.getInstancia().getJugadoresByCategoria(122));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadoresHabilitadosCategoriaClub() {
        try {
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(2, 10);
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(1, 100);
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(3, 85);
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(4, 90);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }
}