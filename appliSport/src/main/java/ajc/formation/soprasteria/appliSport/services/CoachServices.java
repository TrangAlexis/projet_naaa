package ajc.formation.soprasteria.appliSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.exceptions.CoachException;
import ajc.formation.soprasteria.appliSport.repositories.CoachRepository;

@Service
public class CoachServices   {
	@Autowired
	private CoachRepository coachRepository;
	
	public List<Coach> getAll() {
		 List<Coach> coachs = coachRepository.findAll();
		if(coachs.isEmpty()) {
			throw new CoachException("databse coache is empty");
		}
		return coachs;
	}

	public Coach getById(Long id) {
		if (id == null) {
			throw new CoachException("id obligatoire");
		}
		return coachRepository.findById(id).orElseThrow(() -> {
			throw new CoachException("id inconnu");
		});
	}

	public void delete(Coach coach) {
		deleteById(coach.getId());
	}

	public void deleteById(Long id) {
		Coach coach = getById(id);
		coachRepository.delete(coach);
	}

	public void createOrUpdate(Coach coach) {
		if (coach.getNom() == null || coach.getNom().isBlank()) {
			throw new CoachException("nom obligatoire");
		}
		if (coach.getPrenom() == null || coach.getPrenom().isBlank()) {
			throw new CoachException("prenom obligatoire");
		}
		if (coach.getLogin() == null || coach.getLogin().isBlank()) {
			throw new CoachException("login obligatoire");
		}
		if (coach.getMdp() == null || coach.getMdp().isBlank()) {
			throw new CoachException("mdp obligatoire");
		}
		coachRepository.save(coach);
	}

}
