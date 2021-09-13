package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.ClubException;

public class ClubDaoTest extends TestCase {

    public void testGetClubById() {
        try {
            System.out.println(ClubDao.getInstancia().getClubById(1));
            System.out.println(ClubDao.getInstancia().getClubById(15));
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetClubByNombre() {
        try {
            System.out.println(ClubDao.getInstancia().getClubByNombre("Deportivo Juguete"));
            System.out.println(ClubDao.getInstancia().getClubByNombre("Perez Fc"));
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetClubes() {
        try {
            System.out.println(ClubDao.getInstancia().getClubes());
        } catch (ClubException e){
            System.out.println(e.getMessage());
        }
    }
}