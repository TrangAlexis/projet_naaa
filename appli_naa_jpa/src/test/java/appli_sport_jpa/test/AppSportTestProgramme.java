package appli_sport_jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
	
	static AnnotationConfigApplicationContext ctx = null;
	
	ProgrammeServices programmeServices;
	
	
	@BeforeAll
	static void initSpring() {
		ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
	}
	@AfterAll
	static void closeString() {
		ctx.close();
	}
	@BeforeEach
	void getProgrammeServices() {
		programmeServices = ctx.getBean(ProgrammeServices.class);
	}
	
	
	
	
	
	
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
