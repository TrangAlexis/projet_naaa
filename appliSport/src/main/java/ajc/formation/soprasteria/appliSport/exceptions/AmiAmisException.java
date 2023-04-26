package ajc.formation.soprasteria.appliSport.exceptions;

public class AmiAmisException extends RuntimeException{

    public AmiAmisException(String message){
        super(message);
    }
    public AmiAmisException(String message, Throwable cause){
        super(message, cause);
    }
}
