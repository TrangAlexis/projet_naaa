package appli_sport_jpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import appli_sport_jpa.entities.Client;
import appli_sport_jpa.entities.jsonviews.JsonViews;
import appli_sport_jpa.services.ClientServices;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	
	@Autowired
	private ClientServices clientSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Simple.class)
	public List<Client> getAll() {
		return clientSrv.findAll();
	}

}
