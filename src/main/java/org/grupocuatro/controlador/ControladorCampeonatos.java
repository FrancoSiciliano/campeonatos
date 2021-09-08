package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.modelo.Campeonato;

import java.time.LocalDate;

public class ControladorCampeonatos {
    //FIXME AGREGAR SINGLETON

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, "activo");
        nuevoCampeonato.save();
        return nuevoCampeonato.getIdCampeonato();
    }
    //FIXME AGREGAR METODO AGREGARCLUBALCAMPEONATO
    //FIXME AGREGAR METODO DEFINIRTIPOCAMPEONATOYPARTIDOS

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
