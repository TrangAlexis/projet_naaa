package ajc.formation.soprasteria.appliSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews.Programme;


public interface ExerciceRepository extends JpaRepository<Exercice, Long> {


}
