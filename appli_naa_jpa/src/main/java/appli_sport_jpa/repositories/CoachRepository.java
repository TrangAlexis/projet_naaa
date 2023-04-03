package appli_sport_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import appli_sport_jpa.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
