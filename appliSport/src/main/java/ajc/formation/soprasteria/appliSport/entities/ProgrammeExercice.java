package ajc.formation.soprasteria.appliSport.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;


@Entity
@Table(name="programme_exercice")
public class ProgrammeExercice {
	@EmbeddedId
	@JsonView(JsonViews.Programme.class)
	private ProgrammeExerciceId id;
	@Column(name="programme_exercice_repetition")
	@JsonView(JsonViews.Programme.class)
	private Integer repetition;
	
	public ProgrammeExercice() {
		
	}

	public ProgrammeExercice(ProgrammeExerciceId id, Integer repetition) {
		super();
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgrammeExercice other = (ProgrammeExercice) obj;
		return Objects.equals(id, other.id);
	}



	
	
}
