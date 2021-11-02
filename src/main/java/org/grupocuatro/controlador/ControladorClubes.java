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

    private ControladorClubes() {
    }

    public static ControladorClubes getInstancia() {
        if (instancia == null)
            instancia = new ControladorClubes();
        return instancia;
    }

    public void crearClub(Integer id, String nombre, String direccion) throws ClubException {
        Club c;

        if (!ClubDao.getInstancia().yaExisteElClub(id)) {
            c = new Club(id, nombre, direccion);
            c.save();

        } else {
            throw new ClubException("Ya existe el club con id: " + id);
        }

    }

    public void modificarClub(Integer idClub, String nombre, String direccion) throws ClubException {
        ClubDao dao = ClubDao.getInstancia();

        Club club = dao.getClubById(idClub);
        club.setNombre(nombre);
        club.setDireccion(direccion);
        club.update();

    }

    public ClubVO getClubById(Integer idClub) throws ClubException {
        return ClubDao.getInstancia().getClubById(idClub).toVO();

    }

    public List<ClubVO> getClubes() throws ClubException {
        return transformarAListaVO(ClubDao.getInstancia().getClubes());

    }

    public List<ClubVO> getClubesByCampeonato(Integer idCampeonato) throws ClubesCampeonatoException {
        return transformarAListaVO(ClubesCampeonatoDao.getInstancia().getClubesEnCampeonato(idCampeonato));

    }


    public List<ClubVO> getClubesHabiltadosPorCategoria(int categoria) throws ClubException {
        return transformarAListaVO(ClubDao.getInstancia().getClubesHabilitadosPorCategoria(categoria));

    }

    private List<ClubVO> transformarAListaVO(List<Club> listaClubes) {
        List<ClubVO> clubesVO = new ArrayList<>();
        for (Club club : listaClubes) {
            clubesVO.add(club.toVO());
        }
        return clubesVO;
    }

}
