package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.vo.JugadorVO;
import org.grupocuatro.vo.StatsVO;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.util.List;

public class ControladorJugadoresTest extends TestCase {

    public void testCrearJugador() {
        try {

            //BOCA 1-11
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31123456, "Juan Roman", "Riquelme", 1, LocalDate.of(1978, 6, 24), "Su casa 1", "rriquelme@mail.com", "+54 11 1928-1339", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 93353922, "Agustin", "Rossi", 1, LocalDate.of(1995, 8, 21), "Su casa 2", "arossi@mail.com", "+54 11 6258-7830", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 70111576, "Carlos", "Izquierdoz", 1, LocalDate.of(1988, 11, 3), "Su casa 3", "cali@mail.com", "+54 11 2884-7437", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61648656, "Marcos", "Rojo", 1, LocalDate.of(1990, 3, 20), "Su casa 4", "mrojo@mail.com", "+54 11 9796-8021", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 85220626, "Lisandro", "Lopez", 1, LocalDate.of(1989, 9, 1), "Su casa 5", "llopez@mail.com", "+54 11 8553-4509", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98672345, "Carlos", "Zambrano", 1, LocalDate.of(1989, 7, 10), "Su casa 6", "czambrano@mail.com", "+54 11 7840-6406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64051816, "Frank", "Fabra", 1, LocalDate.of(1991, 2, 22), "Su casa 7", "ffabra@mail.com", "+54 11 4282-5377", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 19703542, "Valentin", "Barco", 1, LocalDate.of(2004, 7, 23), "Su casa 8", "vbarco@mail.com", "+54 11 7574-4028", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 88941666, "Marcelo", "Weigandt", 1, LocalDate.of(2000, 1, 11), "Su casa 9", "mweigandt@mail.com", "+54 11 2016-5915", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 91867074, "Luis", "Advincula", 1, LocalDate.of(1990, 3, 2), "Su casa 10", "ladvincula@mail.com", "+54 11 2042-7052", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 97678613, "Alan", "Varela", 1, LocalDate.of(2001, 7, 4), "Su casa 11", "avarela@mail.com", "+54 11 1142-3898", "1234");
            //-----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13867761, "Colin", "Spence", 1, LocalDate.of(1978, 6, 24), "Su casa 1", "zsFXC6GR@mail.com", "+54 11 1928-1339", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81655996, "Tyrese", "Matthews", 1, LocalDate.of(1995, 8, 21), "Su casa 2", "2DtAv@mail.com", "+54 11 6258-7830", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10199253, "Travis", "Mills", 1, LocalDate.of(1988, 11, 3), "Su casa 3", "pcnyiqR@mail.com", "+54 11 2884-7437", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 94429276, "Tyree", "Curtis", 1, LocalDate.of(1990, 3, 20), "Su casa 4", "BdN1@mail.com", "+54 11 9796-8021", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 15761111, "Aryan", "Wiggins", 1, LocalDate.of(1989, 9, 1), "Su casa 5", "u4u@mail.com", "+54 11 8553-4509", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 38065045, "Immanuel", "Duffy", 1, LocalDate.of(1989, 7, 10), "Su casa 6", "7l1f@mail.com", "+54 11 7840-6406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75720514, "Malachi", "Pena", 1, LocalDate.of(1991, 2, 22), "Su casa 7", "k5o9r5y@mail.com", "+54 11 4282-5377", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 80334438, "Keegan", "Serrano", 1, LocalDate.of(2004, 7, 23), "Su casa 8", "Dl8kE@mail.com", "+54 11 7574-4028", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 82637671, "Gauge", "Sanders", 1, LocalDate.of(2000, 1, 11), "Su casa 9", "Y3jqfj@mail.com", "+54 11 2016-5915", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75911334, "Nicholas", "Baird", 1, LocalDate.of(1990, 3, 2), "Su casa 10", "E7OB@mail.com", "+54 11 2042-7052", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 27471536, "Damari", "Kirby", 1, LocalDate.of(2001, 7, 4), "Su casa 11", "Brt@mail.com", "+54 11 1142-3898", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31403600, "Chance", "Miles", 1, LocalDate.of(1978, 6, 24), "Su casa 1", "R2L6@mail.com", "+54 11 1928-1339", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 55616276, "Armando", "Day", 1, LocalDate.of(1995, 8, 21), "Su casa 2", "mc151@mail.com", "+54 11 6258-7830", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23321704, "Malachi", "Johns", 1, LocalDate.of(1988, 11, 3), "Su casa 3", "1V12@mail.com", "+54 11 2884-7437", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 19193231, "Hayden", "Hall", 1, LocalDate.of(1990, 3, 20), "Su casa 4", "FoT@mail.com", "+54 11 9796-8021", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 26775361, "Maximus", "Herrera", 1, LocalDate.of(1989, 9, 1), "Su casa 5", "XBE@mail.com", "+54 11 8553-4509", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 66545712, "Myles", "Rangel", 1, LocalDate.of(1989, 7, 10), "Su casa 6", "315ULqWP@mail.com", "+54 11 7840-6406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 74635714, "David", "Newton", 1, LocalDate.of(1991, 2, 22), "Su casa 7", "mYxPzWC1@mail.com", "+54 11 4282-5377", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 71951158, "Baron", "Orozco", 1, LocalDate.of(2004, 7, 23), "Su casa 8", "79oD0Q@mail.com", "+54 11 7574-4028", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 63411585, "Michael", "Combs", 1, LocalDate.of(2000, 1, 11), "Su casa 9", "ZfM12r@mail.com", "+54 11 2016-5915", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 26031665, "Weston", "Wiggins", 1, LocalDate.of(1990, 3, 2), "Su casa 10", "Xz4Wow@mail.com", "+54 11 2042-7052", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98039051, "Lyric", "Reilly", 1, LocalDate.of(2001, 7, 4), "Su casa 11", "rSG0yAJ@mail.com", "+54 11 1142-3898", "1234");
            //------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13054736, "Nehemiah", "Watson", 1, LocalDate.of(1978, 6, 24), "Su casa 1", "hN36@mail.com", "+54 11 1928-1339", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35276106, "Cason", "Saunders", 1, LocalDate.of(1995, 8, 21), "Su casa 2", "2lE5U@mail.com", "+54 11 6258-7830", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 56924432, "Warren", "Knox", 1, LocalDate.of(1988, 11, 3), "Su casa 3", "iVMfB8@mail.com", "+54 11 2884-7437", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 71208620, "Tyrese", "Thomas", 1, LocalDate.of(1990, 3, 20), "Su casa 4", "kApOVD0@mail.com", "+54 11 9796-8021", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30443545, "Mohamed", "Olsen", 1, LocalDate.of(1989, 9, 1), "Su casa 5", "f9K@mail.com", "+54 11 8553-4509", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 94127122, "Ishaan", "Clay", 1, LocalDate.of(1989, 7, 10), "Su casa 6", "Q3Hz@mail.com", "+54 11 7840-6406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 26216094, "Cordell", "Cummings", 1, LocalDate.of(1991, 2, 22), "Su casa 7", "1w6j@mail.com", "+54 11 4282-5377", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30831068, "Davis", "Mcdonald", 1, LocalDate.of(2004, 7, 23), "Su casa 8", "LJJ68@mail.com", "+54 11 7574-4028", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64405973, "Jayden", "Tanner", 1, LocalDate.of(2000, 1, 11), "Su casa 9", "JY2VI@mail.com", "+54 11 2016-5915", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 50948479, "August", "Morton", 1, LocalDate.of(1990, 3, 2), "Su casa 10", "KEa@mail.com", "+54 11 2042-7052", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64911109, "Quentin", "Steele", 1, LocalDate.of(2001, 7, 4), "Su casa 11", "Qz05u@mail.com", "+54 11 1142-3898", "1234");


            //RIVER 12 - 23
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30458741, "Marcelo Daniel", "Gallardo", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "mgallardo@mail.com", "+54 11 1945-6216", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31587652, "Franco", "Armani", 2, LocalDate.of(1986, 10, 16), "Su casa 12", "farmani@mail.com", "+54 11 8372-6286", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 76468954, "Paulo", "Diaz", 2, LocalDate.of(1994, 8, 25), "Su casa 13", "pdiaz@mail.com", "+54 11 1850-6703", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 73927657, "David", "Martinez", 2, LocalDate.of(1998, 1, 21), "Su casa 14", "dmartinez@mail.com", "+54 11 2865-9858", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 33411994, "Robert", "Rojas", 2, LocalDate.of(1996, 4, 30), "Su casa 15", "rrojas@mail.com", "+54 11 2160-9584", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 99736264, "Javier", "Pinola", 2, LocalDate.of(1983, 2, 24), "Su casa 16", "jpinola@mail.com", "+54 11 6839-4948", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 77657557, "Jonatan", "Maidana", 2, LocalDate.of(1985, 7, 29), "Su casa 17", "jmaidana@mail.com", "+54 11 6838-1240", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 17561691, "Milton", "Casco", 2, LocalDate.of(1988, 4, 11), "Su casa 18", "mcasco@mail.com", "+54 11 3813-4036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 33470348, "Enzo", "Perez", 2, LocalDate.of(1989, 2, 22), "Su casa 19", "eperez@mail.com", "+54 11 5635-7409", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 41563870, "Bruno", "Zuculini", 2, LocalDate.of(1993, 4, 2), "Su casa 20", "bzuculini@mail.com", "+54 11 7037-2077", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40219851, "Leonardo", "Ponzio", 2, LocalDate.of(1982, 1, 29), "Su casa 21", "lponzio@mail.com", "+54 11 4764-8036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 76202349, "Nicolas", "De La Cruz", 2, LocalDate.of(1997, 6, 1), "Su casa 22", "ndelacruz@mail.com", "+54 11 8012-4099", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 11946977, "Carmelo", "Mccullough", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "5991qb@mail.com", "+54 11 1945-6216", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 34664593, "Charles", "Perry", 2, LocalDate.of(1986, 10, 16), "Su casa 12", "MMa@mail.com", "+54 11 8372-6286", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 77265177, "Carmelo", "Molina", 2, LocalDate.of(1994, 8, 25), "Su casa 13", "f3B@mail.com", "+54 11 1850-6703", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35054304, "Jacob", "Pena", 2, LocalDate.of(1998, 1, 21), "Su casa 14", "mJcIY5@mail.com", "+54 11 2865-9858", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 24851137, "Brian", "Fox", 2, LocalDate.of(1996, 4, 30), "Su casa 15", "s7PkhOA@mail.com", "+54 11 2160-9584", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83624026, "Royce", "Wallace", 2, LocalDate.of(1983, 2, 24), "Su casa 16", "ubvA@mail.com", "+54 11 6839-4948", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81364372, "Brenden", "Bush", 2, LocalDate.of(1985, 7, 29), "Su casa 17", "NQ5@mail.com", "+54 11 6838-1240", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13347892, "Connor", "Nichols", 2, LocalDate.of(1988, 4, 11), "Su casa 18", "PdC@mail.com", "+54 11 3813-4036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86641323, "Mathias", "Watkins", 2, LocalDate.of(1989, 2, 22), "Su casa 19", "7BSZe@mail.com", "+54 11 5635-7409", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 66232397, "Davis", "Welch", 2, LocalDate.of(1993, 4, 2), "Su casa 20", "d86@mail.com", "+54 11 7037-2077", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 62983617, "Hayden", "Nguyen", 2, LocalDate.of(1982, 1, 29), "Su casa 21", "lc8L@mail.com", "+54 11 4764-8036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 11609873, "Yandel", "Forbes", 2, LocalDate.of(1997, 6, 1), "Su casa 22", "JfrXjq@mail.com", "+54 11 8012-4099", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 32545070, "Izaiah", "Rice", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "26JV2@mail.com", "+54 11 1945-6216", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 29319924, "Connor", "Brown", 2, LocalDate.of(1986, 10, 16), "Su casa 12", "1a8jNx9G@mail.com", "+54 11 8372-6286", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 97276928, "Arthur", "Burgess", 2, LocalDate.of(1994, 8, 25), "Su casa 13", "zqOq6r@mail.com", "+54 11 1850-6703", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44175560, "Zackary", "Palmer", 2, LocalDate.of(1998, 1, 21), "Su casa 14", "CaR07@mail.com", "+54 11 2865-9858", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 12912581, "Kendrick", "Rubio", 2, LocalDate.of(1996, 4, 30), "Su casa 15", "545Z@mail.com", "+54 11 2160-9584", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 85690094, "Uriel", "Campos", 2, LocalDate.of(1983, 2, 24), "Su casa 16", "0qnmY@mail.com", "+54 11 6839-4948", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 27255415, "Issac", "Sexton", 2, LocalDate.of(1985, 7, 29), "Su casa 17", "Zi0JVD5@mail.com", "+54 11 6838-1240", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 25542817, "Marquise", "Conrad", 2, LocalDate.of(1988, 4, 11), "Su casa 18", "5BJPcSg8@mail.com", "+54 11 3813-4036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 12704455, "August", "Osborne", 2, LocalDate.of(1989, 2, 22), "Su casa 19", "VxXEIW@mail.com", "+54 11 5635-7409", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36530682, "Weston", "Spencer", 2, LocalDate.of(1993, 4, 2), "Su casa 20", "8dUo6@mail.com", "+54 11 7037-2077", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 14842466, "Urijah", "Sellers", 2, LocalDate.of(1982, 1, 29), "Su casa 21", "7uoTi7@mail.com", "+54 11 4764-8036", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86364782, "Tyrell", "Hamilton", 2, LocalDate.of(1997, 6, 1), "Su casa 22", "AW19X7p@mail.com", "+54 11 8012-4099", "1234");

            //RACING 24 - 32
            ControladorJugadores.getInstancia().agregarJugador("DNI", 59424211, "Gabriel", "Arias", 3, LocalDate.of(1987, 9, 13), "su casa 23", "garias@mail.com", "+54 11 3151-4751", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75473477, "Gaston", "Gomez", 3, LocalDate.of(1996, 3, 4), "su casa 24", "ggomez@mail.com", "+54 11 4543-6615", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 15913806, "Diego", "Milito", 3, LocalDate.of(1998, 2, 19), "su casa 25", "mtagliamonte@mail.com", "+54 11 2960-8836", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37035851, "Imanol", "Segovia", 3, LocalDate.of(2001, 2, 6), "su casa 26", "isegovia@mail.com", "+54 11 6649-1475", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 67575649, "Nery", "Dominguez", 3, LocalDate.of(1990, 4, 9), "su casa 27", "ndominguez@mail.com", "+54 11 8845-0104", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 46882459, "Leonardo", "Sigali", 3, LocalDate.of(1987, 5, 29), "su casa 28", "lsigali@mail.com", "+54 11 5346-5580", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23512502, "Lucas", "Orban", 3, LocalDate.of(1989, 2, 3), "su casa 29", "lorban@mail.com", "+54 11 3217-4261", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 27078447, "Joaquin", "Novillo", 3, LocalDate.of(1998, 2, 19), "su casa 30", "jnovillo@mail.com", "+54 11 7265-8614", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 53737840, "Mauricio", "Martinez", 3, LocalDate.of(1993, 2, 20), "su casa 31", "mmartinez@mail.com", "+54 11 8055-8220", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 82880152, "Kendrick", "Mendez", 3, LocalDate.of(1987, 9, 13), "su casa 23", "9De@mail.com", "+54 11 3151-4751", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 12142613, "Davis", "Nichols", 3, LocalDate.of(1996, 3, 4), "su casa 24", "Nbb@mail.com", "+54 11 4543-6615", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 78451886, "Jayden", "Parks", 3, LocalDate.of(1998, 2, 19), "su casa 25", "4V2hdCJ@mail.com", "+54 11 2960-8836", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 72223754, "Randall", "Pierce", 3, LocalDate.of(2001, 2, 6), "su casa 26", "YodH14A@mail.com", "+54 11 6649-1475", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 59083527, "Russell", "Fowler", 3, LocalDate.of(1990, 4, 9), "su casa 27", "LiSz5lSz@mail.com", "+54 11 8845-0104", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 38537587, "Royce", "Becker", 3, LocalDate.of(1987, 5, 29), "su casa 28", "5Vsw@mail.com", "+54 11 5346-5580", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61485656, "Brenden", "Schaefer", 3, LocalDate.of(1989, 2, 3), "su casa 29", "d98@mail.com", "+54 11 3217-4261", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40954751, "Baron", "Bradshaw", 3, LocalDate.of(1998, 2, 19), "su casa 30", "PZla@mail.com", "+54 11 7265-8614", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 19020669, "Wade", "Aguilar", 3, LocalDate.of(1993, 2, 20), "su casa 31", "m2YWW@mail.com", "+54 11 8055-8220", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 46203608, "James", "Burgess", 3, LocalDate.of(1987, 9, 13), "su casa 23", "yOaT@mail.com", "+54 11 3151-4751", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 69782930, "Leon", "Mccarty", 3, LocalDate.of(1996, 3, 4), "su casa 24", "J0rqxd@mail.com", "+54 11 4543-6615", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 69474689, "Armando", "Mason", 3, LocalDate.of(1998, 2, 19), "su casa 25", "q1ad@mail.com", "+54 11 2960-8836", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21514162, "Dante", "Bridges", 3, LocalDate.of(2001, 2, 6), "su casa 26", "JTIjrAr@mail.com", "+54 11 6649-1475", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 95146959, "Steve", "Clay", 3, LocalDate.of(1990, 4, 9), "su casa 27", "G872H@mail.com", "+54 11 8845-0104", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 59117891, "Kristopher", "Roth", 3, LocalDate.of(1987, 5, 29), "su casa 28", "lYLE@mail.com", "+54 11 5346-5580", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98419744, "Bryson", "Sharp", 3, LocalDate.of(1989, 2, 3), "su casa 29", "l0q6K9N@mail.com", "+54 11 3217-4261", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75113386, "Carmelo", "Dixon", 3, LocalDate.of(1998, 2, 19), "su casa 30", "GSCv88J@mail.com", "+54 11 7265-8614", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61687763, "Asher", "Yang", 3, LocalDate.of(1993, 2, 20), "su casa 31", "MFD@mail.com", "+54 11 8055-8220", "1234");


            //INDEPENDIENTE 33 - 47
            ControladorJugadores.getInstancia().agregarJugador("DNI", 28754213, "Ricardo Enrique", "Bochini", 4, LocalDate.of(1954, 1, 25), "Su casa 32", "rbochini@mail.com", "+54 11 3212-6740", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86947307, "Sebastian", "Sosa", 4, LocalDate.of(1986, 8, 19), "Su casa 33", "ssosa@mail.com", "+54 11 4967-5743", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 63110117, "Milton", "Alvarez", 4, LocalDate.of(1989, 1, 26), "Su casa 34", "malvares@mail.com", "+54 11 3951-2326", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 41916667, "Renzo", "Bacchia", 4, LocalDate.of(1999, 1, 23), "Su casa 35", "rbacchia@mail.com", "+54 11 3340-9927", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 55047867, "Sergio", "Barreto", 4, LocalDate.of(1999, 1, 24), "Su casa 36", "sbarreto@mail.com", "+54 11 4888-9037", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61879086, "Joaquin", "Laso", 4, LocalDate.of(1990, 7, 4), "Su casa 37", "jlaso@mail.com", "+54 11 7482-2266", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 11721073, "Juan Manuel", "Insaurralde", 4, LocalDate.of(1984, 10, 3), "Su casa 38", "jminsaurralde@mail.com", "+54 11 6757-1865", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 15651148, "Ezequiel", "Munoz", 4, LocalDate.of(1990, 10, 8), "Su casa 39", "emunoz@mail.com", "+54 11 7159-6606", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 22655071, "Ayrton", "Costa", 4, LocalDate.of(1999, 7, 12), "Su casa 40", "acosta@mail.com", "+54 11 2719-4038", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 51690492, "Patricio", "Ostachuk", 4, LocalDate.of(2000, 5, 5), "Su casa 41", "postachuk@mail.com", "+54 11 2141-7894", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31706178, "Lucas", "Rodriguez", 4, LocalDate.of(1993, 9, 27), "Su casa 42", "lrodriguez@mail.com", "+54 11 5978-5956", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23951804, "Thomas", "Ortega", 4, LocalDate.of(2000, 12, 6), "Su casa 43", "tortega@mail.com", "+54 11 9462-3566", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21426709, "Fabricio", "Bustos", 4, LocalDate.of(1996, 4, 28), "Su casa 44", "fbustos@mail.com", "+54 11 2061-1465", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 17214787, "Gonzalo", "Asis", 4, LocalDate.of(1996, 3, 28), "Su casa 45", "gasis@mail.com", "+54 11 3601-3364", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 56553617, "Lucas", "Romero", 4, LocalDate.of(1994, 4, 18), "Su casa 46", "lromero@mail.com", "+54 11 7380-8024", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23571013, "Brady", "Horton", 4, LocalDate.of(1954, 1, 25), "Su casa 32", "Cf8U5k7c98Ea@mail.com", "+54 11 3212-6740", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 15104842, "Deegan", "Huynh", 4, LocalDate.of(1986, 8, 19), "Su casa 33", "54Ozq20@mail.com", "+54 11 4967-5743", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 88684978, "Kayden", "Preston", 4, LocalDate.of(1989, 1, 26), "Su casa 34", "p8R8zRIyHA@mail.com", "+54 11 3951-2326", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64900797, "Marcus", "Farrell", 4, LocalDate.of(1999, 1, 23), "Su casa 35", "shym4Mu8m@mail.com", "+54 11 3340-9927", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 69562453, "Yahir", "Adams", 4, LocalDate.of(1999, 1, 24), "Su casa 36", "0Ri4pVGKKC@mail.com", "+54 11 4888-9037", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 96817577, "Maximus", "Day", 4, LocalDate.of(1990, 7, 4), "Su casa 37", "auPMrY9Z@mail.com", "+54 11 7482-2266", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64767138, "Mohamed", "Hatfield", 4, LocalDate.of(1984, 10, 3), "Su casa 38", "CSe2zqDkXOE@mail.com", "+54 11 6757-1865", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31442228, "Ezekiel", "Bird", 4, LocalDate.of(1990, 10, 8), "Su casa 39", "1blwcFz9@mail.com", "+54 11 7159-6606", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 34467519, "Braedon", "Sharp", 4, LocalDate.of(1999, 7, 12), "Su casa 40", "17T5ummdFlD@mail.com", "+54 11 2719-4038", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47850402, "Quincy", "Tucker", 4, LocalDate.of(2000, 5, 5), "Su casa 41", "bQNEb2Q6072@mail.com", "+54 11 2141-7894", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 91947239, "Jonah", "Mcpherson", 4, LocalDate.of(1993, 9, 27), "Su casa 42", "ut62a@mail.com", "+54 11 5978-5956", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 52219996, "Jean", "Ortiz", 4, LocalDate.of(2000, 12, 6), "Su casa 43", "tq6IJd@mail.com", "+54 11 9462-3566", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44059519, "Braiden", "Walker", 4, LocalDate.of(1996, 4, 28), "Su casa 44", "JGDi2BU@mail.com", "+54 11 2061-1465", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92624904, "Branden", "Kaiser", 4, LocalDate.of(1996, 3, 28), "Su casa 45", "r4H4@mail.com", "+54 11 3601-3364", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 27194180, "Kasey", "Aguilar", 4, LocalDate.of(1994, 4, 18), "Su casa 46", "6QxXU56@mail.com", "+54 11 7380-8024", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 39544367, "Kareem", "Clay", 4, LocalDate.of(1954, 1, 25), "Su casa 32", "VbK6e@mail.com", "+54 11 3212-6740", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98704494, "Baron", "Holmes", 4, LocalDate.of(1986, 8, 19), "Su casa 33", "FB9dW@mail.com", "+54 11 4967-5743", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31544484, "Jean", "Cain", 4, LocalDate.of(1989, 1, 26), "Su casa 34", "3A2@mail.com", "+54 11 3951-2326", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 33282095, "Coleman", "Fuller", 4, LocalDate.of(1999, 1, 23), "Su casa 35", "Gze6@mail.com", "+54 11 3340-9927", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81686313, "Tyrell", "Howard", 4, LocalDate.of(1999, 1, 24), "Su casa 36", "y0d6m6N@mail.com", "+54 11 4888-9037", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 18633462, "Zack", "Leblanc", 4, LocalDate.of(1990, 7, 4), "Su casa 37", "q1t9PENrs2Dw@mail.com", "+54 11 7482-2266", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 62320979, "Hayden", "Freeman", 4, LocalDate.of(1984, 10, 3), "Su casa 38", "7BJTYVQpfIE2@mail.com", "+54 11 6757-1865", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36735501, "Malachi", "Foley", 4, LocalDate.of(1990, 10, 8), "Su casa 39", "T5fiKHytg@mail.com", "+54 11 7159-6606", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21521125, "Rohan", "Clay", 4, LocalDate.of(1999, 7, 12), "Su casa 40", "0J71h29n1kI0@mail.com", "+54 11 2719-4038", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 28000529, "Alfredo", "Estes", 4, LocalDate.of(2000, 5, 5), "Su casa 41", "H81G@mail.com", "+54 11 2141-7894", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 77140206, "Gauge", "Preston", 4, LocalDate.of(1993, 9, 27), "Su casa 42", "2sKlmMSRLi9I@mail.com", "+54 11 5978-5956", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37727482, "Immanuel", "Burch", 4, LocalDate.of(2000, 12, 6), "Su casa 43", "oB5auR79NxFt@mail.com", "+54 11 9462-3566", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 32503252, "Bryson", "Stone", 4, LocalDate.of(1996, 4, 28), "Su casa 44", "F9MF@mail.com", "+54 11 2061-1465", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 52922700, "Braiden", "Durham", 4, LocalDate.of(1996, 3, 28), "Su casa 45", "pzeM4MF1E7Eb@mail.com", "+54 11 3601-3364", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30420416, "Michael", "Ibarra", 4, LocalDate.of(1994, 4, 18), "Su casa 46", "uituQ8@mail.com", "+54 11 7380-8024", "1234");

            //SAN LORENZO 48 - 53
            ControladorJugadores.getInstancia().agregarJugador("DNI", 46030499, "Alfred", "Batalla", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "abatalla@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 78619719, "Branden", "Torrico", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "storrico@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83530012, "Gustavo", "Flores", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "fflores@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 67895002, "Tony", "Gatoni", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "fgatoni@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47377762, "Finley", "Donatti", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "adonatti@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40502465, "Chance", "Peruzzi", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "gperuzzi@mail.com", "+54 11 1471-7022", "1234");
            //---------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 66195478, "Braxton", "Pacheco", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "MEaz@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36802264, "Dax", "Wyatt", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "V0q@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 29914535, "Curtis", "Horn", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "faeZ2@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81361257, "Kian", "Freeman", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "36XhWFNlC@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61858751, "Deacon", "Pratt", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "mhp@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 87312818, "Izaiah", "Petty", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "WVf5@mail.com", "+54 11 1471-7022", "1234");
            //---------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 53655732, "Yandel", "Whitney", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "cHKUD6g@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30131251, "Connor", "Strong", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "2l6@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 32084335, "Charles", "Trujillo", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "h0R3@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 74852592, "Zackary", "Macias", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "Bj4XZ4FKd@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44740416, "Daniel", "Mccall", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "008@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 91094231, "Landen", "Tucker", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "7mv@mail.com", "+54 11 1471-7022", "1234");
            //---------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13182097, "Dallas", "Nixon", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "fPgqsHLcvw89@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 91727307, "Deven", "Kirby", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "sN3w@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21817697, "Leonard", "Chang", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "Ywp44ab@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13262291, "Chance", "King", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "IS38cOj0F@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 74887634, "Issac", "Garza", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "UMhB2QxRd@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83806354, "Yandel", "Mahoney", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "ooqQ@mail.com", "+54 11 1471-7022", "1234");
            //---------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 71321475, "Rocco", "Herrera", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "7H2em5F@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23993115, "Yandel", "Calderon", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "2Ao1m@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13526430, "Alfredo", "Bush", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "Z3oUb@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 73685778, "Lyric", "Dorsey", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "6r0833PEU@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 74108127, "Charles", "Glenn", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "Oz5IePo9L@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 70233905, "Walker", "Harris", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "2y2ThkSGb@mail.com", "+54 11 1471-7022", "1234");

            //FERRO 54 - 59
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36875123, "Luis Angel", "Salmeron", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "lsalmeron@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44534244, "Juan", "Perez", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "jperez@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 53026193, "Pedro", "Gomez", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "pgomez@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 99901795, "Alejandro", "Giordanengo", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "agiordanengo@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 78549602, "Nicolas", "Pandolfi", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "npandolfi@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 93742159, "Esteban", "Carnicer", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "ecarnicer@mail.com", "+54 11 7391-5913", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40084181, "Leon", "House", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "mJ0w86vPx@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 39584716, "Johnathon", "Welch", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "PPV0t2QQwOc@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40776112, "Lyric", "Choi", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "3GHAq2H3224@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 32921063, "Moshe", "Boyer", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "wIW@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47635956, "Aditya", "Hamilton", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "MIm1J3SlZ@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86227259, "Conor", "Medina", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "AHD@mail.com", "+54 11 7391-5913", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 22632976, "Weston", "Ryan", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "131tZuQ1f@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 48466276, "Emmanuel", "Saunders", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "Lb3pBj@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 11691519, "Jacob", "Lester", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "9MC7M@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 29210777, "Nehemiah", "Valentine", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "0cSt@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 50516955, "Lorenzo", "Morris", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "5sh59@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83671482, "James", "Yang", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "drFH48@mail.com", "+54 11 7391-5913", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 96928841, "Mohamed", "Clements", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "TT35WV1lR@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75393664, "Baron", "Carey", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "1h2l15L@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 79642010, "Dax", "Vazquez", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "mUnKHzKIv1F@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 25657333, "Donald", "Nguyen", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "eKEKOW4l@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 17493973, "Tyrese", "Patel", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "26v63EOM0@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 20388652, "Chance", "Liu", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "0XXQgK@mail.com", "+54 11 7391-5913", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 69176217, "Alonzo", "Weber", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "RKmT2AouS@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 51062950, "Wade", "Burch", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "K8lHII0xQx@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 62869788, "Cordell", "Page", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "7I8x@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92416057, "Nehemiah", "Matthews", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "dN4@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 57448626, "Jack", "Knox", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "4yopV@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98138665, "Bryson", "Henson", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "65rF@mail.com", "+54 11 7391-5913", "1234");


            //BANFIELD 60 - 64
            ControladorJugadores.getInstancia().agregarJugador("DNI", 58029954, "James David", "Rodriguez", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "jrodriguez@mail.com", "+54 11 2217-7713", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92149154, "Facundo", "Altamirano", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "faltamirano@mail.com", "+54 11 2932-0700", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 58698841, "Gregorio", "Tanco", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "gtanco@mail.com", "+54 11 3834-2003", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 97471727, "Alexis", "Maldonado", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "amaldonado@mail.com", "+54 11 9379-3762", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81923228, "Luciano", "Lollo", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "llollo@mail.com", "+54 11 8502-0749", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37861041, "Ishaan", "Villegas", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "UxFjqr1fK@mail.com", "+54 11 2217-7713", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92124358, "Deven", "Robertson", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "KFpqG@mail.com", "+54 11 2932-0700", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 95602405, "Issac", "Murray", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "O6a@mail.com", "+54 11 3834-2003", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13684689, "Carmelo", "Mendez", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "2sDF1Ev@mail.com", "+54 11 9379-3762", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 80164146, "Charles", "Rhodes", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "jQ4FZQ5ovaql@mail.com", "+54 11 8502-0749", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 57579021, "Carmelo", "Mccullough", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "0kiZUaoCI@mail.com", "+54 11 2217-7713", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30966620, "Damari", "Simon", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "8yJbo@mail.com", "+54 11 2932-0700", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 25839370, "Leon", "Rodgers", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "bYA@mail.com", "+54 11 3834-2003", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 20379914, "Zaid", "Rosario", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "iSG@mail.com", "+54 11 9379-3762", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86010015, "Marquise", "Casey", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "2GD1BIBDIh@mail.com", "+54 11 8502-0749", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44522162, "Connor", "Rodgers", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "BCOWKa@mail.com", "+54 11 2217-7713", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 96545252, "Tristen", "Shea", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "LCs@mail.com", "+54 11 2932-0700", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47305193, "Urijah", "Townsend", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "0giLJp@mail.com", "+54 11 3834-2003", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23325891, "Johnathon", "Larsen", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "pfHiT4R80wM@mail.com", "+54 11 9379-3762", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 91534112, "Alfredo", "Duke", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "DJLJLOhEKDq2@mail.com", "+54 11 8502-0749", "1234");
            //---


            //DEFENSA Y JUSTICIA 65-72

            ControladorJugadores.getInstancia().agregarJugador("DNI", 12548754, "Washington", "Camacho", 8, LocalDate.of(1991, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 48050393, "Nelson", "Acevedo", 8, LocalDate.of(1990, 11, 16), "Su casa 8099", "9rh23huraEi@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 89977696, "Mati", "Rojas", 8, LocalDate.of(1993, 11, 16), "Su casa 8099", "62q54nWywY@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 61461270, "Facha", "Gutierrez", 8, LocalDate.of(1994, 11, 16), "Su casa 8099", "a6XN@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64460412, "Brian", "Fernandez", 8, LocalDate.of(1993, 12, 16), "Su casa 8099", "889@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 72289215, "Hermano de Brian", "Fernandez", 8, LocalDate.of(1991, 7, 16), "Su casa 8099", "k42oA27KzzA@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 14350438, "El Defensa", "Defensor", 8, LocalDate.of(1990, 9, 16), "Su casa 8099", "8QA52o82Ik7T@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 49082765, "Yo", "Nueve de Area", 8, LocalDate.of(1993, 10, 16), "Su casa 8099", "4tY75aPlG3@mail.com", "+54 11 1303-9702", "1234");
            //-------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 60722526, "Deegan", "Marshall", 8, LocalDate.of(1991, 11, 16), "Su casa 8099", "486I7C1@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 82181230, "Kayden", "Stanton", 8, LocalDate.of(1990, 11, 16), "Su casa 8099", "d39vld7Vmcp@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 63684777, "Houston", "Wilkerson", 8, LocalDate.of(1993, 11, 16), "Su casa 8099", "Obmx85Hz7oe4@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 76793759, "Zaid", "Durham", 8, LocalDate.of(1994, 11, 16), "Su casa 8099", "Aq10@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 98326655, "Braiden", "Dodson", 8, LocalDate.of(1993, 12, 16), "Su casa 8099", "84U79KeD@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 22538216, "Tyrone", "Browning", 8, LocalDate.of(1991, 7, 16), "Su casa 8099", "8Tlm@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 49798809, "Randall", "Yang", 8, LocalDate.of(1990, 9, 16), "Su casa 8099", "9apbIb1tA5V@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 45582670, "Austin", "Nguyen", 8, LocalDate.of(1993, 10, 16), "Su casa 8099", "i2OuJ@mail.com", "+54 11 1303-9702", "1234");
            //-------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81758631, "Daniel", "Kelly", 8, LocalDate.of(1991, 11, 16), "Su casa 8099", "3PI7qY6@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47112297, "Kyler", "Guerra", 8, LocalDate.of(1990, 11, 16), "Su casa 8099", "qAXLYa88yLx@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 43044574, "Russell", "Nguyen", 8, LocalDate.of(1993, 11, 16), "Su casa 8099", "baLNLZeiwa@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 80583290, "Cason", "Doyle", 8, LocalDate.of(1994, 11, 16), "Su casa 8099", "HXfbB@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83270727, "Walker", "Chapman", 8, LocalDate.of(1993, 12, 16), "Su casa 8099", "1IONkmZi4@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 90444728, "Leonidas", "Valdez", 8, LocalDate.of(1991, 7, 16), "Su casa 8099", "ge8lecNX@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 68149879, "Yandel", "Page", 8, LocalDate.of(1990, 9, 16), "Su casa 8099", "4Tww4hUF6O98@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 43374267, "Alonzo", "Wright", 8, LocalDate.of(1993, 10, 16), "Su casa 8099", "XD79d4JiB2R@mail.com", "+54 11 1303-9702", "1234");
            //-------
            ControladorJugadores.getInstancia().agregarJugador("DNI", 27722093, "Mateo", "Lester", 8, LocalDate.of(1991, 11, 16), "Su casa 8099", "SEHlCRiE@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 85378700, "Kolby", "Underwood", 8, LocalDate.of(1990, 11, 16), "Su casa 8099", "OxduEvJ6zdP0@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 64297683, "Leon", "Flynn", 8, LocalDate.of(1993, 11, 16), "Su casa 8099", "A900H1@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 80348185, "Jack", "Ferrell", 8, LocalDate.of(1994, 11, 16), "Su casa 8099", "PF5MnPUCUiv@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 49523218, "Braedon", "Wolf", 8, LocalDate.of(1993, 12, 16), "Su casa 8099", "L0m5SbMR0b5@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 73997998, "Victor", "Odom", 8, LocalDate.of(1991, 7, 16), "Su casa 8099", "T3pfw@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 72453366, "Deangelo", "Schaefer", 8, LocalDate.of(1990, 9, 16), "Su casa 8099", "I5824cQw@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 54594734, "Royce", "Dougherty", 8, LocalDate.of(1993, 10, 16), "Su casa 8099", "AZf@mail.com", "+54 11 1303-9702", "1234");
            //-------

            //INTER 73 - 90
            ControladorJugadores.getInstancia().agregarJugador("DNI", 93497503, "Diego Alberto", "Milito", 9, LocalDate.of(1979, 6, 12), "Su casa 22", "dmilito@mail.com", "+54 11 5930-6875", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 17110900, "Samir", "Handanovic", 9, LocalDate.of(1984, 7, 14), "Su casa 4002", "shandanovic@mail.com", "+54 11 5635-8574", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 88241271, "Milan", "Skriniar", 9, LocalDate.of(1995, 2, 11), "Su casa 8362", "mskriniar@mail.com", "+54 11 9830-5406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 65660187, "Alessandro", "Bastoni", 9, LocalDate.of(1999, 4, 13), "Su casa 3775", "abastoni@mail.com", "+54 11 8048-9715", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81412861, "Stefan", "De Vrij", 9, LocalDate.of(1992, 2, 5), "Su casa 8769", "sdevrij@mail.com", "+54 11 3316-7343", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 87978298, "Aleksandar", "Kolarov", 9, LocalDate.of(1985, 11, 10), "Su casa 822", "akolarov@mail.com", "+54 11 6438-6574", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Marcelo", "Brozovic", 9, LocalDate.of(1992, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 56936715, "Nicolo", "Barella", 9, LocalDate.of(1997, 2, 7), "Su casa 5715", "nbarella@mail.com", "+54 11 8081-7598", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21885890, "Roberto", "Gagliardini", 9, LocalDate.of(1994, 4, 7), "Su casa 5647", "rgagliardini@mail.com", "+54 11 5417-1072", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 54285773, "Matias", "Vecino", 9, LocalDate.of(1991, 8, 24), "Su casa 8519", "mvecino@mail.com", "+54 11 8112-2505", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 85358523, "Arturo", "Vidal", 9, LocalDate.of(1987, 5, 22), "Su casa 9204", "avidal@mail.com", "+54 11 1611-5356", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 38185802, "Denzel", "Dumfries", 9, LocalDate.of(1996, 4, 18), "Su casa 7620", "ddumfries@mail.com", "+54 11 2114-2884", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 84748359, "Ivan", "Perisic", 9, LocalDate.of(1989, 2, 2), "Su casa 1685", "iperisic@mail.com", "+54 11 1256-5249", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 43899977, "Christian", "Eriksen", 9, LocalDate.of(1992, 2, 14), "Su casa 2929", "ceriksen@mail.com", "+54 11 9429-2538", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35341545, "Hakan", "Calhanoglu", 9, LocalDate.of(1994, 2, 8), "Su casa 7808", "hcalhanoglu@mail.com", "+54 11 3579-9514", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47135866, "Joaquin", "Correa", 9, LocalDate.of(1994, 8, 13), "Su casa 8275", "jcorrea@mail.com", "+54 11 6619-5289", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 48672637, "Lautaro", "Martinez", 9, LocalDate.of(1997, 8, 22), "Su casa 1288", "lmartinez@mail.com", "+54 11 8135-4107", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 51394560, "Romelu", "Lukaku", 9, LocalDate.of(1993, 5, 13), "Su casa 8180", "rlukaku@mail.com", "+54 11 6513-2168", "1234");
            //---
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44319083, "Kristopher", "Sweeney", 9, LocalDate.of(1979, 6, 12), "Su casa 22", "ABz@mail.com", "+54 11 5930-6875", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 22939238, "Russell", "Dixon", 9, LocalDate.of(1984, 7, 14), "Su casa 4002", "85NYCeQ58h@mail.com", "+54 11 5635-8574", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 95738798, "Lyric", "Odonnell", 9, LocalDate.of(1995, 2, 11), "Su casa 8362", "M1kjh5FxP@mail.com", "+54 11 9830-5406", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 21852162, "Jayden", "Peterson", 9, LocalDate.of(1999, 4, 13), "Su casa 3775", "hNiUh1RTh@mail.com", "+54 11 8048-9715", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 63658060, "Weston", "Farmer", 9, LocalDate.of(1992, 2, 5), "Su casa 8769", "Yeq@mail.com", "+54 11 3316-7343", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 34855614, "Quentin", "Orr", 9, LocalDate.of(1985, 11, 10), "Su casa 822", "OlrZ5cLlzb@mail.com", "+54 11 6438-6574", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 63177129, "Colin", "Horn", 9, LocalDate.of(1992, 11, 16), "Su casa 8099", "bk9ptfZ7@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 50020670, "Arnav", "Mullen", 9, LocalDate.of(1997, 2, 7), "Su casa 5715", "67g@mail.com", "+54 11 8081-7598", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75217969, "Terrell", "Fritz", 9, LocalDate.of(1994, 4, 7), "Su casa 5647", "8cqgco@mail.com", "+54 11 5417-1072", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 35911837, "Kolby", "Harris", 9, LocalDate.of(1991, 8, 24), "Su casa 8519", "Q3X0tcl@mail.com", "+54 11 8112-2505", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 20478145, "London", "Robertson", 9, LocalDate.of(1987, 5, 22), "Su casa 9204", "7P3WBZ2Ne@mail.com", "+54 11 1611-5356", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 88112782, "Kendrick", "Dawson", 9, LocalDate.of(1996, 4, 18), "Su casa 7620", "usR29tBn2LG6@mail.com", "+54 11 2114-2884", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31819644, "Kolby", "Matthews", 9, LocalDate.of(1989, 2, 2), "Su casa 1685", "7bG9@mail.com", "+54 11 1256-5249", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 51775720, "Terrell", "House", 9, LocalDate.of(1992, 2, 14), "Su casa 2929", "9gs2@mail.com", "+54 11 9429-2538", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 22060487, "Travis", "Briggs", 9, LocalDate.of(1994, 2, 8), "Su casa 7808", "lq8GX0q@mail.com", "+54 11 3579-9514", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 93083176, "Leonidas", "York", 9, LocalDate.of(1994, 8, 13), "Su casa 8275", "al80lsL@mail.com", "+54 11 6619-5289", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 76606891, "Curtis", "Dunn", 9, LocalDate.of(1997, 8, 22), "Su casa 1288", "9UGlI1OEX5@mail.com", "+54 11 8135-4107", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 75578422, "Kian", "Johns", 9, LocalDate.of(1993, 5, 13), "Su casa 8180", "OvqFMrjAnMa2@mail.com", "+54 11 6513-2168", "1234");


            //PSG 91 - 112
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36737643, "Lionel Andres", "Messi", 10, LocalDate.of(1987, 6, 24), "Su casa 4888", "lmessi@mail.com", "+54 11 8341-9359", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 83352880, "Gianluigi", "Donnarumma", 10, LocalDate.of(1999, 2, 25), "Su casa 7569", "gdonnarumma@mail.com", "+54 11 4157-2774", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92847000, "Keylor", "Navas", 10, LocalDate.of(1986, 12, 15), "Su casa 3429", "knavas@mail.com", "+54 11 2688-9081", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 18340039, "Marcos", "Aoas Correa", 10, LocalDate.of(1994, 5, 14), "Su casa 7631", "marquinhos@mail.com", "+54 11 5020-9152", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 94183510, "Presnel", "Kimpembe", 10, LocalDate.of(1995, 8, 13), "Su casa 2722", "pkimpembe@mail.com", "+54 11 6878-6800", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 50784515, "Abdou", "Diallo", 10, LocalDate.of(1996, 5, 4), "Su casa 4292", "adiallo@mail.com", "+54 11 9674-8635", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 66432572, "Thilo", "Kherer", 10, LocalDate.of(1996, 9, 21), "Su casa 1471", "tkherer@mail.com", "+54 11 7518-9420", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 15232475, "Sergio", "Ramos", 10, LocalDate.of(1986, 3, 30), "Su casa 589", "sramos@mail.com", "+54 11 1997-2781", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44438218, "Layvin", "Kurzawa", 10, LocalDate.of(1992, 9, 4), "Su casa 6667", "lkurzawa@mail.com", "+54 11 7839-5356", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 65975262, "Achraf", "Hakimi", 10, LocalDate.of(1998, 11, 4), "Su casa 8829", "ahakimi@mail.com", "+54 11 7930-3962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 78043813, "Leandro", "Paredes", 10, LocalDate.of(1994, 6, 29), "Su casa 9273", "lparedes@mail.com", "+54 11 1156-8936", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 67286073, "Danilo", "Pereira", 10, LocalDate.of(1991, 9, 9), "Su casa 9389", "dpereira@mail.com", "+54 11 6230-3396", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 84370509, "Idrissa", "Gueye", 10, LocalDate.of(1989, 9, 26), "Su casa 2137", "igueye@mail.com", "+54 11 3248-6271", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 39402441, "Marco", "Verratti", 10, LocalDate.of(1992, 11, 5), "Su casa 8251", "mverratti@mail.com", "+54 11 7786-4982", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 52489401, "Georginio", "Wijnaldum", 10, LocalDate.of(1990, 11, 11), "Su casa 151", "gwijnaldum@mail.com", "+54 11 5334-0960", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 90948126, "Ander", "Herrera", 10, LocalDate.of(1989, 8, 14), "Su casa 3107", "aherrera@mail.com", "+54 11 4255-7928", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37570073, "Xavi", "Simons", 10, LocalDate.of(2003, 4, 21), "Su casa 1749", "xsimons@mail.com", "+54 11 7068-8009", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10484727, "Neymar", "Da Silva Santos Junior", 10, LocalDate.of(1992, 2, 5), "Su casa 5912", "neymar@mail.com", "+54 11 7974-0457", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 59535357, "Julian", "Draxler", 10, LocalDate.of(1993, 9, 2), "Su casa 8278", "jdraxler@mail.com", "+54 11 5760-9789", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36290571, "Angel", "Di Maria", 10, LocalDate.of(1988, 2, 14), "Su casa 1183", "adimaria@mail.com", "+54 11 7688-3754", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 69989515, "Kylian", "Mbappe", 10, LocalDate.of(1998, 12, 20), "Su casa 8888", "kmbappe@mail.com", "+54 11 4768-2837", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 96986200, "Mauro", "Icardi", 10, LocalDate.of(1993, 2, 19), "Su casa 1490", "micardi@mail.com", "+54 11 6106-5305", "1234");
            //----
            ControladorJugadores.getInstancia().agregarJugador("DNI", 59426451, "Coleman", "Burgess", 10, LocalDate.of(1987, 6, 24), "Su casa 4888", "Qhdo3yCTj73b@mail.com", "+54 11 8341-9359", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 19619701, "Zack", "Merritt", 10, LocalDate.of(1999, 2, 25), "Su casa 7569", "COL231@mail.com", "+54 11 4157-2774", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 17298741, "Ramiro", "Huang", 10, LocalDate.of(1986, 12, 15), "Su casa 3429", "0MVhaHzk@mail.com", "+54 11 2688-9081", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 34715191, "Curtis", "Soto", 10, LocalDate.of(1994, 5, 14), "Su casa 7631", "VAv8Uxg4L78@mail.com", "+54 11 5020-9152", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 18179571, "Leonidas", "Castro", 10, LocalDate.of(1995, 8, 13), "Su casa 2722", "5tPu@mail.com", "+54 11 6878-6800", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 79920146, "Brenden", "Medina", 10, LocalDate.of(1996, 5, 4), "Su casa 4292", "vdsLwpY@mail.com", "+54 11 9674-8635", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81799098, "Brody", "Mcintyre", 10, LocalDate.of(1996, 9, 21), "Su casa 1471", "hTq9wV3@mail.com", "+54 11 7518-9420", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 40710811, "Braxton", "James", 10, LocalDate.of(1986, 3, 30), "Su casa 589", "tzbPc2R21@mail.com", "+54 11 1997-2781", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 23558199, "Santiago", "Petersen", 10, LocalDate.of(1992, 9, 4), "Su casa 6667", "dMvM@mail.com", "+54 11 7839-5356", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 47992854, "Braxton", "Calderon", 10, LocalDate.of(1998, 11, 4), "Su casa 8829", "jPzE07j2OCh@mail.com", "+54 11 7930-3962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 30831027, "Conor", "Huber", 10, LocalDate.of(1994, 6, 29), "Su casa 9273", "1bZ25Iq8qid@mail.com", "+54 11 1156-8936", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 87032606, "Rohan", "Roberson", 10, LocalDate.of(1991, 9, 9), "Su casa 9389", "Ir7W@mail.com", "+54 11 6230-3396", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 86700284, "Mathias", "Mccullough", 10, LocalDate.of(1989, 9, 26), "Su casa 2137", "9UdAQjpFtn@mail.com", "+54 11 3248-6271", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 31082329, "Kristopher", "Humphrey", 10, LocalDate.of(1992, 11, 5), "Su casa 8251", "9XCHgK4QJ9Pe@mail.com", "+54 11 7786-4982", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 48562239, "Kyler", "Gardner", 10, LocalDate.of(1990, 11, 11), "Su casa 151", "QqmWgUZl@mail.com", "+54 11 5334-0960", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 48097205, "Steve", "Fox", 10, LocalDate.of(1989, 8, 14), "Su casa 3107", "MEa2Go5v0@mail.com", "+54 11 4255-7928", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92262360, "Jonah", "Vega", 10, LocalDate.of(2003, 4, 21), "Su casa 1749", "neT65GQr@mail.com", "+54 11 7068-8009", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 13443448, "Emmanuel", "Murray", 10, LocalDate.of(1992, 2, 5), "Su casa 5912", "HgCXj8fD@mail.com", "+54 11 7974-0457", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 52844008, "Cordell", "Doyle", 10, LocalDate.of(1993, 9, 2), "Su casa 8278", "2SOpj41@mail.com", "+54 11 5760-9789", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10714955, "Dante", "Valdez", 10, LocalDate.of(1988, 2, 14), "Su casa 1183", "68X@mail.com", "+54 11 7688-3754", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 43192436, "Eduardo", "Livingston", 10, LocalDate.of(1998, 12, 20), "Su casa 8888", "hPyuW@mail.com", "+54 11 4768-2837", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 66724449, "Immanuel", "Mccoy", 10, LocalDate.of(1993, 2, 19), "Su casa 1490", "86pT60@mail.com", "+54 11 6106-5305", "1234");


        } catch (ClubException | JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testValidarLogin() {
        try {
            System.out.println(ControladorJugadores.getInstancia().loginJugador("aherrera@mail.com", "1234"));
            System.out.println(ControladorJugadores.getInstancia().loginJugador("aherrera@mail.com", "123"));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testCambiarPassword() {
        try {
            ControladorJugadores.getInstancia().cambiarPassword(106, "13245");
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadores() throws JugadorException {
        List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadores();
        for (JugadorVO j : jugadores)
            System.out.println(j.getNombre() + " " + j.getApellido() + " " + j.getCategoria());
    }

    public void testGetJugadoresByClub() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadoresByClub(3);
            for (JugadorVO j : jugadores)
                System.out.println("Club: " + j.getClub().getIdClub() + " - Jugador: " + j.getNombre() + " " + j.getApellido());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testEncontrarJugador() {
        try {
            Jugador j = ControladorJugadores.getInstancia().encontrarJugador(9).toModelo();
            System.out.println(j.getNombre());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByDocumento() {
        try {
            JugadorVO j = ControladorJugadores.getInstancia().getJugadorByDocumento(28754213, "DNI");
            System.out.println(j.getNombre());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByNombre() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadorByNombre("Diego Alberto", "Milito");
            for (JugadorVO j : jugadores)
                System.out.println(j.getNombre() + " " + j.getApellido());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetJugadorByCategoria() {
        try {
            List<JugadorVO> jugadores = ControladorJugadores.getInstancia().getJugadoresByCategoria(78);
            for (JugadorVO j : jugadores)
                System.out.println(j.getNombre() + " " + j.getCategoria());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }


    public void testModificarDireccion() {
        try {
            ControladorJugadores.getInstancia().modificarDireccion(1, "Su casa siempre sera la 22 (modificado)");
            Jugador j = ControladorJugadores.getInstancia().encontrarJugador(1).toModelo();
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getDireccion());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarMail() {
        try {
            ControladorJugadores.getInstancia().modificarMail(1, "elprincipe@mail.com");
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getMail());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarTelefono() {
        try {
            ControladorJugadores.getInstancia().modificarTelefono(1, "222222222");
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).getTelefono());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testModificarEstado() {
        try {
            ControladorJugadores.getInstancia().modificarEstado(1);
            System.out.println(ControladorJugadores.getInstancia().encontrarJugador(1).isEstado());
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetStatsByCampeonato() {
        try {
            StatsVO a = ControladorJugadores.getInstancia().getStatsByCampeonato(15, 1);
            System.out.println(a.getIdJugador());
            System.out.println(a.getNombreJugador());
            System.out.println(a.getApellido());
            System.out.println(a.getIdClub());
            System.out.println(a.getNombreClub());
            System.out.println(a.getIdCampeonato());
            System.out.println(a.getDescripcion());
            System.out.println(a.getCantJugados());
            System.out.println(a.getCantGoles());
            System.out.println(a.getCantAmarillas());
            System.out.println(a.getCantRojas());
        } catch (JugadorException | CampeonatoException | PartidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testperteneceAlClub() {
        try {
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(1).toModelo(), 2));
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(2).toModelo(), -1));
            System.out.println(ControladorJugadores.getInstancia().perteneceAlClub(ControladorJugadores.getInstancia().encontrarJugador(3).toModelo(), 1));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testgetJugadoresHabilitadosCategoriaClub() {
        try {
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(1, 20, 2));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(2, 30, 2));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClubAndCampeonato(3, 40, 2));
        } catch (JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testGetStatsByClub() {
        try {
            StatsVO a = ControladorJugadores.getInstancia().getStatsByClub(15, 1);
            System.out.println(a.getIdJugador());
            System.out.println(a.getNombreJugador());
            System.out.println(a.getApellido());
            System.out.println(a.getIdClub());
            System.out.println(a.getNombreClub());
            System.out.println(a.getCantJugados());
            System.out.println(a.getCantGoles());
            System.out.println(a.getCantAmarillas());
            System.out.println(a.getCantRojas());
        } catch (JugadorException | ClubException | PartidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void testModificarEstadoCampeonato() {
        try {
            ControladorJugadores.getInstancia().modificarEstadoCampeonato(1,1);
            ControladorJugadores.getInstancia().modificarEstadoCampeonato(2,1);
            ControladorJugadores.getInstancia().modificarEstadoCampeonato(3,1);
        } catch (CampeonatoException | JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testExisteDocumentoJugador() {
        System.out.println(ControladorJugadores.getInstancia().existeDocumentoJugador(31153456));
    }

    public void testExisteTelefonoJugador() {
        System.out.println(ControladorJugadores.getInstancia().existeTelefonoJugador("+54 11 1927-1339"));
    }

    public void testExisteMailJugador() {
        System.out.println(ControladorJugadores.getInstancia().existeMailJugador("arrossi@mail.com"));
    }

}
