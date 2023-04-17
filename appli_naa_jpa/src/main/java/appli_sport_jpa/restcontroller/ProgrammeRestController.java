package appli_sport_jpa.restcontroller;

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

import appli_sport_jpa.entities.Programme;
import appli_sport_jpa.entities.jsonviews.JsonViews;
import appli_sport_jpa.services.ProgrammeServices;

@RestController
@RequestMapping("/api/programme")
public class ProgrammeRestController {
	
	@Autowired
	private ProgrammeServices programmeSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Simple.class)
	public List<Programme> getAll(){
		return programmeSrv.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Simple.class)
	public Programme create(@Valid @RequestBody Programme programme, BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		programmeSrv.save(programme);
		return programmeSrv.findById(programme.getId());
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		programmeSrv.deleteById(id);
	}
}
