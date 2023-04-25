package ajc.formation.soprasteria.appliSport.services;

import ajc.formation.soprasteria.appliSport.entities.ProgrammeExercice;
import ajc.formation.soprasteria.appliSport.repositories.ProgrammeExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeExerciceServices {

    @Autowired
    private ProgrammeExerciceRepository programmeExerciceRepository;

    public List<ProgrammeExercice> findAll() {
        return programmeExerciceRepository.findAll();
    }
    

}
