package es.iespuertodelacruz.nefta.exception;

public class FicheroException extends Exception{

    
    private static final long serialVersionUID = -4862139808541301882L;


    public FicheroException(String mensaje) {
        super(mensaje);
    }

    public FicheroException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
