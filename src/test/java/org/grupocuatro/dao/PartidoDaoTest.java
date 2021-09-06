package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PartidoDaoTest extends TestCase {

    public void testGetAllPartidos() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getAllPartidos();
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidoId() {
        try {
            Partido partido = PartidoDao.getInstancia().getPartidoById(1);
            System.out.println(partido);
            Partido partido1 = PartidoDao.getInstancia().getPartidoById(2);
            System.out.println(partido1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByCategoria() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByCategoria(21);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByCategoria(31);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByNroFecha() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByNroFecha(1);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByNroFecha(2);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByNroZona() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByNroZona(2);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByNroZona(2);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByClubLocal() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByClubLocal(1);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByClubLocal(2);
            System.out.println(partidos1);
            List<Partido> partidos2 = PartidoDao.getInstancia().getPartidosByClubLocal(3);
            System.out.println(partidos2);

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByClubVisitante() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByClubVisitante(2);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByClubVisitante(1);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }
}