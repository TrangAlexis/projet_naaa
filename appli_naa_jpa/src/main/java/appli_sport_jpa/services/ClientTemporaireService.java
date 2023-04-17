package appli_sport_jpa.services;

import appli_sport_jpa.entities.ClientTemporaire;
import appli_sport_jpa.exceptions.ClientException;
import appli_sport_jpa.repositories.ClientRepository;
import appli_sport_jpa.repositories.ClientTemporaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientTemporaireService {
    @Autowired
    private ClientTemporaireRepository clientTemporaireRepository;
    @Autowired
    private ClientRepository clientRepository;
    
    public ClientTemporaire save(ClientTemporaire entity){
        if (entity.getLogin()==null || entity.getLogin().isBlank()) {
            throw new ClientException("Client sans login");
        }
        if (entity.getEmail()==null || entity.getEmail().isBlank()) {
            throw new ClientException("Client sans e-mail");
        }
        if(clientRepository.findByLogin(entity.getLogin()) != null)
            throw new ClientException("Client deja existe");
        entity.setDateCreation(new Date());
        return clientTemporaireRepository.save(entity);
    }

}
