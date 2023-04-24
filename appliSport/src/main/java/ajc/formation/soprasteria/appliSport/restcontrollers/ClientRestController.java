package ajc.formation.soprasteria.appliSport.restcontrollers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.services.ClientServices;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;


@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private ClientServices clientSrv;
	@Autowired
	private PasswordEncoder passwordEncoder;

//	@GetMapping("")
//	public String Hey() {
//		return "Hey";
//	}

	@GetMapping("")
	@JsonView(JsonViews.Client.class)
	public List<Client> findAll() {
		return clientSrv.findAll();
	}

	@GetMapping("/{nom}")
	@JsonView(JsonViews.Client.class)
	public Client getByNom(@PathVariable String nom) {
		Client client = null;
		client = clientSrv.findByNom(nom);
		return client;
	}

	@PostMapping({ "", "/inscription" })
	@JsonView(JsonViews.Client.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		int role = client.getCompte().getRole().ordinal();
		if (role == 0) {
			clientSrv.createClientFreemium(client);
		} else if (role == 1) {
			clientSrv.createClientPremium(client);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role");
		}
		return client;
	}


	@PutMapping("/{nom}")
	@JsonView(JsonViews.Client.class)
	public Client update(@RequestBody Client client, @PathVariable String nom) {
		Client clientEnBase = clientSrv.findByNom(nom);
		if (client.getNom() != null) {
			clientEnBase.setNom(client.getNom());
		}
		if (client.getCompte().getLogin() != null) {
			clientEnBase.getCompte().setLogin(client.getCompte().getLogin());
		}
		if (client.getCompte().getPassword() != null && !client.getCompte().getPassword().isBlank()) {
			clientEnBase.getCompte().setPassword(passwordEncoder.encode(client.getCompte().getPassword()));
		}
		if (client.getCompte().getRole() != null) {
			clientEnBase.getCompte().setRole(client.getCompte().getRole());
		}
		if (client.getPointsDeSucces() != null) {
			clientEnBase.setPointsDeSucces(client.getPointsDeSucces());
		}
		if (client.getProgramme() != null) {
			clientEnBase.setProgramme(client.getProgramme());
		}
		clientSrv.updateClient(clientEnBase);
		return clientEnBase;
	}

	@DeleteMapping("/{nom}")
	public void deleteClient(@PathVariable String nom) {
		Client client = clientSrv.findByNom(nom);
		if (client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
		}
		clientSrv.deleteByNom(nom);
	}






}
