package org.grupocuatro.dao;

import junit.framework.TestCase;
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
            System.out.println((JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(1, 1, 1)));
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(2, 10,1);
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(3, 85, 1);
            JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(4, 90, 1);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }
}