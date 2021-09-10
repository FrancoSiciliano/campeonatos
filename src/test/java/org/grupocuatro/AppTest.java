package org.grupocuatro;



import org.grupocuatro.dao.*;
import org.grupocuatro.modelo.*;


import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {


        Club c = new Club(1, "Deportivo Juguete", "A123");
        Club c2 = new Club(2, "Deportivo Riestra", "B123");

        ClubDao.getInstancia().save(c);
        ClubDao.getInstancia().save(c2);

        Jugador j = new Jugador("DNI", 12345678, "Juan", "Perez", c, LocalDate.now(), "Av Libertador 3213", "juanperez@gmail.com", "01143533432");
        Jugador j2 = new Jugador("DNI", 12345677, "Pedro", "Lopez", c, LocalDate.now(), "Av Santa Fe 1200", "juanperez@gmail.com", "01143533432");
        Jugador j4 = new Jugador("DNI", 12345657, "Enrique", "Paredes", c2, LocalDate.now(), "Av Lugones 4000", "juanperez@gmail.com", "01143533432");
        Jugador j3 = new Jugador("DNI", 12345697, "Esteban", "Kito", c2, LocalDate.now(), "Av Scalabrini Ortiz 456", "juanperez@gmail.com", "01143533432");

        JugadorDao.getInstancia().save(j);
        JugadorDao.getInstancia().save(j2);
        JugadorDao.getInstancia().save(j3);
        JugadorDao.getInstancia().save(j4);

        System.out.println("Jugadores hecho");

        Responsable r = new Responsable("DNI", "Carlos Menem", c);
        Responsable r2 = new Responsable("DNI", "Humberto Grondona", c2);

        ResponsableDao.getInstancia().save(r);
        ResponsableDao.getInstancia().save(r2);

        System.out.println("Responsables hecho");

        Campeonato camp = new Campeonato("Copa de leche", LocalDate.now(), LocalDate.now(), "activo", 86);
        Campeonato camp2 = new Campeonato("Copa de carton", LocalDate.now(), LocalDate.now(), "activo", 00); // NUEVA LINEA

        CampeonatoDao.getInstancia().save(camp);
        CampeonatoDao.getInstancia().save(camp2); // NUEVA LINEA

        System.out.println("Campeonato hecho");

        ClubesCampeonato cc = new ClubesCampeonato(c, camp);
        ClubesCampeonato cc2 = new ClubesCampeonato(c2, camp);

        ClubesCampeonatoDao.getInstancia().save(cc);
        ClubesCampeonatoDao.getInstancia().save(cc2);

        System.out.println("ClubCampo hecho");

        Partido p = new Partido(1, 2, 00, c, c2, LocalDate.now() , camp);

        PartidoDao.getInstancia().save(p);

        System.out.println("partidos hecho");

        Miembro m = new Miembro(c, p, j);
        Miembro m2 = new Miembro(c2, p, j2);

        MiembroDao.getInstancia().save(m);
        MiembroDao.getInstancia().save(m2);


        System.out.println("Miembros hecho");

        TablaPosiciones tp = new TablaPosiciones(c, camp);
        TablaPosiciones tp2 = new TablaPosiciones(c2, camp);

        TablaPosicionDao.getInstancia().save(tp);
        TablaPosicionDao.getInstancia().save(tp2);

        System.out.println("Tabla hecho");

        Falta f = new Falta(j, p, camp, 5, "roja");
        Falta f2 = new Falta(j2, p, camp, 5, "amarilla");

        FaltaDao.getInstancia().save(f);
        FaltaDao.getInstancia().save(f2);

        System.out.println("Faltas hecho");

        Gol g = new Gol(j, p, 2, "a favor");
        Gol g2 = new Gol(j3, p, 87, "en contra");

        GolDao.getInstancia().save(g);
        GolDao.getInstancia().save(g2);

        System.out.println("Todo se ejecuto bien");
    }
}
