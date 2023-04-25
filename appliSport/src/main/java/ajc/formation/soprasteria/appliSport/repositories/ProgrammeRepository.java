package ajc.formation.soprasteria.appliSport.repositories;

import ajc.formation.soprasteria.appliSport.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.appliSport.entities.Exercice;
import ajc.formation.soprasteria.appliSport.entities.Programme;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
//    @Transactional
//    @Modifying
//    @Query("update Programme c set c.clientDansProgramme=null where c.clientDansProgramme=:client")
//    void removeClientFromProgrammeByClient(@Param("client") Client client);
//
//    List<Programme> findByClient(Client client);
//
//    @Transactional
//    @Query("select c from Programme c left join fetch c.programme_exercice where c.id=:id")
//    Optional<Programme> findByIdFetchProgrammeExercice(@Param("id") Long id);

}
