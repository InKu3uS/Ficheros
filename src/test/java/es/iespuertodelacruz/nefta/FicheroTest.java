package es.iespuertodelacruz.nefta;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.iespuertodelacruz.nefta.exception.FicheroException;

public class FicheroTest {

    Fichero fichero = null;
    String nombrefichero = "nombre.txt";
    String contenidofichero = "Prueba del contenido de un fichero";

    @BeforeEach
    public void setup() {
        if (fichero == null) {
            fichero = new Fichero();
        }
        crear();
    }

    @AfterEach
    public void after() {
        eliminar();
    }

    @Test
    public void ficheroNoExiste() {
        String nombrefichero = "ficheroNoExiste.txt";

        try {
            fichero.leer(nombrefichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("El fichero a leer no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (ficheroNoExiste) ha generado un error no controlado");
        }
    }

    @Test
    public void leerTest() {
        String texto = null;

        try {
            texto = fichero.leer(nombrefichero);
            boolean validar = texto.contains(contenidofichero);
            assertTrue(validar, "El fichero no contiene el mensaje esperado");
        } catch (Exception e) {
            fail("Se ha producido un error no controlado");
        }
    }

    @Test
    public void eliminarNoExisteTest() {
        String nombrefichero = "ficheroNoExiste.txt";

        try {
            fichero.eliminar(nombrefichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("No se puede eliminar un fichero que no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (eliminarExisteTest) ha generado un error no controlado");
        }
    }

    private void eliminar() {
        try {
            fichero.eliminar(nombrefichero);
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }

    private void crear() {
        try {
            fichero.crear(nombrefichero, contenidofichero);
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }

    @Test
    public void NoesDirectorioTest() throws FicheroException {
        boolean directorio = fichero.esDirectorio(nombrefichero);
        assertFalse(directorio, "Se ha provocado un error");
    }

    @Test
    public void esDirectorioTest() throws FicheroException {
        boolean directorio = fichero.esDirectorio("src");
        assertTrue(directorio, "Se ha provocado un error");
    }
}
