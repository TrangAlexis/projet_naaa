package ajc.formation.soprasteria.appliSport.restcontrollers;

import ajc.formation.soprasteria.appliSport.entities.Coach;
import ajc.formation.soprasteria.appliSport.services.CoachServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachRestController {
    @Autowired
    CoachServices coachServices;

    @GetMapping("")
    public List<Coach> getAll() {
        return coachServices.getAll();
    }

    @GetMapping("/{id}")
    public Coach getById(@PathVariable("id") Long id){
        return coachServices.getById(id);
    }

    @PostMapping("")
    public void createOrUpdate(@Valid @RequestBody Coach coach){
         coachServices.createOrUpdate(coach);
    }

    @DeleteMapping("")
    public void delete(@Valid @RequestBody Coach coach){
        coachServices.delete(coach);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        coachServices.deleteById(id);
    }


}
