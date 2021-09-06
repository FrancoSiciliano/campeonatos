package org.grupocuatro.dao;

import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Gol;

import javax.persistence.NoResultException;
import java.util.List;

public class GolDao extends AbstractDao {

    private static GolDao instancia;

    private GolDao() {
    }

    public static GolDao getInstancia() {
        if (instancia == null) instancia = new GolDao();
        return instancia;
    }

    public List<Gol> getGolesByPartido(int idPartido) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido).getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("No hubo goles en el partido " + idPartido);
    }

    public List<Gol> getGolesByPartidoAndSentido(int idPartido, String sentido) throws GolException {
        List<Gol> goles = (List<Gol>) getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido + " and sentido = '" + sentido + "'");
        if (!goles.isEmpty()) return goles;
        throw new GolException("No hubo goles " + sentido + " en el partido " + idPartido);
    }

    public List<Gol> getGolesByJugadorAndPartido(int idPartido, int idJugador) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido + " and idJugador = " + idJugador).getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("El jugador " + idJugador + " no realizó goles en el partido: " + idPartido);
    }

    public List<Gol> getGolesByJugador(int idJugador) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idJugador = " + idJugador).getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("El jugador " + idJugador + " no realizó goles");
    }

    public Gol getGolById(int id) throws GolException {
        try {
            Gol gol = (Gol) getEntityManager().createQuery("FROM Gol WHERE idGol = " + id).getSingleResult();
            return gol;
        } catch (NoResultException e) {
            throw new GolException("No existe un gol con id: " + id);
        }

    }

    public List<Gol> getGoles() throws GolException {
        List<Gol> goles = getEntityManager().createQuery("SELECT g FROM Gol g").getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("No existen goles");
    }
}
