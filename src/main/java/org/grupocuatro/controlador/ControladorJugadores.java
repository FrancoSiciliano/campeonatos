package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;
import org.grupocuatro.vo.JugadorCampeonatoVO;
import org.grupocuatro.vo.JugadorVO;
import org.grupocuatro.vo.StatsVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorJugadores {

    private static ControladorJugadores instancia;

    private ControladorJugadores() {
    }

    public static ControladorJugadores getInstancia() {
        if (instancia == null)
            instancia = new ControladorJugadores();
        return instancia;
    }

    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, Integer idClub, LocalDate fechaNacimiento, String direccion, String mail, String telefono, String password) throws ClubException, JugadorException {
        JugadorDao dao = JugadorDao.getInstancia();
        if (dao.yaExisteJugador(documento, tipoDocumento)) {
            Club club = ClubDao.getInstancia().getClubById(idClub);
            Jugador j = new Jugador(tipoDocumento, documento, nombre, apellido, null, fechaNacimiento, direccion, mail, telefono, password);
            club.agregarJugador(j);
            return j.getIdJugador();

        } else {
            throw new JugadorException("Ya existe un jugador con " + tipoDocumento + ": " + documento);
        }
    }

    public Integer loginJugador(String mail, String password) throws JugadorException {
        return JugadorDao.getInstancia().loginJugador(mail, password);
    }

    public void cambiarPassword(Integer idJugador, String password) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setPassword(password);
        j.update();
    }

    public void modificarDireccion(int idJugador, String direccion) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setDireccion(direccion);
        j.update();
    }

    public void modificarMail(int idJugador, String mail) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setMail(mail);
        j.update();
    }

    public void modificarTelefono(int idJugador, String telefono) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setTelefono(telefono);
        j.update();
    }

    public void modificarEstado(int idJugador) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setEstado(!j.isEstado());
        System.out.println(j);
        j.update();
    }

    public void modificarNombre(int idJugador, String nombre) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setNombre(nombre);
        j.update();
    }

    public void modificarApellido(int idJugador, String apellido) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setApellido(apellido);
        j.update();
    }

    public void modificarFechaNac(int idJugador, LocalDate fechaNac) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setFechaNacimiento(fechaNac);
        j.update();
    }

    public void modificarDocumento(int idJugador, int doc) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setDocumento(doc);
        j.update();
    }

    public void modificarTipoDocumento(int idJugador, String tipodoc) throws JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        j.setTipoDocumento(tipodoc);
        j.update();
    }


    public void modificarEstadoCampeonato(int idJugador, int idCampeonato) throws CampeonatoException, JugadorException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        Campeonato c = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
        try {
            ListadoJugadoresDeshabilitados registro = ListadoJugadoresDeshabilitadosDao.getInstancia().getByJugadorAndCampeonato(idJugador, idCampeonato);
            registro.delete();
        } catch (ListadoJugadoresDeshabilitadosException e) {
            ListadoJugadoresDeshabilitados jugadorDeshabilitado = new ListadoJugadoresDeshabilitados(j, c);
            jugadorDeshabilitado.update();
        }
    }

    public JugadorVO encontrarJugador(int idJugador) throws JugadorException {
        return JugadorDao.getInstancia().getJugadorById(idJugador).toVO();
    }

    public boolean perteneceAlClub(Jugador jugador, Integer idClub) {
        return jugador.isSuClub(idClub);
    }

    public List<JugadorVO> getJugadores() throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadores());
    }

    public JugadorVO getJugadorByDocumento(Integer nroDoc, String tipoDocumento) throws JugadorException {
        return JugadorDao.getInstancia().getJugadorByDocumento(nroDoc, tipoDocumento).toVO();
    }

    public List<JugadorVO> getJugadorByNombre(String nombre, String apellido) throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadorByNombre(nombre, apellido));
    }

    public List<JugadorVO> getJugadoresByClub(Integer idClub) throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadoresByClub(idClub));
    }

    public List<JugadorVO> getJugadoresByCategoria(int categoria) throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadoresByCategoria(categoria));
    }

    public List<JugadorVO> getJugadoresHabilitadosCategoriaClubAndCampeoanto(Integer club, int categoria, Integer idCampeonato) throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(club, categoria, idCampeonato));
    }

    public List<JugadorCampeonatoVO> getJugadoresWithEstadoCampeonato(Integer idCampeonato, Integer idClub) throws JugadorException {
        List<JugadorCampeonatoVO> jugadores = new ArrayList<>();
        List<Jugador> jugadoresClub = JugadorDao.getInstancia().getJugadoresByClub(idClub);
        try {
            List<ListadoJugadoresDeshabilitados> deshabilitados = ListadoJugadoresDeshabilitadosDao.getInstancia().getJugadoresDeshabilitadosCampeonato(idCampeonato);
            List<Integer> id = new ArrayList<>();
            for (ListadoJugadoresDeshabilitados d : deshabilitados)
                id.add(d.getJugador().getIdJugador());
            for (Jugador j : jugadoresClub) {
                if (id.contains(j.getIdJugador()))
                    jugadores.add(j.toJugadorCampeonato(idCampeonato, false));
                else
                    jugadores.add(j.toJugadorCampeonato(idCampeonato, true));
            }
        } catch (ListadoJugadoresDeshabilitadosException e) {
            for (Jugador j : jugadoresClub)
                jugadores.add(j.toJugadorCampeonato(idCampeonato, true));
        }
        return jugadores;
    }

    private List<JugadorVO> transformarAListaVO(List<Jugador> listaModelo) {
        List<JugadorVO> listaVO = new ArrayList<>();
        for (Jugador j : listaModelo)
            listaVO.add(j.toVO());
        return listaVO;
    }

    public StatsVO getStatsByCampeonato(int idJugador, int idCampeonato) throws
            JugadorException, CampeonatoException, PartidoException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
        List<Partido> partidosClub = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(idCampeonato, j.getClub().getIdClub()); // Se buscan los partidos que corresponden al campeonato y al club al que pertenece el jugador
        int cantGoles = 0;
        int cantAmarillas = 0;
        int cantRojas = 0;
        int cantJugados = 0;
        for (Partido p : partidosClub) {
            try {
                MiembroDao.getInstancia().getMiembroByPartidoAndJugador(p.getIdPartido(), j.getIdJugador()); // De los partidos obtenidos anteriormente, se determina si el jugador en cuestión participó o no. Si no lo hizo, no se buscan las estadísticas.
                cantJugados++;
                try {
                    cantGoles = cantGoles + GolDao.getInstancia().getGolesByJugadorAndPartido(p.getIdPartido(), idJugador).size();
                } catch (GolException e) {
                    cantGoles = cantGoles;
                }
                try {
                    cantAmarillas = cantAmarillas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Amarilla", p.getIdPartido()).size();
                } catch (FaltaException e) {
                    cantAmarillas = cantAmarillas;
                }
                try {
                    cantRojas = cantRojas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Roja", p.getIdPartido()).size();
                } catch (FaltaException e) {
                    cantRojas = cantRojas;
                }
            } catch (MiembroException e) {
                cantJugados = cantJugados;
            }
        }
        StatsVO stats = new StatsVO(cantGoles, cantRojas, cantAmarillas, cantJugados, j.getIdJugador(), j.getNombre(), j.getApellido(), campeonato.getIdCampeonato(), campeonato.getDescripcion(), j.getClub().getIdClub(), j.getClub().getNombre());
        return stats;
    }


    public StatsVO getStatsByClub(int idJugador, int idClub) throws
            JugadorException, ClubException, PartidoException {
        Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
        Club c = ClubDao.getInstancia().getClubById(idClub);
        int cantGoles = 0;
        int cantAmarillas = 0;
        int cantRojas = 0;
        int cantJugados = 0;
        List<Partido> partidosClub = PartidoDao.getInstancia().getPartidosByClub(idClub);
        for (Partido p : partidosClub) {
            try {
                MiembroDao.getInstancia().getMiembroByClubAndPartidoAndJugador(c.getIdClub(), p.getIdPartido(), j.getIdJugador());
                cantJugados++;
                try {
                    cantGoles = cantGoles + GolDao.getInstancia().getGolesByJugadorAndPartido(p.getIdPartido(), idJugador).size();
                } catch (GolException e) {
                    cantGoles = cantGoles;
                }
                try {
                    cantAmarillas = cantAmarillas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Amarilla", p.getIdPartido()).size();
                } catch (FaltaException e) {
                    cantAmarillas = cantAmarillas;
                }
                try {
                    cantRojas = cantRojas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Roja", p.getIdPartido()).size();
                } catch (FaltaException e) {
                    cantRojas = cantRojas;
                }
            } catch (MiembroException e) {
                cantJugados = cantJugados;
            }
        }
        StatsVO stats = new StatsVO(cantGoles, cantRojas, cantAmarillas, cantJugados, j.getIdJugador(), j.getNombre(), j.getApellido(), j.getClub().getIdClub(), j.getClub().getNombre());
        return stats;
    }

    public boolean existeMailJugador(String mail) {
        return JugadorDao.getInstancia().existeMailJugador(mail);
    }

    public boolean existeTelefonoJugador(String telefono) {
        return JugadorDao.getInstancia().existeTelefonoJugador(telefono);
    }

    public boolean existeDocumentoJugador(Integer documento) {
        return JugadorDao.getInstancia().existeDocumentoJugador(documento);
    }

}
