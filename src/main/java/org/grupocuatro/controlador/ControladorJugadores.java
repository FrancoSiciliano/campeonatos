package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;
import org.grupocuatro.vo.JugadorVO;

import javax.persistence.NoResultException;
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

    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, Integer idClub, LocalDate fechaNacimiento, String direccion, String mail, String telefono) {
        JugadorDao dao = JugadorDao.getInstancia();
        try {
            dao.getJugadorByDocumento(documento, tipoDocumento);
            System.out.println("Ya existe el jugador que se esta intentando agregar");
        } catch (JugadorException e) {
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                Jugador j = new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento, direccion, mail, telefono);
                j.save();
                return j.getIdJugador();
            } catch (ClubException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
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
        if (j.isEstado() == true)
            j.setEstado(false);
        else {
            j.setEstado(true);
        }
        j.update();
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

    public List<JugadorVO> getJugadoresHabilitadosCategoriaClub (Integer club, int categoria) throws JugadorException {
        return transformarAListaVO(JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(club,categoria));
    }

    private List<JugadorVO> transformarAListaVO(List<Jugador> listaModelo) {
        List<JugadorVO> listaVO = new ArrayList<>();
        for (Jugador j : listaModelo)
            listaVO.add(j.toVO());
        return listaVO;
    }

    //TODO ESTA PARTE ES PARA LAS PROXIMAS ETAPAS DEL TRABAJO (IGNORAR)

    // FIXME AGREGAR CONSULTA DE PROGRESO DEL EQUIPO DEL JUGADOR EN UN CAMPEONATO

    public String getStatsByCampeonato(int idJugador, int idCampeonato) {
        try {
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
                        cantRojas = cantRojas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador,  "Roja",p.getIdPartido()).size();
                    } catch (FaltaException e) {
                        cantRojas = cantRojas;
                    }
                } catch (MiembroException e) {
                    cantJugados = cantJugados;
                }
            }
            return j.getEstadisticasCampeonato(campeonato.getIdCampeonato(), cantGoles, cantAmarillas, cantRojas, cantJugados); // Printea todos los datos con formato.

        } catch (JugadorException | CampeonatoException | PartidoException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }


    public String getStatsByClub(int idJugador, int idClub) {
        try {
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
                        cantAmarillas = cantAmarillas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Amarilla",p.getIdPartido()).size();
                    } catch (FaltaException e) {
                        cantAmarillas = cantAmarillas;
                    }
                    try {
                        cantRojas = cantRojas + FaltaDao.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, "Roja",p.getIdPartido()).size();
                    } catch (FaltaException e) {
                        cantRojas = cantRojas;
                    }
                } catch (MiembroException e) {
                    cantJugados = cantJugados;
                }
            }
            return j.getEstadisticasClub(cantGoles, cantAmarillas, cantRojas, cantJugados); // Printea todos los datos con formato.

        } catch (JugadorException | ClubException | PartidoException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }


}
