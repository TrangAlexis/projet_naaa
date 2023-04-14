package ajc.formation.soprasteria.appliSport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class AppliSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliSportApplication.class, args);
	}

}
