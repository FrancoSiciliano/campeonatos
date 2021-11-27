package org.grupocuatro.controladores;

import junit.framework.TestCase;
import org.grupocuatro.controlador.ControladorAdministradores;
import org.grupocuatro.excepciones.AdministradorException;

public class ControladorAdministradoresTest extends TestCase {

    public void testCrearAdministrador() {
        try {
            //ControladorAdministradores.getInstancia().crearAdministrador("Gonzalo", "Paz", "DNI", 42724444, "gonpaz@mail.com", "grupo2");
            ControladorAdministradores.getInstancia().crearAdministrador("Julian", "Gamietea", "DNI", 42725456, "jgamietea@mail.com", "grupo2");
        } catch (AdministradorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testValidarLogin() {
        try {
            System.out.println(ControladorAdministradores.getInstancia().loginAdministrador("gonpaz@mail.com", "grupo2"));
            System.out.println(ControladorAdministradores.getInstancia().loginAdministrador("gonpaz@mail.com", "grupo1"));
        } catch (AdministradorException e) {
            e.printStackTrace();
        }
    }

    public void testCambiarPassword() {
        try {
            ControladorAdministradores.getInstancia().cambiarPassword(1, "nuevapassword");
        } catch (AdministradorException e) {
            System.out.println(e.getMessage());
        }
    }

}
