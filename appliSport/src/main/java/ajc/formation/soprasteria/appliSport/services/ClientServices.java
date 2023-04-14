package ajc.formation.soprasteria.appliSport.services;

import java.util.List;
import java.util.Set;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import ajc.formation.soprasteria.appliSport.repositories.ClientRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteServices compteSrv;

	@Autowired
	private CoachRepository coachRepository;
	
	public void save(Client client) {
		if (client.getLogin()==null || client.getLogin().isBlank()) {
			throw new ClientException("Client sans login");
		}
		if (client.getEmail()==null || client.getEmail().isBlank()) {
			throw new ClientException("Client sans e-mail");
		}
		clientRepository.save(client);
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

	public void deleteById(Long id) {
		Client checkClient = this.findById(id);
		clientRepository.deleteById(id);
	}
	
	public void delete(Client client) {
		this.deleteById(client.getId());
	}
		
	public Client findById(Long id) {
		return clientRepository.findById(id).orElseThrow(() -> {
			throw new ClientException("ID manquante dans la base de données de clients: "+id);
		});
	}
	
	public List<Client> findAll(){
		List<Client> lClients = clientRepository.findAll();
		if (lClients.isEmpty()) {
			throw new ClientException("La base de données de clients est vide");
		}
		return lClients;
	}

}
