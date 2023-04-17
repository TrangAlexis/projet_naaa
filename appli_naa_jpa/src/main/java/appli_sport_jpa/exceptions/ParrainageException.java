package appli_sport_jpa.exceptions;

public class ParrainageException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ParrainageException() {

    }

    public ParrainageException(String message) {
        super(message);
    }
}
