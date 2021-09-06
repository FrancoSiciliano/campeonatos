package org.grupocuatro.dao;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoDao extends AbstractDao {

    private static PartidoDao instancia;
    private PartidoDao() {}

    public static PartidoDao getInstancia() {
        if (instancia == null) {
            instancia = new PartidoDao();
        }
        return instancia;
    }

    public List<Partido> getAllPartidos() {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido").getResultList();
        return partidos;
    }

    public Partido getPartidoById(Integer idPartido) throws PartidoException {
        Partido partido = (Partido) getEntityManager().createQuery("from Partido where idPartido =" + idPartido).getSingleResult();
        if (partido != null) {
            return partido;
        }
        throw new PartidoException("No hay un partido con el Id " + idPartido);
    }

    public List<Partido> getPartidosByCategoria(int categoria) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido where categoria =" + categoria).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByNroFecha(int nroFecha) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido where nroFecha =" + nroFecha).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByNroZona(int nroZona) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido where nroZona =" + nroZona).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByClubLocal(int idClub) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido where idClubLocal =" + idClub).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByClubVisitante(int idClub) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido where idClubVisitante =" + idClub).getResultList();
        return partidos;
    }
}