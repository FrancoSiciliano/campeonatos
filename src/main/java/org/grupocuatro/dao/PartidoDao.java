package org.grupocuatro.dao;

import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.modelo.Partido;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PartidoDao extends AbstractDao {

    private static PartidoDao instancia;

    private PartidoDao() {
    }

    public static PartidoDao getInstancia() {
        if (instancia == null) {
            instancia = new PartidoDao();
        }
        return instancia;
    }

    public List<Partido> getAllPartidos() throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido").getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No hay partidos");
    }

    public Partido getPartidoById(Integer idPartido) throws PartidoException {
        try {
            return (Partido) getEntityManager().createQuery("FROM Partido WHERE idPartido = " + idPartido).getSingleResult();
        } catch (NoResultException e) {
            throw new PartidoException("No hay un partido con el id: " + idPartido);
        }

    }

    public List<Partido> getPartidosByCampeonato(Integer idCampeonato) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos para el campeonato de id: " + idCampeonato);
    }

    public List<Partido> getPartidosByCategoria(int categoria) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE categoria =" + categoria).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la categoria: " + categoria);
    }

    public List<Partido> getPartidosByNroFechaAndCampeonato(Integer idCampeonato, int nroFecha) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroFecha =" + nroFecha + "and idCampeonato = " + idCampeonato).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la fecha " + nroFecha + " para el campeonato de id: " + idCampeonato);
    }

    public List<Partido> getPartidosByNroFechaAndCampeonatoAndClub(Integer idCampeonato, int nroFecha, int club) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroFecha =" + nroFecha + "and idCampeonato = " + idCampeonato + "and (idClubLocal = " + club + " or idClubVisitante = " + club + ")").getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la fecha " + nroFecha + " para el club de id: " + club + " en el campeonato de id: " + idCampeonato);
    }

    public List<Partido> getPartidosByNroZona(int nroZona) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroZona =" + nroZona).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la zona " + nroZona);
    }

    public List<Partido> getPartidosByClubLocal(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubLocal =" + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club local  " + idClub);
    }

    public List<Partido> getPartidosByClubVisitante(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubVisitante =" + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club visitante " + idClub);
    }

    public Partido getUltimoPartidoByClubAndCampeonato(Integer idClub, Integer idCampeonato, int nroFechaActual) throws PartidoException {
        String qlString = "FROM Partido WHERE (idClubLocal = ?1 or idClubVisitante = ?1) and idCampeonato = ?2 and nroFecha < ?3 ORDER BY nroFecha DESC";
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter(1, idClub);
        query.setParameter(2, idCampeonato);
        query.setParameter(3, nroFechaActual - 1);
        List<Partido> partidosAnteriores = query.getResultList();
        if (!partidosAnteriores.isEmpty()) return partidosAnteriores.get(0);
        throw new PartidoException("El equipo no jugo ningun partido aun");

    }

    public Integer getUltimoNroFechaByCampeonato(Integer campeonato) throws PartidoException {
        try {
            Integer integer = (Integer) getEntityManager().createQuery("SELECT MAX(nroFecha) FROM Partido WHERE idCampeonato = " + campeonato).getSingleResult();
            return integer;
        } catch (NoResultException e) {
            throw new PartidoException("No existen partidos para el campeonato " + campeonato);
        }

    }

    public List<Partido> getPartidosByCampeonatoAndClub(int idCampeonato, int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato =" + idCampeonato + " AND (idClubLocal = " + idClub + " OR idClubVisitante = " + idClub + ")").getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club de id: " + idClub + " en el campeonato de id:" + idCampeonato);
    }

    public List<Partido> getPartidosByClub(int idClub) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idClubLocal = " + idClub + " OR idClubVisitante = " + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos del club de id: " + idClub);
    }

    public boolean existePartido(int nroZona, int categoria, Integer idClubLocal, Integer idClubVisitante, Integer idCampeonato) { //se asume que los partidos despues de zonas tendran una zona nueva
        String qlString = "FROM Partido WHERE nroZona = ?1 AND categoria = ?2 AND idClubLocal = ?3 AND idClubVisitante = ?4 AND idCampeonato = ?5";
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter(1, nroZona);
        query.setParameter(2, categoria);
        query.setParameter(3, idClubLocal);
        query.setParameter(4, idClubVisitante);
        query.setParameter(5, idCampeonato);

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public List<Partido> getPartidosByCampeonatoAndNroZona(int nroZona, Integer idCampeonato) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE nroZona = " + nroZona + " AND idCampeonato = " + idCampeonato).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos en la zona " + nroZona);
    }

    public List<Partido> getPartidosByCampeonatoAndClubLocal(Integer idClub, Integer idCampeonato) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato + " AND idClubLocal = " + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos correspondientes al club local " + idClub + " en el campeonato " + idCampeonato);
    }

    public List<Partido> getPartidosByCampeonatoAndClubVisitante(Integer idClub, Integer idCampeonato) throws PartidoException {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato + " AND idClubVisitante = " + idClub).getResultList();
        if (!partidos.isEmpty()) return partidos;
        throw new PartidoException("No existen partidos correspondientes al club visitante " + idClub + " en el campeonato " + idCampeonato);
    }

    public int getCantPartidosByCampeonatoValidados(Integer idCampeonato) {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato + " AND validadoLocal = 1 AND validadoVisitante = 1").getResultList();
        if (!partidos.isEmpty()) return partidos.size();
        else return 0;
    }

    public int getCantPartidosByCampeonato(Integer idCampeonato) {
        List<Partido> partidos = getEntityManager().createQuery("FROM Partido WHERE idCampeonato = " + idCampeonato).getResultList();
        if (!partidos.isEmpty()) return partidos.size();
        else return 0;
    }

    public int getCantZonasCampeonato(Integer idCampeonato) throws PartidoException {
        try {
            return (int) getEntityManager().createQuery("SELECT MAX(nroZona) from Partido WHERE idCampeonato = " + idCampeonato).getSingleResult();
        } catch (NoResultException e) {
            throw new PartidoException("No existen zonas en las que el campeonato " + idCampeonato + " esta dividido");
        }
    }

    public int getZonaClubCampeonato(Integer idCampeonato, Integer idClub) throws PartidoException {
        try {
            return (int) getEntityManager().createQuery("SELECT nroZona FROM Partido WHERE idCampeonato = " + idCampeonato + " AND idClubLocal = " + idClub).getSingleResult();
        } catch (NoResultException e) {
            throw new PartidoException("No existe la zona para el club " + idClub + " en el campeonato " + idCampeonato);
        }
    }

    public List<Partido> getPartidosNoCargados() throws PartidoException {
        List<Partido> result = getEntityManager().createQuery("FROM Partido WHERE golesLocal is null AND golesVisitante is null ").getResultList();
        if (!result.isEmpty())
            return result;
        throw new PartidoException("No existen partidos a cargar");

    }
}