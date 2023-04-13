package ajc.formation.soprasteria.appliSport.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public class CompteExceptions extends UsernameNotFoundException {
		private static final long serialVersionUID = 1L;

		public CompteExceptions() {
			super("compte inconnu");
		}

		public CompteExceptions(String message) {
			super(message);
		}


	}

