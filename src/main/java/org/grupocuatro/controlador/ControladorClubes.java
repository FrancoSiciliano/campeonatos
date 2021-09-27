package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.vo.ClubVO;

import java.util.ArrayList;
import java.util.List;

public class ControladorClubes {
    private static ControladorClubes instancia;

    private List<ClubVO> transformarAListaVO(List<Club> listaClubes){
        List<ClubVO> clubesVO = new ArrayList<>();
        for(Club club:listaClubes){
            clubesVO.add(club.toVO());
        }
        return clubesVO;
    }

    private ControladorClubes() {
    }

    public static ControladorClubes getInstancia() {
        if (instancia == null)
            instancia = new ControladorClubes();
        return instancia;
    }

    public void crearClub(Integer id, String nombre, String direccion) {
        Club c;
        try {
            ClubDao.getInstancia().getClubById(id);
            System.out.println("Ya existe un club con ese ID");
        } catch (ClubException e) {
            c = new Club(id, nombre, direccion);
            c.save();
        }
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

    public ClubVO getClubById(Integer idClub) {
        try {
            return ClubDao.getInstancia().getClubById(idClub).toVO();
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<ClubVO> getClubes() {
        try {
            return transformarAListaVO(ClubDao.getInstancia().getClubes());
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<ClubVO> getClubesByCampeonato(Integer idCampeonato) {
        try {
            return transformarAListaVO(ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(idCampeonato));
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public List<ClubVO> getClubesHabiltadosPorCategoria(int categoria) {
        try {
            return transformarAListaVO(ClubDao.getInstancia().getClubesHabilitadosPorCategoria(categoria));
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
