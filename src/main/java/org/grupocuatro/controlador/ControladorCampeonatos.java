package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;
import static java.time.temporal.ChronoUnit.DAYS;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.ClubesCampeonato;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.List;

public class ControladorCampeonatos {
    private static ControladorCampeonatos instancia;

    private ControladorCampeonatos(){}

    public static ControladorCampeonatos getInstancia(){
        if(instancia == null)
            instancia = new ControladorCampeonatos();
        return instancia;
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado, Integer categoria) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, estado, categoria);
        nuevoCampeonato.save();
        return nuevoCampeonato.getIdCampeonato();
    }

    //FIXME AGREGAR METODO AGREGARCLUBALCAMPEONATO
    public void agregarClubCampeonato(Integer idClub, Integer idCampeonato){
        try{
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            Club club = ClubDao.getInstancia().getClubById(idClub);

            ClubesCampeonato nuevocc = new ClubesCampeonato(club,campeonato);
            nuevocc.save();

        } catch (CampeonatoException | ClubException e) {
            System.out.println(e.getMessage());
        }

    }

    //FIXME AGREGAR METODO DEFINIRTIPOCAMPEONATOYPARTIDOS
    public void definirTipoCampeonatoyCargarPartidos (Integer idCampeonato, Integer categoriaCampeonato, String tipo) {
        try{
            Campeonato camp = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            camp.setTipoCampeonato(tipo);

            LocalDate inicio = camp.getFechaInicio();
            LocalDate fin = camp.getFechaFin();
            long dias = DAYS.between(inicio, fin);

            List<Club> lista = ControladorClubes.getInstancia().getClubesCategoria(categoriaCampeonato);
            if(camp.getTipoCampeonato().toLowerCase().replace(" ", "") == "puntos"){
                cargarPartidosCampPuntos(dias,lista);
            }else if (camp.getTipoCampeonato().toLowerCase().replace(" ", "") == "zonas"){
                cargarPartidoCampZonas(dias,lista);
            }
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cargarPartidosCampPuntos(long diasDuracion, List<Club> lista){
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int cantEquipos = lista.size();
        int cantPartidosJugar = cantEquipos * (cantEquipos-1);
        int cantPartidosSimult = cantEquipos/2;



    }
    private void cargarPartidoCampZonas(long diasDuracion, List<Club> lista){
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();

        //FIXME TERMINAR METODO
    }

    public void terminarCampeonato(Integer id) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(id);
            campeonato.setEstado("inactivo");
            campeonato.update();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }
}
