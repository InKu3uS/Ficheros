package es.iespuertodelacruz.nefta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import es.iespuertodelacruz.nefta.exception.FicheroException;

public class Fichero {

    public String leer(String nombre) throws FicheroException {

        StringBuilder informacion = null;
        File fichero = null;
        Scanner scanner = null;

        try {

            fichero = new File(nombre);

            if (!validarFichero(fichero)) {

                throw new FicheroException("El fichero a leer no existe");
            }
            informacion = new StringBuilder();
            scanner = new Scanner(fichero);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                informacion.append(linea + "\n");
            }
        } catch (FicheroException e) {
            throw e;
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }

    /**
     * Metodo encargado de crear un fichero
     * 
     * @param nombre del fichero a crear
     * @throws FicheroException
     */
    public void crear(String nombre, String cadenaTexto) throws FicheroException {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombre);
            fichero.write(cadenaTexto + "\n");
        } catch (Exception ex) {
            throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new FicheroException("No ha sido podible cerrar el fichero", e);
                }
            }
        }

    }

    /**
     * Metodo que comprueba que un fichero existe
     * 
     * @param fichero a buscar
     * @return true o false
     */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    /**
     * Metodo encargado de borrar un fichero o directorio
     * 
     * @param nombre del fichero o directorio a eliminar
     * @throws FicheroException error controlado
     */
    public void eliminar(String nombre) throws FicheroException {
        File fichero = new File(nombre);
        if (validarFichero(fichero)) {
            fichero.delete();
        } else {
            throw new FicheroException("No se puede eliminar un fichero que no existe");
        }
    }
    /**
     * Funcion que verifica si es un directorio o no
     * @param path de la ruta a validar
     * @return true o false
     */
    public boolean esDirectorio(String path){
        File fichero = new File(path);
        return fichero.isDirectory();
    }
}
