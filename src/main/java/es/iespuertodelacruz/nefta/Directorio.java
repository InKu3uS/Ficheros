package es.iespuertodelacruz.nefta;

import java.io.File;
import es.iespuertodelacruz.nefta.exception.DirectorioException;

public class Directorio {

    /**
     * Metodo que comprueba que un directorio existe
     * 
     * @param directorio a buscar
     * @return true o false
     */
    public boolean validar(File directorio) {
        return directorio.exists();
    }

    /**
     * Metodo para crear un directorio
     * 
     * @param nombre del directorio
     * @throws DirectorioException
     */
    public void crear(String nombre) throws DirectorioException {
        try {
            File directorio = new File(nombre);
            if (!validar(directorio)) {
                directorio.mkdirs();
            } else {
                throw new DirectorioException("El directorio ya existe");
            }
        } catch (DirectorioException e) {
            throw new DirectorioException("El directorio no ha podido crearse");
        }
    }

    /**
     * Metodo encargado de borrar un directorio
     * 
     * @param nombre del fichero o directorio a eliminar
     * @throws DirectorioException error controlado
     */
    public void eliminar(String nombre) throws DirectorioException {
        File directorio = new File(nombre);
        if (validar(directorio)) {
            directorio.delete();
        } else {
            throw new DirectorioException("No se puede eliminar un fichero que no existe");
        }
    }
}
