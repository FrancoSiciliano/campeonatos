package org.grupocuatro.dao;

import excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDao extends AbstractDao {

    private static PartidoDao instancia;
    private PartidoDao() {}

    public static PartidoDao getInstance() {
        if (instancia == null) {
            instancia = new PartidoDao();
        }
        return instancia;
    }

    public void grabarPartido(Partido partido) {
        this.save(partido);
    }

    public Campeonato getCampeonato(Integer idCampeonato) {
        Campeonato campeonato = (Campeonato) getEntityManager().createQuery("from Partido e where e.idCampeonato =" + idCampeonato);
        if (campeonato != null) {
            return campeonato;
        }
        throw new CampeonatoException("No hay un campeonato con el Id " + idCampeonato);
    }


    public List<Partido> getAllPartidos() {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido").getResultList();
        return partidos;
    }

    public Partido getPartidoId(Integer idPartido) throws PartidoException {
        Partido partido = (Partido) getEntityManager().createQuery("from Partido e where e.idPartido =" + idPartido);
        if (partido != null) {
            return partido;
        }
        throw new PartidoException("No hay un partido con el Id " + idPartido);
    }

    public List<Partido> getPartidosByCategoria(int categoria) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido e where e.categoria =" + categoria).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByNroFecha(int nroFecha) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido e where e.nroFecha =" + nroFecha).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByNroZona(int nroZona) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido e where e.nroZona =" + nroZona).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByClubLocal(int idClub) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido e where e.idClubLocal =" + idClub).getResultList();
        return partidos;
    }

    public List<Partido> getPartidosByClubVisitante(int idClub) {
        List<Partido> partidos = new ArrayList<>();
        partidos = (List<Partido>) getEntityManager().createQuery("from Partido e where e.idClubVisitante =" + idClub).getResultList();
        return partidos;
    }


    public Club getClubLocal(Integer idClub) throws PartidoException {
        Club club = (Club) getEntityManager().createQuery("from Partido e where e.idClubLocal =" + idClub);
        if (club != null) {
            return club;
        }
        throw new PartidoException("No hay un club visitante con el Id " + idClub);
    }

    public Club getClubVisitante(Integer idClub) throws PartidoException {
        Club club = (Club) getEntityManager().createQuery("from Partido e where e.idClubVisitante =" + idClub);
        if (club != null) {
            return club;
        }
        throw new PartidoException("No hay un club visitante con el Id " + idClub);
    }
}