package appli_sport_jpa.exceptions;

public class ProgrammeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProgrammeException() {

	}

	public ProgrammeException(String message) {
		super(message);
	}

}
