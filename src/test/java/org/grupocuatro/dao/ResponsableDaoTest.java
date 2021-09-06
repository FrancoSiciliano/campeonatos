package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;

import java.util.List;

public class ResponsableDaoTest extends TestCase {

    public void testGetResponsables() {
        try {
            List<Responsable> responsables = ResponsableDao.getInstancia().getResponsables();
            System.out.println(responsables);
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetResponsablesByClub() {
        try {
            List<Responsable> responsables = ResponsableDao.getInstancia().getResponsablesByClub(1);
            System.out.println(responsables);
            List<Responsable> responsables1 = ResponsableDao.getInstancia().getResponsablesByClub(2);
            System.out.println(responsables1);
            List<Responsable> responsables2 = ResponsableDao.getInstancia().getResponsablesByClub(4);
            System.out.println(responsables2);
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetResponsable() {
        try {
            Responsable responsable = ResponsableDao.getInstancia().getResponsable(1);
            System.out.println(responsable);
            Responsable responsable1 = ResponsableDao.getInstancia().getResponsable(2);
            System.out.println(responsable1);
            Responsable responsable2 = ResponsableDao.getInstancia().getResponsable(6);
            System.out.println(responsable2);
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetResponsableByNroDocAndClub(){
        try{
            System.out.println(ResponsableDao.getInstancia().getResponsableByNroDocAndClub("DNI",1));
            System.out.println(ResponsableDao.getInstancia().getResponsableByNroDocAndClub("DNI",32));
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }
}