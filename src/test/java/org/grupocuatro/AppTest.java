package org.grupocuatro;


import org.grupocuatro.controlador.*;
import org.grupocuatro.dao.*;
import org.grupocuatro.modelo.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {

        ControladorClubes controladorClubes = ControladorClubes.getInstancia();
        ControladorCampeonatos controladorCampeonatos = ControladorCampeonatos.getInstancia();
        ControladorPartidos controladorPartidos = ControladorPartidos.getInstancia();
        ControladorFaltas controladorFaltas = ControladorFaltas.getInstancia();
        ControladorGoles controladorGoles = ControladorGoles.getInstancia();
        ControladorMiembros controladorMiembros = ControladorMiembros.getInstancia();
        ControladorJugadores controladorJugadores = ControladorJugadores.getInstancia();
        ControladorResponsables controladorResponsables = ControladorResponsables.getInstancia();

        //CREACION DE CLUBES
        controladorClubes.crearClub(1, "Boca", "La Boca 100");
        controladorClubes.crearClub(2, "River", "Nuñez 200");
        controladorClubes.crearClub(3, "Racing", "Pasaje Corbatta 300");
        controladorClubes.crearClub(4, "Independiente", "Avellaneda 400");
        controladorClubes.crearClub(5, "San Lorenzo", "Carrefour");
        controladorClubes.crearClub(6, "Ferrocarril Oeste", "Caballito 505");
        controladorClubes.crearClub(7, "Banfield", "Banfield 1450");
        controladorClubes.crearClub(8, "Inter", "Piazzale Angelo Moratti");
        controladorClubes.crearClub(9, "PSG", "Parc Des Princes");


        //CREACION DE CAMPEONATOS
        controladorCampeonatos.crearCampeonato("SuperLiga", LocalDate.of(2021, 10, 16), LocalDate.of(2022, 3, 9), "Activo", 78);
        controladorCampeonatos.crearCampeonato("Champions League", LocalDate.of(2021, 10, 22), LocalDate.of(2022, 5, 28), "Activo", 86);
        controladorCampeonatos.crearCampeonato("Serie A", LocalDate.of(2021, 10, 21), LocalDate.of(2022, 5, 22), "Activo", 76);

        controladorCampeonatos.definirTipoCampeonato("Puntos", 1);
        controladorCampeonatos.definirTipoCampeonato("Zonas", 2);
        controladorCampeonatos.definirTipoCampeonato("Puntos", 3);

        controladorCampeonatos.agregarClubACampeonato(1,1);
        controladorCampeonatos.agregarClubACampeonato(2,1);
        controladorCampeonatos.agregarClubACampeonato(3,1);
        controladorCampeonatos.agregarClubACampeonato(4,1);
        controladorCampeonatos.agregarClubACampeonato(5,1);
        controladorCampeonatos.agregarClubACampeonato(6,1);
        controladorCampeonatos.agregarClubACampeonato(7,1);
        controladorCampeonatos.agregarClubACampeonato(8,2);
        controladorCampeonatos.agregarClubACampeonato(9,2);


        //CREACION DE RESPONSABLES
        controladorResponsables.crearResponsable(35785412, "Jorge Ameal", 1);
        controladorResponsables.crearResponsable(34521879, "Rodolfo Don Frío", 2);
        controladorResponsables.crearResponsable(34852369, "Victor Blanco", 3);
        controladorResponsables.crearResponsable(35412789, "Hugo Moyano", 4);
        controladorResponsables.crearResponsable(35785412, "Marcelo Tinelli", 5);
        controladorResponsables.crearResponsable(34521879, "Daniel Pandolfi", 6);
        controladorResponsables.crearResponsable(34852369, "Lucía Barbuto", 7);
        controladorResponsables.crearResponsable(35785412, "Steven Zhang", 8);
        controladorResponsables.crearResponsable(35412789, "Nasser Al-Khelaifi", 9);

        //CREACION DE JUGADORES

        //BOCA 1 - 11
        controladorJugadores.agregarJugador("DNI", 31123456, "Juan Roman", "Riquelme", 1, LocalDate.of(1978, 6, 24), "Su casa 1", "rriquelme@mail.com", "+54 11 1928-1339");
        controladorJugadores.agregarJugador("DNI", 93353922, "Agustin", "Rossi", 1, LocalDate.of(1995, 8, 21), "Su casa 2", "arossi@mail.com", "+54 11 6258-7830");
        controladorJugadores.agregarJugador("DNI", 70111576, "Carlos", "Izquierdoz", 1, LocalDate.of(1988, 11, 3), "Su casa 3", "cali@mail.com", "+54 11 2884-7437");
        controladorJugadores.agregarJugador("DNI", 61648656, "Marcos", "Rojo", 1, LocalDate.of(1990, 3, 20), "Su casa 4", "mrojo@mail.com", "+54 11 9796-8021");
        controladorJugadores.agregarJugador("DNI", 85220626, "Lisandro", "Lopez", 1, LocalDate.of(1989, 9, 1), "Su casa 5", "llopez@mail.com", "+54 11 8553-4509");
        controladorJugadores.agregarJugador("DNI", 98672345, "Carlos", "Zambrano", 1, LocalDate.of(1989, 7, 10), "Su casa 6", "czambrano@mail.com", "+54 11 7840-6406");
        controladorJugadores.agregarJugador("DNI", 64051816, "Frank", "Fabra", 1, LocalDate.of(1991, 2, 22), "Su casa 7", "ffabra@mail.com", "+54 11 4282-5377");
        controladorJugadores.agregarJugador("DNI", 19703542, "Valentin", "Barco", 1, LocalDate.of(2004, 7, 23), "Su casa 8", "vbarco@mail.com", "+54 11 7574-4028");
        controladorJugadores.agregarJugador("DNI", 88941666, "Marcelo", "Weigandt", 1, LocalDate.of(2000, 1, 11), "Su casa 9", "mweigandt@mail.com", "+54 11 2016-5915");
        controladorJugadores.agregarJugador("DNI", 91867074, "Luis", "Advincula", 1, LocalDate.of(1990, 3, 2), "Su casa 10", "ladvincula@mail.com", "+54 11 2042-7052");
        controladorJugadores.agregarJugador("DNI", 97678613, "Alan", "Varela", 1, LocalDate.of(2001, 7, 4), "Su casa 11", "avarela@mail.com", "+54 11 1142-3898");

        //RIVER 12 - 23
        controladorJugadores.agregarJugador("DNI", 30458741, "Marcelo Daniel", "Gallardo", 2, LocalDate.of(1976, 1, 18), "Su casa 15", "mgallardo@mail.com", "+54 11 1945-6216");
        controladorJugadores.agregarJugador("DNI", 31587652, "Franco", "Armani", 2, LocalDate.of(1986, 10, 16), "Su casa 12", "farmani@mail.com", "+54 11 8372-6286");
        controladorJugadores.agregarJugador("DNI", 76468954, "Paulo", "Diaz", 2, LocalDate.of(1994, 8, 25), "Su casa 13", "pdiaz@mail.com", "+54 11 1850-6703");
        controladorJugadores.agregarJugador("DNI", 73927657, "David", "Martinez", 2, LocalDate.of(1998, 1, 21), "Su casa 14", "dmartinez@mail.com", "+54 11 2865-9858");
        controladorJugadores.agregarJugador("DNI", 33411994, "Robert", "Rojas", 2, LocalDate.of(1996, 4, 30), "Su casa 15", "rrojas@mail.com", "+54 11 2160-9584");
        controladorJugadores.agregarJugador("DNI", 99736264, "Javier", "Pinola", 2, LocalDate.of(1983, 2, 24), "Su casa 16", "jpinola@mail.com", "+54 11 6839-4948");
        controladorJugadores.agregarJugador("DNI", 77657557, "Jonatan", "Maidana", 2, LocalDate.of(1985, 7, 29), "Su casa 17", "jmaidana@mail.com", "+54 11 6838-1240");
        controladorJugadores.agregarJugador("DNI", 17561691, "Milton", "Casco", 2, LocalDate.of(1988, 4, 11), "Su casa 18", "mcasco@mail.com", "+54 11 3813-4036");
        controladorJugadores.agregarJugador("DNI", 33470348, "Enzo", "Perez", 2, LocalDate.of(1989, 2, 22), "Su casa 19", "eperez@mail.com", "+54 11 5635-7409");
        controladorJugadores.agregarJugador("DNI", 41563870, "Bruno", "Zuculini", 2, LocalDate.of(1993, 4, 2), "Su casa 20", "bzuculini@mail.com", "+54 11 7037-2077");
        controladorJugadores.agregarJugador("DNI", 40219851, "Leonardo", "Ponzio", 2, LocalDate.of(1982, 1, 29), "Su casa 21", "lponzio@mail.com", "+54 11 4764-8036");
        controladorJugadores.agregarJugador("DNI", 76202349, "Nicolas", "De La Cruz", 2, LocalDate.of(1997, 6, 1), "Su casa 22", "ndelacruz@mail.com", "+54 11 8012-4099");

        //RACING 24 - 32
        controladorJugadores.agregarJugador("DNI", 59424211, "Gabriel", "Arias", 3, LocalDate.of(1987, 9, 13), "su casa 23", "garias@mail.com", "+54 11 3151-4751");
        controladorJugadores.agregarJugador("DNI", 75473477, "Gaston", "Gomez", 3, LocalDate.of(1996, 3, 4), "su casa 24", "ggomez@mail.com", "+54 11 4543-6615");
        controladorJugadores.agregarJugador("DNI", 15913806, "Matias", "Tagliamonte", 3, LocalDate.of(1998, 2, 19), "su casa 25", "mtagliamonte@mail.com", "+54 11 2960-8836");
        controladorJugadores.agregarJugador("DNI", 37035851, "Imanol", "Segovia", 3, LocalDate.of(2001, 2, 6), "su casa 26", "isegovia@mail.com", "+54 11 6649-1475");
        controladorJugadores.agregarJugador("DNI", 67575649, "Nery", "Dominguez", 3, LocalDate.of(1990, 4, 9), "su casa 27", "ndominguez@mail.com", "+54 11 8845-0104");
        controladorJugadores.agregarJugador("DNI", 46882459, "Leonardo", "Sigali", 3, LocalDate.of(1987, 5, 29), "su casa 28", "lsigali@mail.com", "+54 11 5346-5580");
        controladorJugadores.agregarJugador("DNI", 23512502, "Lucas", "Orban", 3, LocalDate.of(1989, 2, 3), "su casa 29", "lorban@mail.com", "+54 11 3217-4261");
        controladorJugadores.agregarJugador("DNI", 27078447, "Joaquin", "Novillo", 3, LocalDate.of(1998, 2, 19), "su casa 30", "jnovillo@mail.com", "+54 11 7265-8614");
        controladorJugadores.agregarJugador("DNI", 53737840, "Mauricio", "Martinez", 3, LocalDate.of(1993, 2, 20), "su casa 31", "mmartinez@mail.com", "+54 11 8055-8220");

        //INDEPENDIENTE 33 - 47
        controladorJugadores.agregarJugador("DNI", 28754213, "Ricardo Enrique", "Bochini", 4, LocalDate.of(1954, 1, 25), "Su casa 32", "rbochini@mail.com", "+54 11 3212-6740");
        controladorJugadores.agregarJugador("DNI", 86947307, "Sebastian", "Sosa", 4, LocalDate.of(1986, 8, 19), "Su casa 33", "ssosa@mail.com", "+54 11 4967-5743");
        controladorJugadores.agregarJugador("DNI", 63110117, "Milton", "Alvarez", 4, LocalDate.of(1989, 1, 26), "Su casa 34", "malvares@mail.com", "+54 11 3951-2326");
        controladorJugadores.agregarJugador("DNI", 41916667, "Renzo", "Bacchia", 4, LocalDate.of(1999, 1, 23), "Su casa 35", "rbacchia@mail.com", "+54 11 3340-9927");
        controladorJugadores.agregarJugador("DNI", 55047867, "Sergio", "Barreto", 4, LocalDate.of(1999, 1, 24), "Su casa 36", "sbarreto@mail.com", "+54 11 4888-9037");
        controladorJugadores.agregarJugador("DNI", 61879086, "Joaquin", "Laso", 4, LocalDate.of(1990, 7, 4), "Su casa 37", "jlaso@mail.com", "+54 11 7482-2266");
        controladorJugadores.agregarJugador("DNI", 11721073, "Juan Manuel", "Insaurralde", 4, LocalDate.of(1984, 10, 3), "Su casa 38", "jminsaurralde@mail.com", "+54 11 6757-1865");
        controladorJugadores.agregarJugador("DNI", 15651148, "Ezequiel", "Munoz", 4, LocalDate.of(1990, 10, 8), "Su casa 39", "emunoz@mail.com", "+54 11 7159-6606");
        controladorJugadores.agregarJugador("DNI", 22655071, "Ayrton", "Costa", 4, LocalDate.of(1999, 7, 12), "Su casa 40", "acosta@mail.com", "+54 11 2719-4038");
        controladorJugadores.agregarJugador("DNI", 51690492, "Patricio", "Ostachuk", 4, LocalDate.of(2000, 5, 5), "Su casa 41", "postachuk@mail.com", "+54 11 2141-7894");
        controladorJugadores.agregarJugador("DNI", 31706178, "Lucas", "Rodriguez", 4, LocalDate.of(1993, 9, 27), "Su casa 42", "lrodriguez@mail.com", "+54 11 5978-5956");
        controladorJugadores.agregarJugador("DNI", 23951804, "Thomas", "Ortega", 4, LocalDate.of(2000, 12, 6), "Su casa 43", "tortega@mail.com", "+54 11 9462-3566");
        controladorJugadores.agregarJugador("DNI", 21426709, "Fabricio", "Bustos", 4, LocalDate.of(1996, 4, 28), "Su casa 44", "fbustos@mail.com", "+54 11 2061-1465");
        controladorJugadores.agregarJugador("DNI", 17214787, "Gonzalo", "Asis", 4, LocalDate.of(1996, 3, 28), "Su casa 45", "gasis@mail.com", "+54 11 3601-3364");
        controladorJugadores.agregarJugador("DNI", 56553617, "Lucas", "Romero", 4, LocalDate.of(1994, 4, 18), "Su casa 46", "lromero@mail.com", "+54 11 7380-8024");


        //SAN SILENCIO 48 - 53
        controladorJugadores.agregarJugador("DNI", 38811500, "Augusto", "Batalla", 5, LocalDate.of(1996, 4, 30), "Su casa 47", "abatalla@mail.com", "+54 11 4381-5831");
        controladorJugadores.agregarJugador("DNI", 42030784, "Sebastian Alberto", "Torrico", 5, LocalDate.of(1980, 2, 22), "Su casa 48", "storrico@mail.com", "+54 11 1243-9039");
        controladorJugadores.agregarJugador("DNI", 38439359, "Francisco", "Flores", 5, LocalDate.of(2002, 1, 11), "Su casa 49", "fflores@mail.com", "+54 11 4362-9663");
        controladorJugadores.agregarJugador("DNI", 37897231, "Federico", "Gatoni", 5, LocalDate.of(1999, 2, 16), "Su casa 50", "fgatoni@mail.com", "+54 11 2457-5962");
        controladorJugadores.agregarJugador("DNI", 58334276, "Alejandro", "Donatti", 5, LocalDate.of(1986, 10, 24), "Su casa 51", "adonatti@mail.com", "+54 11 7280-4273");
        controladorJugadores.agregarJugador("DNI", 67743381, "Gino", "Peruzzi", 5, LocalDate.of(1992, 6, 9), "Su casa 52", "gperuzzi@mail.com", "+54 11 1471-7022");


        //FERRO 54 - 59
        controladorJugadores.agregarJugador("DNI", 36875123, "Luis Angel", "Salmeron", 6, LocalDate.of(1982, 3, 18), "Su casa 53", "lsalmeron@mail.com", "+54 11 4431-6487");
        controladorJugadores.agregarJugador("DNI", 44534244, "Juan", "Perez", 6, LocalDate.of(1999, 3, 24), "Su casa 54", "jperez@mail.com", "+54 11 2695-1540");
        controladorJugadores.agregarJugador("DNI", 53026193, "Pedro", "Gomez", 6, LocalDate.of(1999, 4, 21), "Su casa 55", "pgomez@mail.com", "+54 11 7101-5091");
        controladorJugadores.agregarJugador("DNI", 99901795, "Alejandro", "Giordanengo", 6, LocalDate.of(2002, 6, 6), "Su casa 56", "agiordanengo@mail.com", "+54 11 2298-6262");
        controladorJugadores.agregarJugador("DNI", 78549602, "Nicolas", "Pandolfi", 6, LocalDate.of(1988, 4, 22), "Su casa 57", "npandolfi@mail.com", "+54 11 3045-6962");
        controladorJugadores.agregarJugador("DNI", 93742159, "Esteban", "Carnicer", 6, LocalDate.of(2004, 3, 4), "Su casa 58", "ecarnicer@mail.com", "+54 11 7391-5913");


        //BANFIELD 60 - 64
        controladorJugadores.agregarJugador("DNI", 58029954, "James David", "Rodriguez", 7, LocalDate.of(1991, 7, 12), "Su casa 59", "jrodriguez@mail.com", "+54 11 2217-7713");
        controladorJugadores.agregarJugador("DNI", 92149154, "Facundo", "Altamirano", 7, LocalDate.of(1996, 3, 21), "Su casa 60", "faltamirano@mail.com", "+54 11 2932-0700");
        controladorJugadores.agregarJugador("DNI", 58698841, "Gregorio", "Tanco", 7, LocalDate.of(1999, 10, 10), "Su casa 61", "gtanco@mail.com", "+54 11 3834-2003");
        controladorJugadores.agregarJugador("DNI", 97471727, "Alexis", "Maldonado", 7, LocalDate.of(1997, 9, 2), "Su casa 62", "amaldonado@mail.com", "+54 11 9379-3762");
        controladorJugadores.agregarJugador("DNI", 81923228, "Luciano", "Lollo", 7, LocalDate.of(1987, 3, 29), "Su casa 63", "llollo@mail.com", "+54 11 8502-0749");

        //INTER 65 - 82
        controladorJugadores.agregarJugador("DNI", 93497503, "Diego Alberto", "Milito", 8, LocalDate.of(1979, 6, 12), "Su casa 22", "dmilito@mail.com", "+54 11 5930-6875");
        controladorJugadores.agregarJugador("DNI", 17110900, "Samir", "Handanovic", 8, LocalDate.of(1984, 7, 14), "Su casa 4002", "shandanovic@mail.com", "+54 11 5635-8574");
        controladorJugadores.agregarJugador("DNI", 88241271, "Milan", "Skriniar", 8, LocalDate.of(1995, 2, 11), "Su casa 8362", "mskriniar@mail.com", "+54 11 9830-5406");
        controladorJugadores.agregarJugador("DNI", 65660187, "Alessandro", "Bastoni", 8, LocalDate.of(1999, 4, 13), "Su casa 3775", "abastoni@mail.com", "+54 11 8048-9715");
        controladorJugadores.agregarJugador("DNI", 81412861, "Stefan", "De Vrij", 8, LocalDate.of(1992, 2, 5), "Su casa 8769", "sdevrij@mail.com", "+54 11 3316-7343");
        controladorJugadores.agregarJugador("DNI", 87978298, "Aleksandar", "Kolarov", 8, LocalDate.of(1985, 11, 10), "Su casa 822", "akolarov@mail.com", "+54 11 6438-6574");
        controladorJugadores.agregarJugador("DNI", 10951889, "Marcelo", "Brozovic", 8, LocalDate.of(1992, 11, 16), "Su casa 8099", "mbrozovic@mail.com", "+54 11 1303-9702");
        controladorJugadores.agregarJugador("DNI", 56936715, "Nicolo", "Barella", 8, LocalDate.of(1997, 2, 7), "Su casa 5715", "nbarella@mail.com", "+54 11 8081-7598");
        controladorJugadores.agregarJugador("DNI", 21885890, "Roberto", "Gagliardini", 8, LocalDate.of(1994, 4, 7), "Su casa 5647", "rgagliardini@mail.com", "+54 11 5417-1072");
        controladorJugadores.agregarJugador("DNI", 54285773, "Matias", "Vecino", 8, LocalDate.of(1991, 8, 24), "Su casa 8519", "mvecino@mail.com", "+54 11 8112-2505");
        controladorJugadores.agregarJugador("DNI", 85358523, "Arturo", "Vidal", 8, LocalDate.of(1987, 5, 22), "Su casa 9204", "avidal@mail.com", "+54 11 1611-5356");
        controladorJugadores.agregarJugador("DNI", 38185802, "Denzel", "Dumfries", 8, LocalDate.of(1996, 4, 18), "Su casa 7620", "ddumfries@mail.com", "+54 11 2114-2884");
        controladorJugadores.agregarJugador("DNI", 84748359, "Ivan", "Perisic", 8, LocalDate.of(1989, 2, 2), "Su casa 1685", "iperisic@mail.com", "+54 11 1256-5249");
        controladorJugadores.agregarJugador("DNI", 43899977, "Christian", "Eriksen", 8, LocalDate.of(1992, 2, 14), "Su casa 2929", "ceriksen@mail.com", "+54 11 9429-2538");
        controladorJugadores.agregarJugador("DNI", 35341545, "Hakan", "Calhanoglu", 8, LocalDate.of(1994, 2, 8), "Su casa 7808", "hcalhanoglu@mail.com", "+54 11 3579-9514");
        controladorJugadores.agregarJugador("DNI", 47135866, "Joaquin", "Correa", 8, LocalDate.of(1994, 8, 13), "Su casa 8275", "jcorrea@mail.com", "+54 11 6619-5289");
        controladorJugadores.agregarJugador("DNI", 48672637, "Lautaro", "Martinez", 8, LocalDate.of(1997, 8, 22), "Su casa 1288", "lmartinez@mail.com", "+54 11 8135-4107");
        controladorJugadores.agregarJugador("DNI", 51394560, "Romelu", "Lukaku", 8, LocalDate.of(1993, 5, 13), "Su casa 8180", "rlukaku@mail.com", "+54 11 6513-2168");

        //PSG 83 - 104
        controladorJugadores.agregarJugador("DNI", 36737643, "Lionel Andres", "Messi", 9, LocalDate.of(1987, 6, 24), "Su casa 4888", "lmessi@mail.com", "+54 11 8341-9359");
        controladorJugadores.agregarJugador("DNI", 83352880, "Gianluigi", "Donnarumma", 9, LocalDate.of(1999, 2, 25), "Su casa 7569", "gdonnarumma@mail.com", "+54 11 4157-2774");
        controladorJugadores.agregarJugador("DNI", 92847000, "Keylor", "Navas", 9, LocalDate.of(1986, 12, 15), "Su casa 3429", "knavas@mail.com", "+54 11 2688-9081");
        controladorJugadores.agregarJugador("DNI", 18340039, "Marcos", "Aoas Correa", 9, LocalDate.of(1994, 5, 14), "Su casa 7631", "marquinhos@mail.com", "+54 11 5020-9152");
        controladorJugadores.agregarJugador("DNI", 94183510, "Presnel", "Kimpembe", 9, LocalDate.of(1995, 8, 13), "Su casa 2722", "pkimpembe@mail.com", "+54 11 6878-6800");
        controladorJugadores.agregarJugador("DNI", 50784515, "Abdou", "Diallo", 9, LocalDate.of(1996, 5, 4), "Su casa 4292", "adiallo@mail.com", "+54 11 9674-8635");
        controladorJugadores.agregarJugador("DNI", 66432572, "Thilo", "Kherer", 9, LocalDate.of(1996, 9, 21), "Su casa 1471", "tkherer@mail.com", "+54 11 7518-9420");
        controladorJugadores.agregarJugador("DNI", 15232475, "Sergio", "Ramos", 9, LocalDate.of(1986, 3, 30), "Su casa 589", "sramos@mail.com", "+54 11 1997-2781");
        controladorJugadores.agregarJugador("DNI", 44438218, "Layvin", "Kurzawa", 9, LocalDate.of(1992, 9, 4), "Su casa 6667", "lkurzawa@mail.com", "+54 11 7839-5356");
        controladorJugadores.agregarJugador("DNI", 65975262, "Achraf", "Hakimi", 9, LocalDate.of(1998, 11, 4), "Su casa 8829", "ahakimi@mail.com", "+54 11 7930-3962");
        controladorJugadores.agregarJugador("DNI", 78043813, "Leandro", "Paredes", 9, LocalDate.of(1994, 6, 29), "Su casa 9273", "lparedes@mail.com", "+54 11 1156-8936");
        controladorJugadores.agregarJugador("DNI", 67286073, "Danilo", "Pereira", 9, LocalDate.of(1991, 9, 9), "Su casa 9389", "dpereira@mail.com", "+54 11 6230-3396");
        controladorJugadores.agregarJugador("DNI", 84370509, "Idrissa", "Gueye", 9, LocalDate.of(1989, 9, 26), "Su casa 2137", "igueye@mail.com", "+54 11 3248-6271");
        controladorJugadores.agregarJugador("DNI", 39402441, "Marco", "Verratti", 9, LocalDate.of(1992, 11, 5), "Su casa 8251", "mverratti@mail.com", "+54 11 7786-4982");
        controladorJugadores.agregarJugador("DNI", 52489401, "Georginio", "Wijnaldum", 9, LocalDate.of(1990, 11, 11), "Su casa 151", "gwijnaldum@mail.com", "+54 11 5334-0960");
        controladorJugadores.agregarJugador("DNI", 90948126, "Ander", "Herrera", 9, LocalDate.of(1989, 8, 14), "Su casa 3107", "aherrera@mail.com", "+54 11 4255-7928");
        controladorJugadores.agregarJugador("DNI", 37570073, "Xavi", "Simons", 9, LocalDate.of(2003, 4, 21), "Su casa 1749", "xsimons@mail.com", "+54 11 7068-8009");
        controladorJugadores.agregarJugador("DNI", 10484727, "Neymar", "Da Silva Santos Junior", 9, LocalDate.of(1992, 2, 5), "Su casa 5912", "neymar@mail.com", "+54 11 7974-0457");
        controladorJugadores.agregarJugador("DNI", 59535357, "Julian", "Draxler", 9, LocalDate.of(1993, 9, 2), "Su casa 8278", "jdraxler@mail.com", "+54 11 5760-9789");
        controladorJugadores.agregarJugador("DNI", 36290571, "Angel", "Di Maria", 9, LocalDate.of(1988, 2, 14), "Su casa 1183", "adimaria@mail.com", "+54 11 7688-3754");
        controladorJugadores.agregarJugador("DNI", 69989515, "Kylian", "Mbappe", 9, LocalDate.of(1998, 12, 20), "Su casa 8888", "kmbappe@mail.com", "+54 11 4768-2837");
        controladorJugadores.agregarJugador("DNI", 96986200, "Mauro", "Icardi", 9, LocalDate.of(1993, 2, 19), "Su casa 1490", "micardi@mail.com", "+54 11 6106-5305");

        //PARTIDOS
        //SUPERLIGA

        //PARTIDO 1
        controladorPartidos.crearPartido(1,1,80,1,2, LocalDate.of(2021,10,16),1); //BOCA RIVER

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(1), controladorPartidos.encontrarPartido(1));
        controladorMiembros.agregarJugadoresEnLista(1, controladorJugadores.encontrarJugador(2));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(1), controladorPartidos.encontrarPartido(1));
        controladorMiembros.agregarJugadoresEnLista(2, controladorJugadores.encontrarJugador(6));

        controladorGoles.cargarGol(2,1,5, "a favor");
        controladorGoles.cargarGol(2,1,10, "a favor");
        controladorGoles.cargarGol(2,1,15, "a favor");
        controladorGoles.cargarGol(12,1,12, "en contra");

        controladorFaltas.cargarFalta(6,1,15,"amarilla");

        //PARTIDO 2
        controladorPartidos.crearPartido(1,1,80,3,4, LocalDate.of(2021,10,16),1); //RACIN INDEPENDIENTE

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(3), controladorPartidos.encontrarPartido(2));
        controladorMiembros.agregarJugadoresEnLista(3, controladorJugadores.encontrarJugador(26));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(3), controladorPartidos.encontrarPartido(2));
        controladorMiembros.agregarJugadoresEnLista(4, controladorJugadores.encontrarJugador(32));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(4), controladorPartidos.encontrarPartido(2));
        controladorMiembros.agregarJugadoresEnLista(5, controladorJugadores.encontrarJugador(45));


        controladorGoles.cargarGol(26,2,11, "a favor");

        controladorFaltas.cargarFalta(32,2,49,"amarilla");
        controladorFaltas.cargarFalta(32,2,82,"amarilla");

        //PARTIDO 3
        controladorPartidos.crearPartido(2,1,80,2,1, LocalDate.of(2021,10,17),1); //RIVER BOCA

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(2), controladorPartidos.encontrarPartido(3));
        controladorMiembros.agregarJugadoresEnLista(6, controladorJugadores.encontrarJugador(15));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(2), controladorPartidos.encontrarPartido(3));
        controladorMiembros.agregarJugadoresEnLista(7, controladorJugadores.encontrarJugador(16));

        controladorGoles.cargarGol(15,3,85, "a favor");

        controladorFaltas.cargarFalta(16,3,8,"roja");

        //PARTIDO 4
        controladorPartidos.crearPartido(2,1,80,4,3, LocalDate.of(2021,10,17),1); //iNDEPENDIENTE RACING

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(3), controladorPartidos.encontrarPartido(4));
        controladorMiembros.agregarJugadoresEnLista(8, controladorJugadores.encontrarJugador(26));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(3), controladorPartidos.encontrarPartido(4));
        controladorMiembros.agregarJugadoresEnLista(9, controladorJugadores.encontrarJugador(30));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(4), controladorPartidos.encontrarPartido(4));
        controladorMiembros.agregarJugadoresEnLista(10, controladorJugadores.encontrarJugador(47));

        controladorGoles.cargarGol(26,4,6, "a favor");
        controladorGoles.cargarGol(26,4,78, "a favor");
        controladorGoles.cargarGol(30,4,16, "en contra");
        controladorGoles.cargarGol(47,4,68, "en contra");

        //PARTIDO 5
        controladorPartidos.crearPartido(3,1,80,5,6, LocalDate.of(2021,10,18),1); //CASLA FERRO

        //PARTIDO 6
        controladorPartidos.crearPartido(3,1,80,7,1, LocalDate.of(2021,10,18),1); //BANFIEDL BOCA

        //PARTIDO 7
        controladorPartidos.crearPartido(4,1,80,6,5, LocalDate.of(2021,10,19),1); //FERRO CASLA

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(5), controladorPartidos.encontrarPartido(7));
        controladorMiembros.agregarJugadoresEnLista(11, controladorJugadores.encontrarJugador(52));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(6), controladorPartidos.encontrarPartido(7));
        controladorMiembros.agregarJugadoresEnLista(12, controladorJugadores.encontrarJugador(59));

        controladorGoles.cargarGol(52,7,54, "en contra");
        controladorGoles.cargarGol(59,7,64, "a favor");

        //PARTIDO 8
        controladorPartidos.crearPartido(4,1,80,2,7, LocalDate.of(2021,10,19),1); // RIVER BANFIELD

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(2), controladorPartidos.encontrarPartido(8));
        controladorMiembros.agregarJugadoresEnLista(13, controladorJugadores.encontrarJugador(13));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(2), controladorPartidos.encontrarPartido(8));
        controladorMiembros.agregarJugadoresEnLista(14, controladorJugadores.encontrarJugador(14));


        controladorGoles.cargarGol(13,8,11, "en contra");
        controladorFaltas.cargarFalta(14,8,26,"amarilla");


        //CHAMPIONS

        //PARTIDO 9
        controladorPartidos.crearPartido(1,1, 85,8,9, LocalDate.of(2021, 10, 22),2);

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(8), controladorPartidos.encontrarPartido(9));
        controladorMiembros.agregarJugadoresEnLista(15, controladorJugadores.encontrarJugador(82));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(9), controladorPartidos.encontrarPartido(9));
        controladorMiembros.agregarJugadoresEnLista(16, controladorJugadores.encontrarJugador(83));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(8), controladorPartidos.encontrarPartido(9));
        controladorMiembros.agregarJugadoresEnLista(17, controladorJugadores.encontrarJugador(79));

        controladorGoles.cargarGol(82,9,79, "a favor");
        controladorGoles.cargarGol(83,9,1, "a favor");

        controladorFaltas.cargarFalta(79,9,44,"amarilla");

        //PARTIDO 10
        controladorPartidos.crearPartido(2,1, 85,9,8, LocalDate.of(2021, 10, 23),2);

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(8), controladorPartidos.encontrarPartido(8));
        controladorMiembros.agregarJugadoresEnLista(18, controladorJugadores.encontrarJugador(80));

        controladorMiembros.crearListaJugadores(controladorClubes.getClubById(9), controladorPartidos.encontrarPartido(8));
        controladorMiembros.agregarJugadoresEnLista(19, controladorJugadores.encontrarJugador(86));

        controladorFaltas.cargarFalta(80,10,89,"roja");
        controladorFaltas.cargarFalta(86,10,4,"amarilla");


        //CARGA DE RESULTADOS
        controladorPartidos.cargarResultadoPartido(1,"");
        controladorPartidos.cargarResultadoPartido(2,"Se agarraron a las trompadas a la salida");
        controladorPartidos.cargarResultadoPartido(3,"");
        controladorPartidos.cargarResultadoPartido(4,"");
        controladorPartidos.cargarResultadoPartido(5,"");
        controladorPartidos.cargarResultadoPartido(6,"Jugador se retira lesionado");
        controladorPartidos.cargarResultadoPartido(7,"");
        controladorPartidos.cargarResultadoPartido(8,"");
        controladorPartidos.cargarResultadoPartido(9,"");
        controladorPartidos.cargarResultadoPartido(10,"");

        for(Partido p: controladorPartidos.getPartidosByCampeonato(1)){
            controladorPartidos.validadoPorClubLocal(p.getClubLocal().getIdClub(), p.getIdPartido());
            controladorPartidos.validadoPorClubVisitante(p.getClubVisitante().getIdClub(), p.getIdPartido());
        }

        for(Partido p: controladorPartidos.getPartidosByCampeonato(2)){
            controladorPartidos.validadoPorClubLocal(p.getClubLocal().getIdClub(), p.getIdPartido());
            controladorPartidos.validadoPorClubVisitante(p.getClubVisitante().getIdClub(), p.getIdPartido());
        }
    }
}
