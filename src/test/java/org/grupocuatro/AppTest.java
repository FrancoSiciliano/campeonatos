package org.grupocuatro;

import static org.junit.Assert.assertTrue;

import org.grupocuatro.dao.*;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.*;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
      /* Club c = new Club(1,"Deportivo Juguete","A123");
       Club c2 = new Club(2,"Deportivo Riestra","B123");
       ClubDao.getInstancia().save(c);
       ClubDao.getInstancia().save(c2);
*/
        /*Club c = null, c2 = null;

        try {
            c = ClubDao.getInstancia().getClubById(1);
            c2 = ClubDao.getInstancia().getClubById(2);
        } catch (ClubException e) {
            e.printStackTrace();
        } */
/*
        Jugador j = new Jugador("DNI", 12345678, "Juan", "Perez", c, new Date());
        Jugador j2 = new Jugador("DNI", 12345677, "Pedro", "Lopez", c, new Date());
        Jugador j4 = new Jugador("DNI", 12345657, "Enrique", "Paredes", c2, new Date());
        Jugador j3 = new Jugador("DNI", 12345697, "Esteban", "Kito", c2, new Date());

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

        Campeonato camp = new Campeonato("Copa de leche", new Date(), new Date(), "activo");

        CampeonatoDao.getInstancia().save(camp);

        System.out.println("Campeonato hecho");

        ClubesCampeonato cc = new ClubesCampeonato(c, camp);
        ClubesCampeonato cc2 = new ClubesCampeonato(c2,camp);

        ClubesCampeonatoDao.getInstancia().save(cc);
        ClubesCampeonatoDao.getInstancia().save(cc2);

        System.out.println("ClubCampo hecho");

        Partido p = new Partido(1, 2, 21, c, c2, new Date(), camp);

        PartidoDao.getInstancia().save(p);

        System.out.println("partidos hecho");

        Miembro m = new Miembro(c, p, j);
        Miembro m1 = new Miembro(c, p, j);
        Miembro m2 = new Miembro(c2, p, j);
        Miembro m3 = new Miembro(c2, p, j);

        MiembroDao.getInstancia().save(m);
        MiembroDao.getInstancia().save(m1);
        MiembroDao.getInstancia().save(m2);
        MiembroDao.getInstancia().save(m3);

        System.out.println("Miembros hecho");

        TablaPosiciones tp = new TablaPosiciones(c, camp);
        TablaPosiciones tp2 = new TablaPosiciones(c2, camp);

        TablaPosicionDao.getInstancia().save(tp);
        TablaPosicionDao.getInstancia().save(tp2);

        System.out.println("Tabla hecho");

        Falta f = new Falta(j,p,camp,5,"roja");
        Falta f2 = new Falta(j2,p,camp,5,"amarilla");

        FaltaDao.getInstancia().save(f);
        FaltaDao.getInstancia().save(f2);

        System.out.println("Faltas hecho");

        Gol g = new Gol(j,p,2,"a favor");
        Gol g2 = new Gol(j3, p, 87, "en contra");

        GolDao.getInstancia().save(g);
        GolDao.getInstancia().save(g2);

        System.out.println("Todo se ejecuto bien"); */

        List<Partido> p = PartidoDao.getInstancia().getPartidosByClubLocal(1);
        for (Partido partido : p) {
            System.out.println(partido.getIdPartido());
        }
    }
}
