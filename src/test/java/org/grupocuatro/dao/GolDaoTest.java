package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.GolException;

public class GolDaoTest extends TestCase {

    public void testGetGolesByPartido() {
        try {
            System.out.println(GolDao.getInstancia().getGolesByPartido(1));
            System.out.println(GolDao.getInstancia().getGolesByPartido(254));
            System.out.println(GolDao.getInstancia().getGolesByPartido(6));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetGolesByPartidoAndClub() {
        try {
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndClub(1,1,2));
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndClub(2,3,4));
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndClub(80,70,90));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetGolesByPartidoAndSentido() {
        try {
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndSentido(1,"a favor"));
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndSentido(254,"a favor"));
            System.out.println(GolDao.getInstancia().getGolesByPartidoAndSentido(6,"en contra"));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetGolesByJugadorAndPartido() {
        try {
            System.out.println(GolDao.getInstancia().getGolesByJugadorAndPartido(1,1));
            System.out.println(GolDao.getInstancia().getGolesByJugadorAndPartido(1,3));
            System.out.println(GolDao.getInstancia().getGolesByJugadorAndPartido(5,10));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetGolesByJugador() {
        try {
            System.out.println(GolDao.getInstancia().getGolesByJugador(1));
            System.out.println(GolDao.getInstancia().getGolesByJugador(2));
            System.out.println(GolDao.getInstancia().getGolesByJugador(6));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetGolById() {
        try {
            System.out.println(GolDao.getInstancia().getGolById(1));
            System.out.println(GolDao.getInstancia().getGolById(254));
            System.out.println(GolDao.getInstancia().getGolById(6));
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetGoles() {
        try {
            System.out.println(GolDao.getInstancia().getGoles());
        } catch (GolException e) {
            System.out.println(e.getMessage());
        }
    }
}