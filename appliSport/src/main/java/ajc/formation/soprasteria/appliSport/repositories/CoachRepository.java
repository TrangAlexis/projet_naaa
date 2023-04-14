package ajc.formation.soprasteria.appliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.soprasteria.appliSport.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    //Coach findByLogin(String login);

}
