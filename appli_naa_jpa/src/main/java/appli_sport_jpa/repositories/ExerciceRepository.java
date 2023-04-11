package appli_sport_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appli_sport_jpa.entities.Exercice;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

}
