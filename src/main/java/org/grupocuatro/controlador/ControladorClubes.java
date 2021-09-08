package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Club;

public class ControladorClubes {
    public void crearClub(Integer id, String nombre, String direccion) {
        try {
            Club club = ClubDao.getInstancia().getClubById(id);
        } catch (ClubException e) {
            Club c = new Club(id, nombre, direccion);
            c.save();
        }
    }

    public void modificarClub(String nombre, String direccion) {
        ClubDao dao = ClubDao.getInstancia();
        Club club = null;
        try {
            club = dao.getClubByNombre(nombre);
            club.setNombre(nombre);
            club.setDireccion(direccion);
            club.update();

        } catch (ClubException e) {
            System.out.printf(e.getMessage());
        }
    }

}
