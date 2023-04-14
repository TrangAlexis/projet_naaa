package ajc.formation.soprasteria.appliSport.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.services.ExerciceServices;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/exercice")
public class ExerciceRestController {
	
	@Autowired
	private ExerciceServices exerciceSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Simple.class)
	public List<Exercice> getAll() {
		return exerciceSrv.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Exercice getById(@PathVariable Long id) {
//		Exercice exercice = null;
//		try {
//			exercice = exerciceSrv.findById(id);
//		} catch (ExerciceException ex) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//		return exercice;
//	}
	
	@PostMapping({"", "ajouter"})
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Simple.class)
	public Exercice create(@Valid @RequestBody Exercice exercice, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		exerciceSrv.save(exercice);;
		return exerciceSrv.findById(exercice.getId());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		exerciceSrv.deleteById(id);
	}


	
	
	
}
