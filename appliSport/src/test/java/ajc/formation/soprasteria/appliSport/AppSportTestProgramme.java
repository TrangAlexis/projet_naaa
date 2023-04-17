package ajc.formation.soprasteria.appliSport;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ajc.formation.soprasteria.appliSport.entities.Programme;
import ajc.formation.soprasteria.appliSport.exceptions.ProgrammeException;
import ajc.formation.soprasteria.appliSport.services.ProgrammeServices;


@SpringBootTest
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
