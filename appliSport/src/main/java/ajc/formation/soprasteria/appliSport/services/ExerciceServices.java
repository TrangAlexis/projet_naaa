package ajc.formation.soprasteria.appliSport.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.exceptions.ExerciceException;
import ajc.formation.soprasteria.appliSport.repositories.ExerciceRepository;

@Service
@Transactional
public class ExerciceServices {
	

	@Autowired
	private ExerciceRepository exerciceRepository;

	public List<Exercice> findAll() {
		return exerciceRepository.findAll();
	}

	public Exercice findById(Long id) {
		return exerciceRepository.findById(id).orElseThrow(() -> new ExerciceException("Exercice introuvable avec l'id: " + id));
	}

	public void save(Exercice exercice) {
		exerciceRepository.save(exercice);
	}

	public void deleteById(Long id) {
		if (exerciceRepository.existsById(id)) {
			exerciceRepository.deleteById(id);
		} else {
			throw new ExerciceException("Exercice introuvable avec l'id: " + id);
		}
	}

	public Exercice update(Exercice exercice) {
		if (exerciceRepository.existsById(exercice.getId())) {
			return exerciceRepository.save(exercice);
		} else {
			throw new ExerciceException("Exercice introuvable avec l'id: " + exercice.getId());
		}
	}
	

}
