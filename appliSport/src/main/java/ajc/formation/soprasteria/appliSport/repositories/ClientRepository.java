package ajc.formation.soprasteria.appliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.appliSport.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
     Client findByNom(String nom);
}
