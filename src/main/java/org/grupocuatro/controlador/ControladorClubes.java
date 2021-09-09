package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Club;

import java.util.List;

public class ControladorClubes {
    private static ControladorClubes instancia;

    private ControladorClubes() {
    }

    public static ControladorClubes getInstancia() {
        if (instancia == null)
            instancia = new ControladorClubes();
        return instancia;
    }

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
            System.out.print(e.getMessage());
        }
    }

    public List<Club> getClubesCategoria (Integer categoria){
        try{
            return ClubDao.getInstancia().getClubesCategoria(categoria);
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
