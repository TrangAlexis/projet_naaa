package ajc.formation.soprasteria.appliSport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.services.CoachServices;

@SpringBootTest
@Transactional
@Rollback
public class AppSportTestCoach {
	
	static AnnotationConfigApplicationContext ctx = null;
	
	@Autowired
	CoachServices coachServices;
	
//	@BeforeAll
//	static void initSpring() {
//		ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
//	}
//	
//	@BeforeEach
//	void getCoachServices() {
//		coachServices = ctx.getBean(CoachServices.class);
//	}
//	
//	@AfterAll
//	static void closeSpring() {
//		ctx.close();
//	}
	
	@Test
	void coachServiceExistenceTest() {
		assertNotNull(coachServices);
	}
	
	@Test
	void createTest() {
		Coach coach = new Coach("nomeC1", "nomeC1", "C1@mail", "C1Login", "Mdp-C1", 10, LocalDate.now());
		coachServices.create(coach);
		assertNotNull(coach.getId());
		System.out.println(coach.getId());
		assertNotNull(coach.getMdp());
		System.out.println(coach.getMdp());
	}
	
	@Test
	void updateTest() {
		Coach coach = new Coach("nomeC2", "nomeC2", "C2@mail", "C2Login", "Mdp-C2", 20, LocalDate.now());
		coachServices.create(coach);
		assertNotNull(coach.getId());
		System.out.println(coach.getId());
		coach.setNom("UpdatedName");
		coachServices.update(coach);
		Coach updatedCoach = coachServices.getById(coach.getId());
		assertNotNull(updatedCoach);
		System.out.println(updatedCoach.getNom());
	}
	
	@Test
	void deleteTest() {
		Coach coach = new Coach("nomeC3", "nomeC3", "C3@mail", "C3Login", "Mdp-C3", 30, LocalDate.now());
		coachServices.create(coach);
		assertNotNull(coachServices.getAll());
		coachServices.delete(coach);
	}
}