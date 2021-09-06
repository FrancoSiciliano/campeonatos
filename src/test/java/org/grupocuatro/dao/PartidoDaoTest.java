package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.modelo.Partido;

import java.util.List;

public class PartidoDaoTest extends TestCase {

    public void testGetAllPartidos() {
    }

    public void testGetPartidoId() {
    }

    public void testGetPartidosByCategoria() {
    }

    public void testGetPartidosByNroFecha() {
    }

    public void testGetPartidosByNroZona() {
    }

    public void testGetPartidosByClubLocal() {
        List<Partido> p = PartidoDao.getInstancia().getPartidosByClubLocal(1);
        for (Partido partido : p) {
            System.out.println(partido.getIdPartido());
        }
    }

    public void testGetPartidosByClubVisitante() {
    }
}