package es.iespuertodelacruz.nefta.exception;

public class DirectorioException extends Exception {


    private static final long serialVersionUID = -3618703489359610064L;
    

    public DirectorioException(String mensaje) {
        super(mensaje);
    }

    public DirectorioException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
