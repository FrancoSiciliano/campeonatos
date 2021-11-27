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

    //TODO TESTEAR


    public void testGetPartidosByCampeonatoAndClub() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(1,1);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(1,6);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByClub() {
        try {
            List<Partido> partidos = PartidoDao.getInstancia().getPartidosByClub(1);
            System.out.println(partidos);
            List<Partido> partidos1 = PartidoDao.getInstancia().getPartidosByClub(5);
            System.out.println(partidos1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByCampeonato() {
        List<Partido> partidos = null;
        try {
            partidos = PartidoDao.getInstancia().getPartidosByCampeonato(2);
            System.out.println(partidos);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByNroFechaAndCampeonato(){
        List<Partido> partidos = null;
        try {
            System.out.println(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonato(2,2));
            System.out.println(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonato(100,2));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetPartidosByNroFechaAndCampeonatoAndClub(){
        List<Partido> partidos = null;
        try {
            System.out.println(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(2,2,1));
            System.out.println(PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(100,2,30));
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetUltimoPartidoByClubAndCampeonato () {
        try {
            Partido partido = PartidoDao.getInstancia().getUltimoPartidoByClubAndCampeonato(1,1,3);
            System.out.println(partido);
            Partido partido1 = PartidoDao.getInstancia().getUltimoPartidoByClubAndCampeonato(2,1,4);
            System.out.println(partido1);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFecha() throws PartidoException {
        System.out.println(PartidoDao.getInstancia().getUltimoNroFechaByCampeonato(2));
    }

}