package ajc.formation.soprasteria.appliSport.restcontrollers;

import ajc.formation.soprasteria.appliSport.entities.AmiAmis;
import ajc.formation.soprasteria.appliSport.entities.AmiAmisId;
import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import ajc.formation.soprasteria.appliSport.exceptions.AmiAmisException;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import ajc.formation.soprasteria.appliSport.repositories.AmiAmisRepository;
import ajc.formation.soprasteria.appliSport.services.AmiAmisServices;
import ajc.formation.soprasteria.appliSport.services.ClientServices;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/amis")
public class AmiAmisRestController {

    @Autowired
    private AmiAmisServices amiAmisServices;
    @Autowired
    private ClientServices clientServices;
    @Autowired
    private AmiAmisRepository amiAmisRepository;
    @GetMapping("/{nom}")
    @JsonView(JsonViews.AmiAmis.class)
    public List<Client> findAmisByClientNom(@PathVariable("nom") String nom){
        return amiAmisServices.findAmisByClientNom(nom);
    }

    @PostMapping("/ajouterAmiAmis/{id1}/{id2}")
    @JsonView(JsonViews.AmiAmis.class)
    public ResponseEntity<AmiAmis> ajouterAmiAmis(@PathVariable("id1") String id1, @PathVariable("id2") String id2){
        try{
            Client client1 = clientServices.findByNom(id1);
            Client client2 = clientServices.findByNom(id2);
            AmiAmis amiAmis = amiAmisServices.ajouterAmiAmis(client1,client2);
            return ResponseEntity.status(HttpStatus.CREATED).body(amiAmis);
        }catch (ClientException e){
            throw new AmiAmisException(e.getMessage());
        }
    }
    @DeleteMapping("/supprimerAmiAmis/{id1}/{id2}")
    public ResponseEntity<Void> supprimerAmiAmis(@PathVariable("id1") String id1, @PathVariable("id2") String id2){
        try {
            AmiAmisId amiAmisId = new AmiAmisId(id1, id2);
            Optional<AmiAmis> amiAmis = amiAmisRepository.findById(amiAmisId);
            if (amiAmis.isPresent()) {
                amiAmisServices.supprimerAmiAmis(amiAmis.get());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (ClientException e) {
            throw new AmiAmisException(e.getMessage());
        }
    }
    @ExceptionHandler(AmiAmisException.class)
    public ResponseEntity<String> handleException(AmiAmisException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<String> handleClientException(ClientException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
