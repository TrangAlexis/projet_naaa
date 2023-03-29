package appli_sport_jpa.entities;

import java.util.Objects;

public class ProgrammeExercice {
	private Long programmeId;
	private Integer repetition;
	private Long exerciceId;
	
	public ProgrammeExercice() {
		
	}

	public ProgrammeExercice(Long programmeId, Integer repetition, Long exerciceId) {
		super();
		this.programmeId = programmeId;
		this.repetition = repetition;
		this.exerciceId = exerciceId;
	}

	public Long getProgrammeId() {
		return programmeId;
	}

	public void setProgrammeId(Long programmeId) {
		this.programmeId = programmeId;
	}

	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

	public Long getExerciceId() {
		return exerciceId;
	}

	public void setExerciceId(Long exerciceId) {
		this.exerciceId = exerciceId;
	}

	@Override
	public String toString() {
		return "ProgrammeExercice [programmeId=" + programmeId + ", repetition=" + repetition + ", exerciceId="
				+ exerciceId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(exerciceId, programmeId, repetition);
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
		return Objects.equals(exerciceId, other.exerciceId) && Objects.equals(programmeId, other.programmeId)
				&& Objects.equals(repetition, other.repetition);
	}
	
	
	
}
