package org.grupocuatro.controlador;

import jdk.vm.ci.meta.Local;
import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Controlador {

    private static Controlador instancia;

    private Controlador() {
    }

    public static Controlador getInstancia() {
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    /*
     * Notas:
     *
     * -Pueden si lo desean convertir el controlador en un Singleton
     *
     * -Deberan completar los metodos del controlador para que cumplan con los requerimientos
     *  del trabajo, Recuerden siempre aplicar los patrones GRASP para verificar la correcta
     *  asignacion de lasresponsabilidades
     *
     * -En la segunda parate del trabajo deber'an agragar los metodos y controles que
     *  considen necesarios. */


    // Se agregaron 2 setters en el Club para poder modificar el nombre y la dirección.
    // Se agregó el throw de la excepción del ClubDAO.

    public void crearClub(Integer id, String nombre, String direccion) {
        try {
            Club club = ClubDao.getInstancia().getClubById(id);
        } catch (ClubException e) {
            Club c = new Club(id, nombre, direccion);
            c.save();
        }
    }

    public void modificarClub(String nombre, String direccion) {
        ClubDao dao = ClubDao.getInstancia();
        Club club = null;
        try {
            club = dao.getClubByNombre(nombre);
            club.setNombre(nombre);
            club.setDireccion(direccion);
            club.update();

        } catch (ClubException e) {
            System.out.printf(e.getMessage());
        }
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, "activo");
        nuevoCampeonato.save();
        return nuevoCampeonato.getIdCampeonato();
    }

    public void terminarCampeonato(Integer id) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(id);
            campeonato.setEstado("inactivo");
            campeonato.update();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }


    // No estaba el tipoDocumento, el documento era un String, no estaba el apellido.
    // Hay que agregarle el throw al método para que pueda manejar las excepciones
    // El método figuraba que devolvía un Integer como retorno.
    public Integer agregarJugador(String tipoDocumento, int documento, String nombre, String apellido, int idClub, LocalDate fechaNacimiento) throws JugadorException {
        JugadorDao dao = JugadorDao.getInstancia();
        try {
            dao.getJugadorByDocumento(documento, tipoDocumento);
            System.out.println("Ya existe el jugador que se esta intentando agregar");
        } catch (JugadorException e) {
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                Jugador j = new Jugador(tipoDocumento, documento, nombre, apellido, club, fechaNacimiento);
                dao.save(j);
                return j.getIdJugador();
            } catch (ClubException e2) {
                System.out.println(e2.getMessage());
            }
        }
        throw new JugadorException("No se pudo agregar el jugador deseado");
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

    public void habilitarJugador(int idJugador, int idClub, int idCampeonato) {

    }

    // El método vino con el Integer como retorno, pero se lo cambió a void.
    // Agregar el retorno como Integer

    public Integer crearListaJugadores(Club club, Partido partido) {
        MiembroDao dao = MiembroDao.getInstancia();
        Miembro m = new Miembro(club, partido);
        dao.save(m);
        return m.getIdLista();
    }

    public Integer cargarGol(Integer idJugador, Integer idPartido, int minuto, String tipo) {
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador = null;
        try {
            jugador = jugadordao.getJugadorById(idJugador);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try {
            partido = partidodao.getInstancia().getPartidoById(idPartido);
        } catch (PartidoException e) {
            e.printStackTrace();
        }
        GolDao goldao = GolDao.getInstancia();
        Gol gol = null;
        gol = new Gol(jugador, partido, minuto, tipo);
        goldao.save(gol);
        return gol.getIdGol();
    }

    public Integer cargarFalta(Integer idJugador, Integer idPartido, Integer idCameponato, int minuto, String tipo) {
        JugadorDao jugadordao = JugadorDao.getInstancia();
        Jugador jugador = null;
        try {
            jugador = jugadordao.getJugadorById(idJugador);
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try {
            partido = partidodao.getInstancia().getPartidoById(idPartido);
        } catch (PartidoException e) {
            e.printStackTrace();
        }
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato = null;
        try {
            campeonato = campeonatoDao.getCampeonato(idCameponato);

        } catch (CampeonatoException e) {
            e.printStackTrace();
        }
        FaltaDao faltadao = FaltaDao.getInstancia();
        Falta falta = null;
        falta = new Falta(jugador, partido, campeonato, minuto, tipo);
        faltadao.save(falta);
        List<Falta> lista_falta = null;
        try {
            lista_falta = faltadao.getFaltasByJugadorAndPartido(idJugador, idPartido);
        } catch (FaltaException e) {
            System.out.println(e.getMessage());
        }
        int cantidad = lista_falta.size();
        if (cantidad == 2) {
            falta = new Falta(jugador, partido, campeonato, minuto, "Roja");
            faltadao.save(falta);
        }
        return falta.getIdFalta();
    }

    // REVISAR ESTE METODO!

    public void agregarJugadoresEnLista(int idMiembro, Jugador jugador) throws MiembroException {
        /*
        CONTROLES:
        - Categoria: Que no participen en categorías menor que poseen (categoria >= cateogoriaPartido)
        - Partidos: Que no jueguen más de un partido en el mismo día.
        - Cantidad: 17 Jugadores por partido.
        - Habilitación: Que no haya sido expulsado en el partido anterior en el mismo torneo (en otro si).
        - Campeonato: No poder participar en campeonatos ya arrancados.
         */
    }

    public Integer crearResponsable(String documento, String nombre, Integer idClub) throws ResponsableException {
        ResponsableDao dao = ResponsableDao.getInstancia();
        try {
            Club club = ClubDao.getInstancia().getClubById(idClub);
            try {
                dao.getResponsableByNroDocAndClub(documento, idClub);
                System.out.println("Ya existe el representante de DNI " + documento + " en el club " + idClub);
            } catch (ResponsableException e) {
                Responsable r = new Responsable(documento, nombre, club);
                r.save();
                return r.getLegajo();
            }
        } catch (ClubException e) {
            System.out.println(e.getMessage());
        }
        throw new ResponsableException("No se pudo crear el responsable solicitado");

    }

    public void modificarResponsable(Integer legajoResponsable, String documento, String nombre, Integer idClub) {
        ResponsableDao dao = ResponsableDao.getInstancia();
        try {
            Responsable resp = dao.getResponsable(legajoResponsable);
            try {
                Club club = ClubDao.getInstancia().getClubById(idClub);
                resp.setClub(club);
                resp.setNombre(nombre);
                resp.setDocumento(documento);
                resp.update();
            } catch (ClubException c) {
                System.out.println(c.getMessage());
            }
        } catch (ResponsableException e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer crearPartido(int nroFecha, int nroZona, int categoria, int idClubLocal, int idClubVisitante, int idCampeonato) throws PartidoException {
        try {
            Campeonato c = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            try {
                Club local = ClubDao.getInstancia().getClubById(idClubLocal);
                Club visitante = ClubDao.getInstancia().getClubById(idClubVisitante);
                Partido p = new Partido(nroFecha, nroZona, categoria, local, visitante, c);
                PartidoDao.getInstancia().save(p);
                return p.getIdPartido();
            } catch (ClubException e) {
                System.out.println(e.getMessage());
            }
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
        throw new PartidoException("No se pudo agregar el partido");
    }

    public void cargarResultadoPartido(int idPartido) {
        try {
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);
            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);
        } catch (PartidoException e) {

            System.out.println(e.getMessage());
        }
    }

    private int contarCantidadGoles(int idClub, int idPartido) {
        int cantGoles = 0;
        try {
            List<Gol> goles = GolDao.getInstancia().getGolesByPartidoAndClub(idPartido, idClub);
            cantGoles = goles.size();
            return cantGoles;
        } catch (GolException e) {
            cantGoles = 0;
            return cantGoles;
        }
    }

}
