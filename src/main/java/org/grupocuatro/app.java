package org.grupocuatro;

import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.EntityManager;

public class app {
    public static void main(String[] args) throws JugadorException, PartidoException {
//        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println(ControladorJugadores.getInstancia().getJugadores());
        System.out.println(ControladorPartidos.getInstancia().getAllPartidos());
    }
}
