package ajc.formation.soprasteria.appliSport.services;

import ajc.formation.soprasteria.appliSport.entities.AmiAmis;
import ajc.formation.soprasteria.appliSport.entities.AmiAmisId;
import ajc.formation.soprasteria.appliSport.entities.Client;
import ajc.formation.soprasteria.appliSport.exceptions.ClientException;
import ajc.formation.soprasteria.appliSport.repositories.AmiAmisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AmiAmisServices {

    @Autowired
    private ClientServices clientServices;
    @Autowired
    private AmiAmisRepository amiAmisRepository;

        @Autowired
        public  AmiAmisServices(AmiAmisRepository amiAmisRepository){
            this.amiAmisRepository=amiAmisRepository;
        }

       public List<Client> findAmisByClientNom(String nom){
            return amiAmisRepository.findAmisByClientNom(nom);
        }

    // l'ajout d'une relation d'amitié entre deux clients
    public AmiAmis ajouterAmiAmis(Client client1, Client client2) {
        AmiAmis amiAmis = new AmiAmis(client1,client2);
        return amiAmisRepository.save(amiAmis);
    }

    //suppression de la relation d'amitié entre deux clients
    public void supprimerAmiAmis(AmiAmis amiAmis) {

        amiAmisRepository.delete(amiAmis);
    }





}
