package org.grupocuatro.controlador;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
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

    public void modificarDireccion(int idJugador, String direccion) {
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setDireccion(direccion);
            j.update();
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarMail(int idJugador, String mail) {
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setMail(mail);
            j.update();
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarTelefono(int idJugador, String telefono) {
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setTelefono(telefono);
            j.update();
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarEstado(int idJugador) { //habilita al jugador
        try {
            Jugador j = JugadorDao.getInstancia().getJugadorById(idJugador);
            j.setEstado(!j.isEstado());
            j.update();
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Jugador> getJugadores() {
        try {
            return JugadorDao.getInstancia().getJugadores();
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Jugador encontrarJugador(int idJugador) {
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador;
        try {
            jugador = jugadordao.getJugadorById(idJugador);
            return jugador;
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean perteneceAlClub(Jugador jugador, Integer idClub) {
        return jugador.isSuClub(idClub);
    }

    public Jugador getJugadorByDocumento(Integer nroDoc, String tipoDocumento) {
        try {
            return JugadorDao.getInstancia().getJugadorByDocumento(nroDoc, tipoDocumento);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Jugador> getJugadorByNombre(String nombre, String apellido) {
        try {
            return JugadorDao.getInstancia().getJugadorByNombre(nombre, apellido);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Jugador> getJugadoresByClub(Integer idClub) {
        try {
            return JugadorDao.getInstancia().getJugadoresByClub(idClub);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Jugador> getJugadoresByCategoria(int categoria) {
        try {
            return JugadorDao.getInstancia().getJugadoresByCategoria(categoria);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Jugador> getJugadoresHabilitadosCategoriaClub (Integer club, int categoria) {
        try{
            return JugadorDao.getInstancia().getJugadoresHabilitadosCategoriaClub(club,categoria);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
