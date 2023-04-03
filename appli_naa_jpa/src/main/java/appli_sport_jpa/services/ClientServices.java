package appli_sport_jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appli_sport_jpa.entities.Client;
import appli_sport_jpa.exceptions.ClientException;
import appli_sport_jpa.repositories.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;
	
	public void save(Client client) {
		if (client.getLogin()==null || client.getLogin().isBlank()) {
			throw new ClientException("Client sans login");
		}
		if (client.getEmail()==null || client.getEmail().isBlank()) {
			throw new ClientException("Client sans e-mail");
		}
		clientRepository.save(client);
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
