package ajc.formation.soprasteria.appliSport.restcontrollers;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.appliSport.services.CoachServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;

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

    @GetMapping("/{id}")
    @JsonView(JsonViews.Coach.class)
    public Coach getById(@PathVariable("id") Long id){
        return coachServices.getById(id);
    }

    @PostMapping("")
    @JsonView(JsonViews.Coach.class)
    public void createOrUpdate(@Valid @RequestBody Coach coach){
         coachServices.createOrUpdate(coach);
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
