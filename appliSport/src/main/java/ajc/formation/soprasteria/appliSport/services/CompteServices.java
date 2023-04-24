package ajc.formation.soprasteria.appliSport.services;

import javax.validation.Validator;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Compte;
import ajc.formation.soprasteria.appliSport.entities.Role;
import ajc.formation.soprasteria.appliSport.exceptions.CompteExceptions;
import ajc.formation.soprasteria.appliSport.repositories.CompteRepository;

import java.util.Optional;

@Service
public class CompteServices {
	
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private Validator validator;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Compte createClientFreemium(Compte compte) {
		compte.setRole(Role.ROLE_CLIENTFREEMIUM);
		return create(compte);
	}
	
	public Compte createClientPremium(Compte compte) {
		compte.setRole(Role.ROLE_CLIENTPREMIUM);
		return create(compte);
	}

	public Compte createCoach(Compte compte) {
		compte.setRole(Role.ROLE_COACH);
		return create(compte);
	}

	public void updateCompte(Compte compte) {
		if (compte.getLogin() == null || compte.getLogin().isBlank()) {
			throw new ClientException("nom obligatoire");
		}
		if (compte.getPassword() == null || compte.getPassword().isBlank()) {
			throw new ClientException("login obligatoire");
		}
		if (compte.getRole() == null) {
			throw new ClientException("mdp obligatoire");
		}
		compteRepo.save(compte);
	}

	private Compte create(Compte compte) {
		if (!validator.validate(compte).isEmpty()) {
			throw new CompteExceptions();
		}
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		return compteRepo.save(compte);
	}

	public Compte findByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(() -> {
			throw new CompteExceptions();
		});
	}
}
