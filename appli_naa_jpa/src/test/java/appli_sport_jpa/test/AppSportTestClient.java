package appli_sport_jpa.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import appli_sport_jpa.config.JpaConfig;
import appli_sport_jpa.entities.Client;
import appli_sport_jpa.services.ClientServices;


@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class AppSportTestClient {
	
	@Autowired
	ClientServices clientService;

	
	@Test
	void clientServiceExistTest() {
		assertNotNull(clientService);
	}
	
	@Test
	void insertTest() {
		Client client = new Client("Bob","Billy","Billy@Bob","bb","mdp",0,LocalDate.now(),false, null);
		clientService.save(client);
		assertNotNull(client.getId());
		System.out.println(client.getId());
	}
	
	@Test
	void deleteTest() {
		Client client = new Client("Bob","Billy","Billy@Bob","bb","mdp",0,LocalDate.now(),false, null);
		clientService.save(client);
		System.out.println(clientService.findAll().size());
		assertNotNull(clientService.findAll());
		clientService.deleteById(client.getId());
		
	}
	

}
