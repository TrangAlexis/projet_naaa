package appli_sport_jpa.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import appli_sport_jpa.config.JpaConfig;
import appli_sport_jpa.entities.Programme;
import appli_sport_jpa.exceptions.ProgrammeException;
import appli_sport_jpa.services.ProgrammeServices;


@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class AppSportTestProgramme {
	
	
	@Autowired
	ProgrammeServices programmeServices;
	

	@Test
	void insertProgrammeTest() {
		Programme programme = new Programme("progr1", 15, null, null, null);
		programmeServices.save(programme);
		assertNotNull(programme.getId());
	}
	
	@Test
	void findByIdProgrammeExceptionInvalideTest() {
		assertThrows(ProgrammeException.class, ()-> programmeServices.findById(77L));
	}

	@Test
	void findByIdProgrammeExceptionInexistantTest() {
		assertThrows(ProgrammeException.class, ()-> programmeServices.findById(null));
	}
	
	@Test
	void deleteByIdProgrammeTest() {
		Programme programme = new Programme("progr1", 15, null, null, null);
		programmeServices.save(programme);
		Long cle = programme.getId();
		programmeServices.deleteById(cle);
	}
}
