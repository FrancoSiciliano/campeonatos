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


            //SAN LORENZO 48 - 53
            ControladorJugadores.getInstancia().agregarJugador("DNI", 38811500, "Augusto", "Batalla", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "abatalla@mail.com", "+54 11 4381-5831", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 42030784, "Sebastian Alberto", "Torrico", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "storrico@mail.com", "+54 11 1243-9039", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 38439359, "Francisco", "Flores", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "fflores@mail.com", "+54 11 4362-9663", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 37897231, "Federico", "Gatoni", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "fgatoni@mail.com", "+54 11 2457-5962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 58334276, "Alejandro", "Donatti", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "adonatti@mail.com", "+54 11 7280-4273", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 67743381, "Gino", "Peruzzi", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "gperuzzi@mail.com", "+54 11 1471-7022", "1234");


            //FERRO 54 - 59
            ControladorJugadores.getInstancia().agregarJugador("DNI", 36875123, "Luis Angel", "Salmeron", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "lsalmeron@mail.com", "+54 11 4431-6487", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 44534244, "Juan", "Perez", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "jperez@mail.com", "+54 11 2695-1540", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 53026193, "Pedro", "Gomez", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "pgomez@mail.com", "+54 11 7101-5091", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 99901795, "Alejandro", "Giordanengo", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "agiordanengo@mail.com", "+54 11 2298-6262", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 78549602, "Nicolas", "Pandolfi", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "npandolfi@mail.com", "+54 11 3045-6962", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 93742159, "Esteban", "Carnicer", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "ecarnicer@mail.com", "+54 11 7391-5913", "1234");


            //BANFIELD 60 - 64
            ControladorJugadores.getInstancia().agregarJugador("DNI", 58029954, "James David", "Rodriguez", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "jrodriguez@mail.com", "+54 11 2217-7713", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 92149154, "Facundo", "Altamirano", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "faltamirano@mail.com", "+54 11 2932-0700", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 58698841, "Gregorio", "Tanco", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "gtanco@mail.com", "+54 11 3834-2003", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 97471727, "Alexis", "Maldonado", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "amaldonado@mail.com", "+54 11 9379-3762", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 81923228, "Luciano", "Lollo", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "llollo@mail.com", "+54 11 8502-0749", "1234");


            //DEFENSA Y JUSTICIA 65-72

            ControladorJugadores.getInstancia().agregarJugador("DNI", 12548754, "Washington", "Camacho", 8, LocalDate.of(1991, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Nelson", "Acevedo", 8, LocalDate.of(1990, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Mati", "Rojas", 8, LocalDate.of(1993, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Facha", "Gutierrez", 8, LocalDate.of(1994, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Brian", "Fernandez", 8, LocalDate.of(1993, 12, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Hermano de Brian", "Fernandez", 8, LocalDate.of(1991, 7, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "El Defensa", "Defensor", 8, LocalDate.of(1990, 9, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");
            ControladorJugadores.getInstancia().agregarJugador("DNI", 10951889, "Yo", "Nueve de Area", 8, LocalDate.of(1993, 10, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702", "1234");


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
        } catch (ClubException | JugadorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testValidarLogin() {
        System.out.println(ControladorJugadores.getInstancia().validarJugador("aherrera@mail.com", "1234"));
        System.out.println(ControladorJugadores.getInstancia().validarJugador("aherrera@mail.com", "123"));
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
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(1, 20));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(2, 30));
            System.out.println(ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(3, 40));
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
}
