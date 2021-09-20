package org.grupocuatro.controlador;
import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.ClubesCampeonatoDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.*;
import org.grupocuatro.utiles.Tupla;


import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControladorCampeonatos {
    private static ControladorCampeonatos instancia;

    private ControladorCampeonatos() {
    }

    public static ControladorCampeonatos getInstancia() {
        if (instancia == null)
            instancia = new ControladorCampeonatos();
        return instancia;
    }

    public Integer crearCampeonato(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        Campeonato nuevoCampeonato = new Campeonato(descripcion, fechaInicio, fechaFin, estado);
        try {
            for (Campeonato c : CampeonatoDao.getInstancia().getCampeonatos()) {
                if (Objects.equals(descripcion, c.getDescripcion()) && Objects.equals(c.getFechaInicio(), fechaInicio) && Objects.equals(c.getFechaFin(), fechaFin) && Objects.equals(c.getEstado(), "activo")) {
                    System.out.println("Ya existe el campeonato que se esta intentando ingresar");
                    return null;
                }
            }
            throw new CampeonatoException("");
        } catch (CampeonatoException e) {
            nuevoCampeonato.save();
        }
        return nuevoCampeonato.getIdCampeonato();
    }


    // TODO LA CATEGORIA LA CONTROLA LA VISTA
    // FIXME BORRAR EL PARTIDO FALSO :D

    public void definirTipoCampeonatoAndCategoria(String tipo, Integer idCampeonato, int categoria) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            campeonato.setTipoCampeonato(tipo);
            campeonato.update();
            // TODO Acá habría llamar a dos métodos diferentes según el tipo de campeonato que se esté cargando. El caso armado es para el "todos contra todos", en zonas es diferente la generación de partidos.
            cargarPartidosCampeonatoPuntos(campeonato, categoria);

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cargarPartidosCampeonatoPuntos(Campeonato campeonato, int categoria) {
        List<Club> clubesInscriptos = ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato());
        List<Club> clubesLocales = clubesInscriptos;
        List<Club> clubesVisitantes = clubesInscriptos;
        for (Club clubLocal : clubesLocales) {
            for (Club clubVisitante : clubesVisitantes) {
                if (!Objects.equals(clubLocal.getIdClub(), clubVisitante.getIdClub()))
                    ControladorPartidos.getInstancia().crearPartido(0, categoria, clubLocal.getIdClub(), clubVisitante.getIdClub(), campeonato.getIdCampeonato());
            }
        }
        asignarFechaPartidosCampeonatoPuntos(campeonato.getIdCampeonato());
    }

    private void asignarFechaPartidosCampeonatoPuntos(int idCampeonato) {
        List<Partido> partidosCampeonato = ControladorPartidos.getInstancia().getPartidosByCampeonato(idCampeonato);
        List<Club> clubesParticipantes = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);
        System.out.println(clubesParticipantes);
        Set<Club> clubesRegistrados = new HashSet<Club>();
        List<Tupla> enfrentamientos = new ArrayList<>();
        int cantRegistrados = 0;
        int cantFechas = (clubesParticipantes.size() - 1) * 2;
        for (int nroFecha = 1 ; nroFecha <= cantFechas ; nroFecha++) {
            while (cantRegistrados != clubesParticipantes.size()) {
                int indice = getNroAleatorio(0, partidosCampeonato.size() - 1);
                Partido p = partidosCampeonato.get(indice);
                if ((clubesRegistrados.isEmpty() || (!clubesRegistrados.contains(p.getClubLocal()) && !clubesRegistrados.contains(p.getClubVisitante()))) && p.getNroFecha() == 99) { // Si el conjunto que indica los clubes que participan esa fecha no contiene al local y visitante, y si el partido no fue asignado ya al campeonato, se efectúa la operación
                    boolean seEnfrentaron = false;
                    for (Tupla enfrentamiento : enfrentamientos) {
                        if (enfrentamiento.parExistente(p.getClubLocal().getIdClub(), p.getClubVisitante().getIdClub()))
                            seEnfrentaron = true;
                    }
                    if (!seEnfrentaron) {
                        p.setNroFecha(nroFecha);
                        p.save();
                        clubesRegistrados.add(p.getClubLocal());
                        clubesRegistrados.add(p.getClubVisitante());
                        enfrentamientos.add(new Tupla(p.getClubLocal().getIdClub(), p.getClubVisitante().getIdClub()));
                        cantRegistrados = cantRegistrados + 2;
                    }
                }
            }
            clubesRegistrados.clear();  // Como la fecha ya se terminó de organizar, el conjunto se vacía para poder comenzar con la siguiente.
            cantRegistrados = 0;
            enfrentamientos.clear(); //TODO ESTO SE DEBERÍA HACER CUANDO SE COMPLETA LA PRIMERA RONDA DE ENFRENTAMIENTOS
            // TODO LO QUE PASA ES QUE DE FORMA ALEATORIA PUEDE SUCEDER QUE LA ÚNICA COMBINACIÓN POSIBLE DEBA SER UN PARTIDO DE VUELTA, LO QUE NO SE PUEDE.
        }
    }


    private static int getNroAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1); // EL LIMITE SUPERIOR ES EXCLUSIVO, POR ESO SE LE SUMA 1
    }



    private void cargarPartidosCampPuntos(long diasDuracion, List<Club> lista, int categoria, int idCampeoanto) {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        int cantEquipos = lista.size();
        int cantFechas = cantEquipos * 2 - 1;
        int fechaIda = 1;
        int fechaVuelta = cantFechas / 2 + 1;
        //int cantPartidosJugar = cantEquipos * (cantEquipos - 1);
        //int cantPartidosSimult = cantEquipos / 2;
        List<Club> clubesA = lista;
        List<Club> clubesB = lista;
        for (Club clubA : clubesA) {
            for (Club clubB : clubesB) {
                if (clubA.getIdClub() != clubB.getIdClub()) {
                    //controladorPartidos.crearPartido(fechaIda, 0, categoria, clubA.getIdClub(), clubB.getIdClub(), LocalDate.of(1,1,1), idCampeoanto);
                    //controladorPartidos.crearPartido(fechaVuelta, 0, categoria, clubB.getIdClub(), clubA.getIdClub(), LocalDate.of(1,1,1), idCampeoanto);
                    fechaIda++;
                    fechaVuelta++;
                }
            }
            fechaIda = 1;
            fechaVuelta = cantFechas / 2 + 1;
        }

    }

    private void cargarPartidoCampZonas(long diasDuracion, List<Club> lista) {
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();


    }

    public void terminarCampeonato(Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            campeonato.setEstado("inactivo");
            campeonato.update();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Campeonato encontrarCampeonato(Integer idCampeonato) {
        CampeonatoDao campeonatoDao = CampeonatoDao.getInstancia();
        Campeonato campeonato;
        try {
            campeonato = campeonatoDao.getCampeonato(idCampeonato);
            return campeonato;
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Campeonato> getCampeonatos() {
        try {
            return CampeonatoDao.getInstancia().getCampeonatos();
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<Campeonato> getCampeonatosByEstado(String estado) {
        try {
            return CampeonatoDao.getInstancia().getCampeonatosByEstado(estado);
        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    //PARTE DE CLUBES CAMPEONATO

    public void agregarClubACampeonato(Integer idClub, Integer idCampeonato) {
        try {
            Campeonato campeonato = CampeonatoDao.getInstancia().getCampeonato(idCampeonato);
            Club club = ControladorClubes.getInstancia().getClubById(idClub);
            if (club != null) {
                try {
                    ClubesCampeonatoDao.getInstancia().getClubCampeonato(idClub, idCampeonato);
                } catch (ClubesCampeonatoException e2) {

                   // List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(idClub);


                    ClubesCampeonato nuevocc = new ClubesCampeonato(club, campeonato);
                    nuevocc.save();
                }
            } else System.out.println("No existe el club ingresado");

        } catch (CampeonatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Campeonato> getCampeonatosByClub(Integer idClub) {
        try {
            return ClubesCampeonatoDao.getInstancia().getCampeonatosClub(idClub);
        } catch (ClubesCampeonatoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
