package appli_sport_jpa.services;

import appli_sport_jpa.entities.Client;
import appli_sport_jpa.entities.ClientTemporaire;
import appli_sport_jpa.entities.Parrainage;
import appli_sport_jpa.exceptions.ParrainageException;
import appli_sport_jpa.repositories.ClientRepository;
import appli_sport_jpa.repositories.ParrainageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParrainageService {
    @Autowired
    private ParrainageRepository parrainageRepository;

    @Autowired
    private ClientRepository clientRepository;

    Parrainage save(Parrainage entity){
        if(entity.getEtreClient() != null && entity.getEtreClient().getLogin() != null && clientRepository.findByLogin(entity.getEtreClient().getLogin()) != null)
            throw new ParrainageException("Client deja existe");
        Client newClient = new Client();
        newClient = ClientTemporaireToClient(entity.getEtreClient());
        clientRepository.save(newClient);
       return parrainageRepository.save(entity);
    }

    Client ClientTemporaireToClient(ClientTemporaire clientTemporaire){
        Client newClient = new Client();
        newClient.setNom(clientTemporaire.getNom());
        newClient.setPrenom(clientTemporaire.getPrenom());
        newClient.setEmail(clientTemporaire.getEmail());
        newClient.setDateNaissance(clientTemporaire.getDateNaissance());
        newClient.setLogin(clientTemporaire.getLogin());
        newClient.setMdp(clientTemporaire.getMdp());
        return newClient;
    }


}
