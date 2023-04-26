package ajc.formation.soprasteria.appliSport.services;

import java.util.List;
import java.util.Set;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.exceptions.CoachException;
import ajc.formation.soprasteria.appliSport.repositories.CoachRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class CoachServices   {
	@Autowired
	private CoachRepository coachRepository;

	@Autowired
	private CompteServices compteSrv;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Coach> getAll() {
		 List<Coach> coachs = coachRepository.findAll();
		if(coachs.isEmpty()) {
			throw new CoachException("databse coache is empty");
		}
		return coachs;
	}

	public Coach getByNom(String nom) {
		if (nom == null) {
			throw new CoachException("id obligatoire");
		}
		return coachRepository.findByNom(nom);
	}
	
	
	public Coach findByNom(String nom) {
		return coachRepository.findByNom(nom);
	}


	public void deleteByNom(String nom) {
		Coach coach = getByNom(nom);
		coachRepository.delete(coach);
	}

	public void updateCoach(Coach coach) {
		if (coach.getNom() == null || coach.getNom().isBlank()) {
			throw new CoachException("nom obligatoire");
		}
		if (coach.getCompte().getLogin() == null || coach.getCompte().getLogin().isBlank()) {
			throw new CoachException("login obligatoire");
		}
		if (coach.getCompte().getPassword() == null || coach.getCompte().getPassword().isBlank()) {
			throw new CoachException("mdp obligatoire");
		}
		if (coach.getAvatar() == null || coach.getAvatar().isBlank()) {
			throw new ClientException("avatar obligatoire");
		}
		//coach.getCompte().setPassword(passwordEncoder.encode(coach.getCompte().getPassword()));
		coachRepository.save(coach);
	}
	
	public void updateCoachPassword(String nom, String newPassword) {
		Coach coach = getByNom(nom);
		coach.getCompte().setPassword(passwordEncoder.encode(newPassword));
		coachRepository.save(coach);
	}

	public Coach createCoach(Coach coach) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Coach>> violations = validator.validate(coach);
		if (violations.isEmpty()) {
			compteSrv.createCoach(coach.getCompte());
			return coachRepository.save(coach);
		} else {
			throw new ClientException();
		}
	}

}
