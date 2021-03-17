package es.iespuertodelacruz.nefta;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.iespuertodelacruz.nefta.exception.DirectorioException;

public class DirectorioTest {

    Directorio directorio = null;
    String nombre = "Prueba";

    @BeforeEach
    public void setup() throws DirectorioException {
        if (directorio == null) {
            directorio = new Directorio();
        }
        crear();
    }

    @AfterEach
    public void after() throws DirectorioException {
        eliminar();
    }

    @Test
    public void DirectorioExisteTest(){

        
    }


    /**
     * Crea un directorio para usar en los test
     * 
     * @throws DirectorioException error controlado
     */
    private void crear() throws DirectorioException {
        directorio.crear(nombre);
    }

    /**
     * Elimina el directorio creado para los test
     * 
     * @throws DirectorioException error controlado
     */
    private void eliminar() throws DirectorioException {
        directorio.eliminar(nombre);
    }
}
