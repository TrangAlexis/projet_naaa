package ajc.formation.soprasteria.appliSport.restcontrollers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.entities.ProgrammeExercice;
import ajc.formation.soprasteria.appliSport.entities.ProgrammeExerciceId;
import ajc.formation.soprasteria.appliSport.services.ExerciceServices;
import ajc.formation.soprasteria.appliSport.services.ProgrammeExerciceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import ajc.formation.soprasteria.appliSport.entities.Programme;
import ajc.formation.soprasteria.appliSport.services.ProgrammeServices;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/programme")
public class ProgrammeRestController {
	
	@Autowired
	private ProgrammeServices programmeSrv;

	@Autowired
	private ProgrammeExerciceServices programmeExerciceServices;

	@Autowired
	ExerciceServices exerciceServices;


	
	@GetMapping("")
	@JsonView(JsonViews.Simple.class)
	public List<Programme> getAll(){
		return programmeSrv.findAll();
	}

	@PostMapping("")
	@JsonView(JsonViews.Simple.class)
	public Programme create(@RequestBody List<ProgrammeExercice> exercices) {return null;}




}
