package org.grupocuatro.dao;

import junit.framework.TestCase;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Miembro;

import java.time.LocalDate;
import java.util.List;

public class MiembroDaoTest extends TestCase {

    public void testGetMiembroById() {
        try {
            Miembro miembro = MiembroDao.getInstancia().getMiembroById(1);
            System.out.println(miembro);
            Miembro miembro1 = MiembroDao.getInstancia().getMiembroById(2);
            System.out.println(miembro1);
            Miembro miembro2 = MiembroDao.getInstancia().getMiembroById(5);
            System.out.println(miembro2);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembros() {
        try {
            List<Miembro> miembros = MiembroDao.getInstancia().getMiembros();
            System.out.println(miembros);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembrosByClub() {
        try {
            List<Miembro> miembros = MiembroDao.getInstancia().getMiembrosByClub(1);
            System.out.println(miembros);
            List<Miembro> miembros1 = MiembroDao.getInstancia().getMiembrosByClub(2);
            System.out.println(miembros1);
            List<Miembro> miembros2 = MiembroDao.getInstancia().getMiembrosByClub(5);
            System.out.println(miembros2);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembrosByClubAndPartido() {
        try {
            List<Miembro> miembros = MiembroDao.getInstancia().getMiembrosByClubAndPartido(1,1);
            System.out.println(miembros);
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembrosByPartidoAndJugador() {
        try {
            Miembro miembros = MiembroDao.getInstancia().getMiembroByPartidoAndJugador(1,1);
            System.out.println(miembros);

        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembroByClubAndPartidoAndJugador() {
        try {
            Miembro miembros = MiembroDao.getInstancia().getMiembroByClubAndPartidoAndJugador(1,1,1);
            System.out.println(miembros);

        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetMiembroByJugadorAndFecha() {
        try {
            System.out.println(MiembroDao.getInstancia().getMiembroByJugadorAndFecha(1, LocalDate.now()));
            System.out.println(MiembroDao.getInstancia().getMiembroByJugadorAndFecha(2, LocalDate.now()));
            System.out.println(MiembroDao.getInstancia().getMiembroByJugadorAndFecha(3, LocalDate.now()));
        } catch (MiembroException e) {
            System.out.println(e.getMessage());
        }
    }
}