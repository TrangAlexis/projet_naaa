package ajc.formation.soprasteria.appliSport.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.entities.Programme;
import ajc.formation.soprasteria.appliSport.exceptions.ProgrammeException;
import ajc.formation.soprasteria.appliSport.repositories.ExerciceRepository;
import ajc.formation.soprasteria.appliSport.repositories.ProgrammeRepository;

@Service
public class ProgrammeServices implements CommandLineRunner{
	
	@Autowired
	private ProgrammeRepository programmeRepo;
	
	@Autowired
	private ExerciceRepository exerciceRepo;
	
	
	public void save(Programme programme) {
		if (programme.getNom() == null || programme.getNom().isBlank()) {
			throw new ProgrammeException("Nom de programme obligatoire");
		}
		if (programme.getNombreJours() == null) {
			throw new ProgrammeException("Durée du programme obligatoire");
		}
		programmeRepo.save(programme);
	}	
	
	
	public Programme findById(Long id) {
		if (id == null) {
			throw new ProgrammeException("id obligatoire");
		}
		return programmeRepo.findById(id).orElseThrow(() -> {
			throw new ProgrammeException("id inconnu");
		});
	}

	@SuppressWarnings("deprecation")
	public List<Exercice> findExercicesById(Long id) {
		List<Exercice> exercices= new ArrayList<>();
		if (id == null) {
			throw new ProgrammeException("id obligatoire");
		}
		for (Long idExo:programmeRepo.findExercicesIdsByProgramme(id)) {
			exercices.add(exerciceRepo.getById(idExo));
		}
		return exercices;
	}
	
	public List<Long> findExercicesIdsById(Long id) {
		if (id == null) {
			throw new ProgrammeException("id obligatoire");
		}
		return programmeRepo.findExercicesIdsByProgramme(id);
	}
	
	public void delete(Programme programme) {
		deleteById(programme.getId());
	}

	public void deleteById(Long id) {
		Programme checkProgramme = this.findById(id);
		programmeRepo.delete(findById(id));
	}	
	
	
	public List<Programme> findAll() {
		List<Programme> listProgramme = programmeRepo.findAll();
		if(listProgramme.isEmpty()) {
			throw new ProgrammeException("La base de données de programme est vide");
		}
		return listProgramme;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProgrammeServices.class);

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-------Server started--------");
	}


}
