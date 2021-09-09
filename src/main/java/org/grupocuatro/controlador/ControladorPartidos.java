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

import java.time.LocalDate;

public class ControladorPartidos {
    private static ControladorPartidos instancia;
    private ControladorPartidos(){}

    public static ControladorPartidos getInstancia(){
        if(instancia == null)
            instancia = new ControladorPartidos();
        return instancia;
    }

    //FIXME actualizar tabla de goles, faltas y tabla posicion

    public Integer crearPartido(int nroFecha, int nroZona, int categoria, int idClubLocal, int idClubVisitante, LocalDate fecha, int idCampeonato) throws PartidoException {
        try {
            Campeonato c = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            try {
                Club local = ClubDao.getInstancia().getClubById(idClubLocal);
                Club visitante = ClubDao.getInstancia().getClubById(idClubVisitante);
                Partido p = new Partido(nroFecha, nroZona, categoria, local, visitante, fecha, c);
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

    public Partido encontrar_partido(int idPartido){//tiene q estar en el controlador y no aca
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try{
            partido = partidodao.getInstancia().getPartidoById(idPartido);
            return partido;
        } catch (PartidoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cargarResultadoPartido(int idPartido) {
        try {
            ControladorGoles cont = ControladorGoles.getInstancia();

            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);
            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = cont.contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = cont.contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);
        } catch (PartidoException e) {

            System.out.println(e.getMessage());
        }
    }

    public void validadoPorClubLocal (Integer idClubL, Integer idPartido){
        try{
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if(idClubL == partido.getClubLocal().getIdClub()){
                partido.setConvalidaLocal();
                partido.update();
            }else{
                System.out.println("El club ingresado no corresponde al club local");
            }

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }
    public void validadoPorClubVisitante (Integer idClubL, Integer idPartido){
        try{
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if(idClubL == partido.getClubVisitante().getIdClub()){
                partido.setConvalidaVisitante();
                partido.update();
            }else{
                System.out.println("El club ingresado no corresponde al club visitante");
            }

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }


}
