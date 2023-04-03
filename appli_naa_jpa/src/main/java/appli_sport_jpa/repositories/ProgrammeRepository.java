package appli_sport_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import appli_sport_jpa.entities.Programme;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {

}
