package ajc.formation.soprasteria.appliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajc.formation.soprasteria.appliSport.entities.Exercice;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

}
