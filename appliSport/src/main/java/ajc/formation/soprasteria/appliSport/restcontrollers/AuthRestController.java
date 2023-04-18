package ajc.formation.soprasteria.appliSport.restcontrollers;

import ajc.formation.soprasteria.appliSport.entities.Compte;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.appliSport.repositories.CompteRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private CompteRepository compteRepository;

    private final static Logger LOGGER= LoggerFactory.getLogger(AuthRestController.class);


    @GetMapping("")
    @JsonView(JsonViews.Simple.class)
    public Compte auth(@AuthenticationPrincipal Compte compte) {
        LOGGER.info(compte.getLogin());
        return compte;
    }

    @GetMapping("/check/{login}")
    public boolean loginExist(@PathVariable String login) {
        return compteRepository.findByLogin(login).isPresent();
    }

}
