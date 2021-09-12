package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.ClubesCampeonatoException;

public class ClubesCampeonatoDaoTest extends TestCase {

    public void testGetClubesEnCampeonato() {
        try {
            System.out.println(ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(1));
            System.out.println(ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(2));
            System.out.println(ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(254));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetCampeonatosClub() {
        try {
            System.out.println(ClubesCampeonatoDao.getInstancia().getCampeonatosClub(1));
            System.out.println(ClubesCampeonatoDao.getInstancia().getCampeonatosClub(14));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetClubCampeonato() {
        try {
            System.out.println(ClubesCampeonatoDao.getInstancia().getClubCampeonato(1, 2));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }
}