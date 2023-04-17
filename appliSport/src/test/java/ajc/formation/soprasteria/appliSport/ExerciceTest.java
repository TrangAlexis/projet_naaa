package ajc.formation.soprasteria.appliSport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.repositories.ExerciceRepository;
import ajc.formation.soprasteria.appliSport.services.ExerciceServices;

@SpringBootTest
@Transactional
@Rollback
public class ExerciceTest {
	
	@Autowired
    private ExerciceRepository exerciceRepository;
	
	@Autowired
    private ExerciceServices exerciceServices;
	
	 @Test
	    public void testSave() {
	        Exercice exercice = new Exercice("testSave_Exo_Name", "testSave_Exo_Description");
	        exerciceRepository.save(exercice);

	        Exercice savedExercice = exerciceRepository.findById(exercice.getId()).orElse(null);
	        assertNotNull(savedExercice);
	        assertEquals(exercice.getNom(), savedExercice.getNom());
	        assertEquals(exercice.getDescription(), savedExercice.getDescription());
	    }
	
	@Test
	public void testFindAll() {
	    Exercice exercice1 = new Exercice("testFindAll_Exo1_Name", "testFindAll_Exo1_Description");
	    Exercice exercice2 = new Exercice("testFindAll_Exo2_Name", "testFindAll_Exo2_Description");
	    exerciceRepository.save(exercice1);
	    exerciceRepository.save(exercice2);
	    
	    List<Exercice> exercices = exerciceRepository.findAll();
	    assertEquals(2, exercices.size());
	    assertTrue(exercices.contains(exercice1));
	    assertTrue(exercices.contains(exercice2));
	}
	
	@Test
    public void testFindById() {
        Exercice exercice = new Exercice("testFindById_Exo_Name", "testFindById_Exo_Description");
        exerciceRepository.save(exercice);

        Exercice foundExercice = exerciceRepository.findById(exercice.getId()).orElse(null);
        assertNotNull(foundExercice);
        assertEquals(exercice.getNom(), foundExercice.getNom());
        assertEquals(exercice.getDescription(), foundExercice.getDescription());
    }
	
	@Test
    public void testDeleteById() {
        Exercice exercice = new Exercice("testDelete_Exo_Name", "testDelete_Exo_Description");
        exerciceRepository.save(exercice);
        
        Long id = exercice.getId();
        exerciceServices.deleteById(id);
        assertFalse(exerciceRepository.existsById(id));
    }
	
	 @Test
	    public void testUpdate() {
	        // Création du'n nouvel exo et save
	        Exercice exercice = new Exercice("Exercice 1", "Description Exercice 1");
	        exerciceServices.save(exercice);

	        // Update le nom de l'exo
	        exercice.setNom("Exercice 1 updated");
	        exerciceServices.update(exercice);

	        // Check si le update est réussi ou pa
	        Exercice updatedExercice = exerciceRepository.findById(exercice.getId()).orElse(null);
	        assertNotNull(updatedExercice);
	        assertEquals("Exercice 1 updated", updatedExercice.getNom());
	    }
}
