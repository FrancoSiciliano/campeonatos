package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
import java.util.List;

public class ControladorJugadores {

    // FIXME AGREGAR CONSULTA DE PROGRESO DEL EQUIPO DEL JUGADOR EN UN CAMPEONATO


    private static ControladorJugadores instancia;

    private ControladorJugadores() {}

    public static ControladorJugadores getInstancia() {
        if (instancia == null)
            instancia = new ControladorJugadores();
        return instancia;
    }


    // No estaba el tipoDocumento, el documento era un String, no estaba el apellido.

    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, LocalDate fechaNacimiento, String direccion, String mail, String telefono) throws JugadorException {
        JugadorDao dao = JugadorDao.getInstancia();
        try {
            dao.getJugadorByDocumento(documento, tipoDocumento);
            System.out.println("Ya existe el jugador que se esta intentando agregar");
        } catch (JugadorException e) {
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                Jugador j = new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento, direccion, mail, telefono);
                dao.save(j);
                return j.getIdJugador();
            } catch (ClubException e2) {
                System.out.println(e2.getMessage());
            }
        }
        throw new JugadorException("No se pudo agregar el jugador deseado");
    }

    public void modificarDireccion(int idJugador, String direccion){
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setDireccion(direccion);
            JugadorDao.getInstancia().update(j);
        } catch (JugadorException e) {
            e.printStackTrace();
        }
    }

    public void modificarMail(int idJugador, String mail) {
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setMail(mail);
            JugadorDao.getInstancia().update(j);
        } catch (JugadorException e) {
            e.printStackTrace();
        }
    }

    public void modificarTelefono(int idJugador, String telefono) {
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setTelefono(telefono);
            JugadorDao.getInstancia().update(j);
        } catch (JugadorException e) {
            e.printStackTrace();
        }
    }

    public void eliminarJugador(int idJugador, int idClub) {
        JugadorDao dao = JugadorDao.getInstancia();
        Jugador player = null;
        try {
            player = dao.getJugadorById(idJugador);
            if (player.isClub(idClub)) dao.delete(player);

        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    //FIXME Habría que contar las amarillas y si llega a un límite, no dejarlo integrar la lista de jugadores tampoco.
    public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {
//          if (fueExpulsadoEnElUltimoPartido(idJugador, idClub, idCampeonato))
//             System.out.println("El jugador fue expulsado en el último partido");
//        else {
    }


    public void getStatsByCampeonato(int idJugador, int idCampeonato) {
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
                        cantGoles = cantGoles +  GolDao.getInstancia().getGolesByJugadorAndPartido(p.getIdPartido(), idJugador).size();
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
            j.getEstadisticasCampeonato(campeonato.getIdCampeonato(), cantGoles, cantAmarillas, cantRojas, cantJugados); // Printea todos los datos con formato.

        } catch (JugadorException | CampeonatoException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }


    public void getStatsByClub(int idJugador, int idClub) {
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
                        cantGoles = cantGoles +  GolDao.getInstancia().getGolesByJugadorAndPartido(p.getIdPartido(), idJugador).size();
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
            j.getEstadisticasClub(cantGoles, cantAmarillas, cantRojas, cantJugados); // Printea todos los datos con formato.

        } catch (JugadorException | ClubException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
