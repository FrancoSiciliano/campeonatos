package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

public class ControladorPartidos {

    public Integer crearPartido(int nroFecha, int nroZona, int categoria, int idClubLocal, int idClubVisitante, int idCampeonato) throws PartidoException {
        try {
            Campeonato c = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            try {
                Club local = ClubDao.getInstancia().getClubById(idClubLocal);
                Club visitante = ClubDao.getInstancia().getClubById(idClubVisitante);
                Partido p = new Partido(nroFecha, nroZona, categoria, local, visitante, c);
                PartidoDao.getInstancia().save(p);
                return p.getIdPartido();
            } catch (ClubException e) {
                System.out.println(e.getMessage());
            }
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
        throw new PartidoException("No se pudo agregar el partido");
    }

    public void cargarResultadoPartido(int idPartido) {
        try {
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);
            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);
        } catch (PartidoException e) {

            System.out.println(e.getMessage());
        }
    }
    //FIXME AGREGAR VALIDADOS
    //FIXME actualizar tabla de goles, faltas y tabla posicion
}
