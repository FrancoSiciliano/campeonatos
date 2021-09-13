package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.TablaPosicionException;

public class TablaPosicionDaoTest extends TestCase {

    public void testGetTablaPosicionesByClub() {
        try {
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByClub(1));
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByClub(8));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetTablaPosicionesByClubAndCampeonato() {
        try {
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(2, 1));
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(1, 3));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetTablaPosicionesByCampeonato() {
        try {
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByCampeonato(1));
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByCampeonato(3));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetTablaPosicionesByPuntos() {
        try {
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByPuntos(1));
            System.out.println(TablaPosicionDao.getInstancia().getTablaPosicionesByPuntos(3));
        } catch (TablaPosicionException e) {
            System.out.println(e.getMessage());
        }
    }

}