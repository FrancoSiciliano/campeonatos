package org.grupocuatro.dao;

import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Jugador;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        throw new JugadorException("No existen jugadores con el nombre y apellido: " + nombre + " " + apellido);
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

    public List<Jugador> getJugadoresHabilitadosCategoriaClub(Integer club, int categoria) throws JugadorException {
        String qlString = "FROM Jugador WHERE categoria >= ?1 and estado = true and idClub = ?2 ";
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter(1, categoria);
        query.setParameter(2, club);
        List<Jugador> jugadores = query.getResultList();
        if (!jugadores.isEmpty()) return jugadores;
        throw new JugadorException("No existen jugadores en dicho club con categoria mayor o igual a " + categoria);

    }

    public boolean yaExisteJugador(int documento, String tipoDoc) {
        try {
            getEntityManager().createQuery("FROM Jugador WHERE numeroDocumento = " + documento + " AND tipoDocumento = " + tipoDoc);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public boolean validarJugador(String mail, String password) {
        try {
            getEntityManager().createQuery("FROM Jugador WHERE mail = '" + mail + "' AND password = '" + password + "'").getSingleResult();
            return true;
        } catch (NoResultException c){
            return false;
        }
    }

}
