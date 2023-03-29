package appli_sport_jpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="programme_exercice")
@IdClass(ProgrammeExerciceId.class)
public class ProgrammeExercice {
	@Id
	@ManyToOne
	@JoinColumn(name="programme_exercice_id_programme", foreignKey = @ForeignKey(name="programme_exercice_id_programme_fk"))
	private Programme programme;
	@Column(name="programme_exercice_repetition")
	private Integer repetition;
	@Id
	@ManyToOne
	@JoinColumn(name="programme_exercice_id_exercice", foreignKey = @ForeignKey(name="programme_exercice_id_exercice_fk"))
	private Exercice exercice;
	
	public ProgrammeExercice() {
		
	}

	public ProgrammeExercice(Programme programme, Integer repetition, Exercice exercice) {
		super();
		this.programme = programme;
		this.repetition = repetition;
		this.exercice = exercice;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "ProgrammeExercice [programme=" + programme + ", repetition=" + repetition + ", exercice="
				+ exercice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(exercice, programme, repetition);
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
		return Objects.equals(exercice, other.exercice) && Objects.equals(programme, other.programme)
				&& Objects.equals(repetition, other.repetition);
	}
	
	
	
}
