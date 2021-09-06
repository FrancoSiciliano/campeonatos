package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.CampeonatoException;

public class CampeonatoDaoTest extends TestCase {

    public void testGetCampeonato() {
        try {
            System.out.println(CampeonatoDao.getInstancia().getCampeonato(1));
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetCampeonatos() {
        try {
            System.out.println(CampeonatoDao.getInstancia().getCampeonatos());
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }
}