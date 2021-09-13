package org.grupocuatro.dao;

import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Jugador;

import javax.persistence.NoResultException;
import java.util.List;

public class JugadorDao extends AbstractDao {

    private static JugadorDao instancia;

    private JugadorDao() {
    }

    public static JugadorDao getInstancia() {
        if (instancia == null)
            instancia = new JugadorDao();
        return instancia;
    }

    public Jugador getJugadorById(Integer id) throws JugadorException {
        try {
            return (Jugador) getEntityManager().createQuery("FROM Jugador WHERE idJugador = " + id).getSingleResult();
        } catch (NoResultException e) {
            throw new JugadorException("No existe un jugador con id: " + id);
        }
    }

    public Jugador getJugadorByDocumento(Integer nroDocumento, String tipoDocumento) throws JugadorException {
        try {
            return (Jugador) getEntityManager().createQuery("FROM Jugador WHERE numeroDocumento = " + nroDocumento + " and tipoDocumento = '" + tipoDocumento + "'").getSingleResult();
        } catch (NoResultException e) {
            throw new JugadorException("No existe un jugador con " + tipoDocumento + " y numero: " + nroDocumento);
        }

    }

    public List<Jugador> getJugadorByNombre(String nombre, String apellido) throws JugadorException {
        List<Jugador> jugadores = getEntityManager().createQuery("FROM Jugador WHERE nombre = '" + nombre + "' AND apellido = '" + apellido + "'").getResultList();
        if (!jugadores.isEmpty())
            return jugadores;
        throw new JugadorException("No existen jugadores con el nombre " + nombre + " " + apellido);
    }

    public List<Jugador> getJugadores() throws JugadorException {
        List<Jugador> jugadores = getEntityManager().createQuery("SELECT j FROM Jugador j").getResultList();
        if (!jugadores.isEmpty())
            return jugadores;
        throw new JugadorException("No existen jugadores");
    }

    public List<Jugador> getJugadoresByClub(Integer club) throws JugadorException {
        List<Jugador> jugadores = getEntityManager().createQuery("FROM Jugador WHERE idClub = " + club).getResultList();
        if (!jugadores.isEmpty())
            return jugadores;
        throw new JugadorException("No existen jugadores para el club con id: " + club);
    }

    public List<Jugador> getJugadoresByCategoria(int categoria) throws JugadorException {
        List<Jugador> jugadores = getEntityManager().createQuery("FROM Jugador WHERE categoria = " + categoria).getResultList();
        if (!jugadores.isEmpty())
            return jugadores;
        throw new JugadorException("No existen jugadores para la categoria: " + categoria);
    }
}
