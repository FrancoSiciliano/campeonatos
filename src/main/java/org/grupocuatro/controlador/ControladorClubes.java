package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
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

    public void crearClub(Integer id, String nombre, String direccion) throws ClubException {

        Club c = null;

        try {
            ClubDao.getInstancia().getClubById(id);
        } catch (ClubException e) {
            c = new Club(id, nombre, direccion);
            c.save();
        }

        if (c == null) throw new ClubException("Ya existe un club con id: " + id);
    }

    public void modificarClub(Integer idClub, String nombre, String direccion) {
        ClubDao dao = ClubDao.getInstancia();
        try {
            Club club = dao.getClubById(idClub);
            club.setNombre(nombre);
            club.setDireccion(direccion);
            club.update();

        } catch (ClubException e) {
            System.out.print(e.getMessage());
        }
    }

    public Club getClubById(Integer idClub) {
        try {
            return ClubDao.getInstancia().getClubById(idClub);
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Club> getClubes() {
        try {
            return ClubDao.getInstancia().getClubes();
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Club> getClubesByCampeonato(Integer idCampeonato) {
        try {
            return ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(idCampeonato);
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Club> getClubesHabiltadosPorCategoria(int categoria) {
        try {
            return ClubDao.getInstancia().getClubesHabilitadosPorCategoria(categoria);
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
