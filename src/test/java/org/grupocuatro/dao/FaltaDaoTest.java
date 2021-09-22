package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.FaltaException;

public class FaltaDaoTest extends TestCase {

    public void testGetFaltas() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltas());
        }catch (FaltaException f){
            System.out.print(f.getMessage());
        }
    }

    public void testGetFaltaById() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltaById(1));
            System.out.println(FaltaDao.getInstancia().getFaltaById(65));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugador() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugador(1));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugador(3));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByCampeonato() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByCampeonato(1));
            System.out.println(FaltaDao.getInstancia().getFaltasByCampeonato(100));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByPartido() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByPartido(1));
            System.out.println(FaltaDao.getInstancia().getFaltasByPartido(13));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByTipo() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByTipo("roja"));
            System.out.println(FaltaDao.getInstancia().getFaltasByTipo("violeta"));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugadorAndPartido() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndPartido(1,1));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndPartido(5,3));

        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugadorAndTipo() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndTipo(1,"falta"));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndTipo(1,"amarilla"));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugadorAndCampeonato() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndCampeonato(1,1));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndCampeonato(1,3));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByJugadorAndTipoAndPartido() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(1,"roja",1));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(1,"amarilla",1));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testGetFaltasByJugadorAndPartidoAndTipoAndCampeonato() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndPartidoAndTipo(1,1,"roja"));
            System.out.println(FaltaDao.getInstancia().getFaltasByJugadorAndPartidoAndTipo(1,1,"amarilla"));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetFaltasByPartidoAndTipo() {
        try{
            System.out.println(FaltaDao.getInstancia().getFaltasByPartidoAndTipo(1, "roja"));
            System.out.println(FaltaDao.getInstancia().getFaltasByPartidoAndTipo(3, "roja"));
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
    }
}