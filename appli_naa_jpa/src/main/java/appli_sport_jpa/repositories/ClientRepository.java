package appli_sport_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import appli_sport_jpa.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByLogin(String login);
}
