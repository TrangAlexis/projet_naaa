package ajc.formation.soprasteria.appliSport.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import ajc.formation.soprasteria.appliSport.repositories.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteServices compteSrv;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void updateClient(Client client) {
		if (client.getNom() == null || client.getNom().isBlank()) {
			throw new ClientException("nom obligatoire");
		}
		if (client.getCompte().getLogin() == null || client.getCompte().getLogin().isBlank()) {
			throw new ClientException("login obligatoire");
		}
		if (client.getCompte().getPassword() == null || client.getCompte().getPassword().isBlank()) {
			throw new ClientException("mdp obligatoire");
		}
		clientRepository.save(client);
	}

	public void updateClientPassword(String nom, String newPassword) {
		Client client = findByNom(nom);
		client.getCompte().setPassword(passwordEncoder.encode(newPassword));
		clientRepository.save(client);
	}

	public void updateClientRole(Client client) {

	}

	public Client createClientFreemium(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			compteSrv.createClientFreemium(client.getCompte());
			return clientRepository.save(client);
		} else {
			throw new ClientException();
		}
	}

	public Client createClientPremium(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			compteSrv.createClientPremium(client.getCompte());
			return clientRepository.save(client);
		} else {
			throw new ClientException();
		}
	}




	public Client findByNom(String nom) {
		return clientRepository.findByNom(nom);
	}

	public List<Client> findAll(){
		List<Client> lClients = clientRepository.findAll();
		if (lClients.isEmpty()) {
			throw new ClientException("La base de données de clients est vide");
		}
		return lClients;
	}

	public void deleteByNom(String nom) {
		Client client = findByNom(nom);
		if(client != null) {
			clientRepository.delete(client);
		}
	}



}
