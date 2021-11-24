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

    public Integer crearResponsable(Integer documento, String nombre, String apellido, String mail, String password, Integer idClub) throws ClubException, ResponsableException {
        Club c = ClubDao.getInstancia().getClubById(idClub);
        if (ResponsableDao.getInstancia().existeResponsableEnClub(documento, idClub)) {
            throw new ResponsableException("Ya existe el responsable de DNI " + documento + " en el club de id " + idClub);
        } else {
            Responsable r = new Responsable(documento, nombre, apellido, null, mail, password);
            c.asignarResponsable(r);
            return r.getLegajo();
        }
    }

    public Integer loginResponsable(String mail, String password) throws ResponsableException {
        return ResponsableDao.getInstancia().validarResponsable(mail, password);
    }

    public void cambiarPassword(Integer idResponsable, String password) throws ResponsableException {
        Responsable r = ResponsableDao.getInstancia().getResponsable(idResponsable);
        r.setPassword(password);
        r.update();
    }

    public void modificarResponsable(Integer legajoResponsable, String nombre, Integer idClub, String mail, String password) throws ResponsableException, ClubException {
        Club c = ClubDao.getInstancia().getClubById(idClub);
        Responsable r = ResponsableDao.getInstancia().getResponsable(legajoResponsable);
        r.setClub(c);
        r.setNombre(nombre);
        r.setMail(mail);
        r.setPassword(password);
        r.update();

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

    public boolean existeMailResponsable(String mail) {
        return ResponsableDao.getInstancia().existeMailResponsable(mail);
    }
}
