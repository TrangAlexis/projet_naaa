package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;


@Entity
@Table(name="programme_exercice")
public class ProgrammeExercice {
	@EmbeddedId
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})
	private ProgrammeExerciceId id;
	@Column(name="programme_exercice_repetition")
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})

	private Integer repetition;
	
	public ProgrammeExercice() {
		
	}

	public ProgrammeExercice(ProgrammeExerciceId id, Integer repetition) {
		this.id = id;
		this.repetition = repetition;
	}


	public ProgrammeExerciceId getId() {
		return id;
	}

	public void setId(ProgrammeExerciceId id) {
		this.id = id;
	}

	public ProgrammeExercice(Integer repetition) {
		super();
		this.repetition = repetition;
	}



	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProgrammeExercice that = (ProgrammeExercice) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
