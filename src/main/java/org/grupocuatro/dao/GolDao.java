package org.grupocuatro.dao;

import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.modelo.Jugador;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class GolDao extends AbstractDao {

    private static GolDao instancia;

    private GolDao() {
    }

    public static GolDao getInstancia() {
        if (instancia == null) instancia = new GolDao();
        return instancia;
    }

    public List<Gol> getGolesByPartido(Integer idPartido) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido).getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("No hubo goles en el partido de id: " + idPartido);
    }

    public List<Gol> getGolesByPartidoAndClub(Integer idPartido, Integer idClubAContar, Integer idClubRival) throws GolException {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Gol> cq = cb.createQuery(Gol.class);
        Root<Gol> r = cq.from(Gol.class);
        Join<Gol, Jugador> jgj = r.join("jugador", JoinType.INNER);
        Predicate p4 = cb.equal(r.get("partido"), idPartido);
        Predicate p5 = cb.and(cb.equal(jgj.get("club"), idClubAContar), cb.equal(r.get("tipo"), "a favor"));
        Predicate p6 = cb.and(cb.equal(jgj.get("club"), idClubRival), cb.equal(r.get("tipo"), "en contra"));
        Predicate pFinal = cb.or(p5, p6);
        cq.where(cb.and(p4, pFinal));
        Query query = getEntityManager().createQuery(cq);
        List<Gol> goles = query.getResultList();
        return goles;
    }

    public List<Gol> getGolesByPartidoAndSentido(Integer idPartido, String sentido) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido + " and sentido = '" + sentido + "'").getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("No hubo goles " + sentido + " en el partido de id: " + idPartido);
    }

    public List<Gol> getGolesByJugadorAndPartido(Integer idPartido, Integer idJugador) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idPartido = " + idPartido + " and idJugador = '" + idJugador + "' and sentido = 'a favor' ").getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("El jugador de id:  " + idJugador + " no realizó goles en el partido de id: " + idPartido);
    }

    public List<Gol> getGolesByJugador(Integer idJugador) throws GolException {
        List<Gol> goles = getEntityManager().createQuery("FROM Gol WHERE idJugador = " + idJugador).getResultList();
        if (!goles.isEmpty()) return goles;
        throw new GolException("El jugador de id: " + idJugador + " no realizó goles");
    }

    public Gol getGolById(Integer id) throws GolException {
        try {
            return (Gol) getEntityManager().createQuery("FROM Gol WHERE idGol = " + id).getSingleResult();
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
