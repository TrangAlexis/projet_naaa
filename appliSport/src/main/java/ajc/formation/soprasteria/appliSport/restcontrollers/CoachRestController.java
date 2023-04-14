package ajc.formation.soprasteria.appliSport.restcontrollers;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.appliSport.services.CoachServices;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachRestController {
    @Autowired
    CoachServices coachServices;

    @GetMapping("")
	@JsonView(JsonViews.Coach.class)
    public List<Coach> getAll() {
        return coachServices.getAll();
    }

    @PostMapping({ "", "/inscription" })
    @JsonView(JsonViews.Coach.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Coach create(@Valid @RequestBody Coach coach, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        coachServices.createCoach(coach);
        return coach;
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Coach.class)
    public Coach getById(@PathVariable("id") Long id){
        return coachServices.getById(id);
    }

//    @PostMapping("")
//    @JsonView(JsonViews.Coach.class)
//    public void createOrUpdate(@Valid @RequestBody Coach coach){
//         coachServices.createOrUpdate(coach);
//    }
    @PostMapping("")
    @JsonView(JsonViews.Coach.class)
    public void create(@Valid @RequestBody Coach coach){
        coachServices.createCoach(coach);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Coach.class)
    public void update(@PathVariable("id") Long id, @Valid @RequestBody Coach coach){
        coach.setId(id);
        coachServices.updateCoach(coach);
    }

    @DeleteMapping("")
    @JsonView(JsonViews.Coach.class)
    public void delete(@RequestBody Coach coach){
        coachServices.delete(coach);
    }

    @DeleteMapping("/{id}")
    @JsonView(JsonViews.Coach.class)
    public void deleteById(@PathVariable("id") Long id) {
        coachServices.deleteById(id);
    }


}
