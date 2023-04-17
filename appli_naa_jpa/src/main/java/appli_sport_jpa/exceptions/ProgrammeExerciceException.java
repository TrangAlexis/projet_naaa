package appli_sport_jpa.exceptions;

public class ProgrammeExerciceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProgrammeExerciceException() {

	}

	public ProgrammeExerciceException(String message) {
		super(message);
	}

}
