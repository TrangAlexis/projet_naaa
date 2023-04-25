package ajc.formation.soprasteria.appliSport.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@Embeddable
public class ProgrammeExerciceId implements Serializable{
	@OneToOne
	@JoinColumn(name = "programme_id", foreignKey = @ForeignKey(name = "programme_id_fk"), insertable = false, updatable = false)
	private Programme programme;
	@ManyToOne
	@JoinColumn(name = "exercice_id", foreignKey = @ForeignKey(name = "exercice_id_fk"), insertable = false, updatable = false)
	@JsonView(JsonViews.Programme.class)
	private Exercice exercice;
	
	public ProgrammeExerciceId() {
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
