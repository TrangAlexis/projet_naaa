package ajc.formation.soprasteria.appliSport.repositories;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.entities.Programme;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
//	@Modifying
//	@Transactional
//	@Query(value="SELECT * FROM programme_exercice pe JOIN exercice e WHERE pe.programme_id=:programmeId", nativeQuery = true)
	@Query(value="SELECT distinct e.exercice_id FROM bdd_naaa.programme_exercice pe JOIN bdd_naaa.exercice e WHERE pe.programme_id=:programmeId", nativeQuery = true)
	List<Long> findExercicesIdsByProgramme(@Param("programmeId") Long programmeId);

}
