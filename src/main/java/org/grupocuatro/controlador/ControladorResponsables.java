package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Responsable;
import org.grupocuatro.vo.ClubVO;
import org.grupocuatro.vo.ResponsableVO;

import java.util.ArrayList;
import java.util.List;

public class ControladorResponsables {

    private static ControladorResponsables instancia;

    private List<ResponsableVO> transformarAListaVO(List<Responsable> listaResponsables) {
        List<ResponsableVO> responsablesVO = new ArrayList<>();
        for (Responsable responsable : listaResponsables) {
            responsablesVO.add(responsable.toVO());
        }
        return responsablesVO;
    }

    private ControladorResponsables() {
    }

    public static ControladorResponsables getInstancia() {
        if (instancia == null) instancia = new ControladorResponsables();
        return instancia;
    }

    public Integer crearResponsable(Integer documento, String nombre, Integer idClub) {
        ResponsableDao dao = ResponsableDao.getInstancia();
        try {
            Club club = ClubDao.getInstancia().getClubById(idClub);
            try {
                dao.getResponsableByNroDocAndClub(documento, idClub);
                System.out.println("Ya existe el representante de DNI " + documento + " en el club " + idClub);
            } catch (ResponsableException e) {
                Responsable r = new Responsable(documento, nombre, club);
                r.save();
                return r.getLegajo();
            }
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("No se puede crear el representante");
        return null;
    }

    public void modificarResponsable(Integer legajoResponsable, Integer documento, String nombre, Integer idClub) {
        ResponsableDao dao = ResponsableDao.getInstancia();
        try {
            Responsable resp = dao.getResponsable(legajoResponsable);
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                resp.setClub(club);
                resp.setNombre(nombre);
                resp.setDocumento(documento);
                resp.update();
            } catch (ClubException c) {
                System.out.println(c.getMessage());
            }
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponsableVO getResponsable(Integer idResponsable) throws ResponsableException {
        return ResponsableDao.getInstancia().getResponsable(idResponsable).toVO();

    }

    public List<ResponsableVO> getResponsables() throws ResponsableException {
        return transformarAListaVO(ResponsableDao.getInstancia().getResponsables());

    }

    public ResponsableVO getResponsableByNroDocAndClub(Integer doc, Integer idClub) throws ResponsableException {
        return ResponsableDao.getInstancia().getResponsableByNroDocAndClub(doc, idClub).toVO();

    }

    public List<ResponsableVO> getResponsablesByClub(Integer idClub) throws ResponsableException {
        return transformarAListaVO(ResponsableDao.getInstancia().getResponsablesByClub(idClub));

    }
}
