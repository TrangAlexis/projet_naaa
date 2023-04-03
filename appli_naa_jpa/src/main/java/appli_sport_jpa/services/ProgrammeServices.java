package appli_sport_jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appli_sport_jpa.entities.Programme;
import appli_sport_jpa.exceptions.ProgrammeException;
import appli_sport_jpa.repositories.ProgrammeRepository;

@Service
public class ProgrammeServices {
	
	@Autowired
	private ProgrammeRepository programmeRepo;
	
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


}
