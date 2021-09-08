package org.grupocuatro.controlador;

import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.ResponsableDao;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Responsable;

public class ControladorResponsables {
    //FIXME HACER SINGLETONIANO

    public Integer crearResponsable(String documento, String nombre, Integer idClub) throws ResponsableException {
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
        throw new ResponsableException("No se pudo crear el responsable solicitado");

    }
    public void modificarResponsable(Integer legajoResponsable, String documento, String nombre, Integer idClub) {
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
}
