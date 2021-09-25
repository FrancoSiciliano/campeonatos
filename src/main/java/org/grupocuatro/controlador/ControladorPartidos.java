package org.grupocuatro.controlador;

import org.grupocuatro.dao.CampeonatoDao;
import org.grupocuatro.dao.ClubDao;
import org.grupocuatro.dao.PartidoDao;
import org.grupocuatro.dao.TablaPosicionDao;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.modelo.TablaPosiciones;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ControladorPartidos {
    private static ControladorPartidos instancia;

    private ControladorPartidos() {
    }

    public static ControladorPartidos getInstancia() {
        if (instancia == null)
            instancia = new ControladorPartidos();
        return instancia;
    }

    // SE SACÓ EL NROFECHA Y LA FECHA COMO PARÁMETROS, YA QUE SE ASIGNAN A POSTERIORI DE LA CREACIÓN DE LOS PARTIDOS

    public Integer crearPartido(int nroZona, int categoria, Integer idClubLocal, Integer idClubVisitante, Integer idCampeonato) {
        ControladorCampeonatos cc = ControladorCampeonatos.getInstancia();
        ControladorPartidos cp = ControladorPartidos.getInstancia();
        ControladorClubes cclubes = ControladorClubes.getInstancia();

        Campeonato c = cc.encontrarCampeonato(idCampeonato);
        Club local = cclubes.getClubById(idClubLocal);
        Club visitante = cclubes.getClubById(idClubVisitante);

        Partido p = null;

        if (c != null && local != null && visitante != null) {
            p = new Partido(nroZona, categoria, local, visitante, c);
            p.save();
        }

        return (p != null) ? p.getIdPartido() : null;

    }

    //SE ASUME QUE UNA FECHA NO DURA MAS DE UN DIA, ES DECIR QUE 1 FECHA = 1 DIA
    public void cargarNroFechaYFecha(Integer idPartido, int nroFecha, LocalDate fecha) {
        try {
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);

            if (ControladorCampeonatos.getInstancia().estaEnLaFecha(p.getCampeonato(), fecha)) {
                List<Partido> partidosLocal = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(p.getClubLocal().getIdClub(), p.getCampeonato().getIdCampeonato());
                List<Partido> partidosVisitante = PartidoDao.getInstancia().getPartidosByCampeonatoAndClub(p.getClubVisitante().getIdClub(), p.getCampeonato().getIdCampeonato());

                try {
                    for (Partido pp : partidosLocal) {
                        if (pp.getNroFecha() == nroFecha) {
                            throw new PartidoException("El club local ya juega en la fecha ingresada");
                        }
                    }

                    for (Partido pp : partidosVisitante) {
                        if (pp.getNroFecha() == nroFecha) {
                            throw new PartidoException("El club visitante ya juega en la fecha ingresada");
                        }
                    }

                    p.setNroFecha(nroFecha);
                    p.setFechaPartido(fecha);
                    p.update();

                } catch (PartidoException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new PartidoException("La fecha ingresada no esta comprendida entre las fechas del torneo");
            }

        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarResultadoPartido(Integer idPartido, String incidentes) {
        try {
            ControladorGoles cont = ControladorGoles.getInstancia();
            Partido p = PartidoDao.getInstancia().getPartidoById(idPartido);

            int clubLocal = p.getClubLocal().getIdClub();
            int clubVisitante = p.getClubVisitante().getIdClub();
            int cantGolesLocal = cont.contarCantidadGoles(clubLocal, idPartido);
            int cantGolesVisitante = cont.contarCantidadGoles(clubVisitante, idPartido);
            p.setGolesLocal(cantGolesLocal);
            p.setGolesVisitante(cantGolesVisitante);
            p.setIncidentes(incidentes);

            p.update();
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validadoPorClubLocal(Integer idClubL, Integer idPartido) {
        try {
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if (Objects.equals(idClubL, partido.getClubLocal().getIdClub())) {
                partido.setConvalidaLocal();
                partido.update();
                modificarTablaPosiciones(partido);

            } else {
                System.out.println("El club ingresado no corresponde al club local");
            }
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void validadoPorClubVisitante(Integer idClubV, Integer idPartido) {
        try {
            Partido partido = PartidoDao.getInstancia().getPartidoById(idPartido);
            if (Objects.equals(idClubV, partido.getClubVisitante().getIdClub())) {
                partido.setConvalidaVisitante();
                partido.update();
                modificarTablaPosiciones(partido);

            } else {
                System.out.println("El club ingresado no corresponde al club visitante");
            }


        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarTablaPosiciones(Partido partido) {
        if (chequearValidacion(partido)) {
            if (partido.isEmpate()) {
                actualizarTablaPosiciones(partido.getClubLocal().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesLocal(), partido.getGolesVisitante());
                actualizarTablaPosiciones(partido.getClubVisitante().getIdClub(), partido.getCampeonato().getIdCampeonato(), 1, partido.getGolesVisitante(), partido.getGolesLocal());
            } else {
                actualizarTablaPosiciones(partido.getGanador().getIdClub(), partido.getCampeonato().getIdCampeonato(), 3, partido.getGolesGanador(), partido.getGolesPerdedor());
                actualizarTablaPosiciones(partido.getPerdedor().getIdClub(), partido.getCampeonato().getIdCampeonato(), 0, partido.getGolesPerdedor(), partido.getGolesGanador());
            }
        }
    }

    private boolean chequearValidacion(Partido partido) {return partido.isValidado();}

    public void actualizarTablaPosiciones(Integer idClub, Integer idCampeonato, int puntos, int golesFavor, int golesContra) {
        TablaPosiciones tp;
        ControladorClubes controladorClubes = ControladorClubes.getInstancia();
        ControladorCampeonatos controladorCampeonatos = ControladorCampeonatos.getInstancia();

        try {
            tp = TablaPosicionDao.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);
        } catch (TablaPosicionException e) {
            tp = new TablaPosiciones(controladorClubes.getClubById(idClub), controladorCampeonatos.encontrarCampeonato(idCampeonato));
            tp.save();
        }


        switch (puntos) {
            case 0:
                tp.setCantidadPerdidos(tp.getCantidadPerdidos() + 1);
                break;
            case 1:
                tp.setCantidadEmpatados(tp.getCantidadEmpatados() + 1);
                break;
            case 3:
                tp.setCantidadGanados(tp.getCantidadGanados() + 1);
                break;
        }

        tp.setPuntos(tp.getPuntos() + puntos);

        int difGoles = golesFavor - golesContra;

        tp.setDiferenciaGoles(tp.getDiferenciaGoles() + difGoles);
        tp.setGolesFavor(tp.getGolesFavor() + golesFavor);
        tp.setGolesContra(tp.getGolesContra() + golesContra);

        float ptos = tp.getPuntos();
        float partidosJugados = tp.getCantidadJugados();

        tp.setPromedio(ptos / partidosJugados);
        tp.update();
    }

    public List<Partido> getAllPartidos() {
        try {
            return PartidoDao.getInstancia().getAllPartidos();
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Partido encontrarPartido(Integer idPartido) {
        PartidoDao partidodao = PartidoDao.getInstancia();
        Partido partido = null;
        try {
            partido = partidodao.getInstancia().getPartidoById(idPartido);
            return partido;
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByCampeonato(Integer idCampeonato) {
        try {
            return PartidoDao.getInstancia().getPartidosByCampeonato(idCampeonato);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Partido> getPartidosByCategoria(int categoria) {
        try {
            return PartidoDao.getInstancia().getPartidosByCategoria(categoria);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Partido getUltimoPartidoByClubAndCampeonato(Integer idClub, Integer idCampeonato, int nroFechaActual) {
        try {
            return PartidoDao.getInstancia().getUltimoPartidoByClubAndCampeonato(idClub, idCampeonato, nroFechaActual);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByNroFechaAndCampeonato(Integer idCampeonato, int nroFecha) {
        try {
            return PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonato(idCampeonato, nroFecha);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByNroZona(int NroZona) {
        try {
            return PartidoDao.getInstancia().getPartidosByNroZona(NroZona);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByClubLocal(int idClub) {
        try {
            return PartidoDao.getInstancia().getPartidosByClubLocal(idClub);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByClubVisitante(int idClub) {
        try {
            return PartidoDao.getInstancia().getPartidosByClubVisitante(idClub);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Partido> getPartidosByNroFechaAndCampeonatoAndClub(Integer idCampeonato, int nroFecha, Integer idClub) {
        try {
            return PartidoDao.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(idCampeonato, nroFecha, idClub);
        } catch (PartidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
