package ajc.formation.soprasteria.appliSport.repositories;

import ajc.formation.soprasteria.appliSport.entities.AmiAmis;
import ajc.formation.soprasteria.appliSport.entities.AmiAmisId;
import ajc.formation.soprasteria.appliSport.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AmiAmisRepository extends JpaRepository<AmiAmis, AmiAmisId> {


    @Query("select distinct c from Client c where c.nom in (select a.premierAmi.nom from AmiAmis a where a.deuxiemeAmi.nom = :nom) or c.nom in (select a.deuxiemeAmi.nom from AmiAmis a where a.premierAmi.nom = :nom)")
   List<Client> findAmisByClientNom(@Param("nom") String nom);




}
