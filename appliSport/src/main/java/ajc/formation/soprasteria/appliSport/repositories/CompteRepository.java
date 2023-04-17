package ajc.formation.soprasteria.appliSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.appliSport.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	Optional<Compte> findByLogin(String login);

}
