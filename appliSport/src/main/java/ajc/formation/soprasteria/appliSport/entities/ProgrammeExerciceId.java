package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ProgrammeExerciceId implements Serializable{

	@ManyToOne
	@JoinColumn(name="programme_exercice_id_programme", foreignKey = @ForeignKey(name="programme_exercice_id_programme_fk"))
	private Programme programme;
	@ManyToOne
	@JsonView({JsonViews.Programme.class})
	@JoinColumn(name="programme_exercice_id_exercice", foreignKey = @ForeignKey(name="programme_exercice_id_exercice_fk"))
	private Exercice exercice;
	@JsonView({JsonViews.Programme.class})
	private Integer position;

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public ProgrammeExerciceId() {
	}

	public ProgrammeExerciceId(Programme programme, Exercice exercice, Integer position) {
		this.programme = programme;
		this.exercice = exercice;
		this.position = position;
	}

	public ProgrammeExerciceId(Programme programme, Exercice exercice) {
		this.programme = programme;
		this.exercice = exercice;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Exercice getExercice() {
		return exercice;
	}
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(exercice, programme);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgrammeExerciceId other = (ProgrammeExerciceId) obj;
		return Objects.equals(exercice, other.exercice) && Objects.equals(programme, other.programme);
	}
	
}
