package ajc.formation.soprasteria.appliSport.repositories;

import ajc.formation.soprasteria.appliSport.entities.Programme;
import ajc.formation.soprasteria.appliSport.entities.ProgrammeExercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProgrammeExerciceRepository extends JpaRepository<ProgrammeExercice, Long> {
    @Modifying
    @Transactional
    @Query("delete from ProgrammeExercice a where a.id.programme:programme")
    void deleteByProgramme(@Param("programme") Programme programme);
}
