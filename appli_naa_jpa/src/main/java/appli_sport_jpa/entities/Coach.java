package appli_sport_jpa.entities;

import java.util.Set;

public class Coach extends Personne{
	
	private Set<Programme> programme;
	private Set<Exercice> exercices;
	
	public Coach() {
		
	}

	public Coach(Set<Programme> programme, Set<Exercice> exercices) {
		super();
		this.programme = programme;
		this.exercices = exercices;
	}

	public Set<Programme> getProgramme() {
		return programme;
	}

	public void setProgramme(Set<Programme> programme) {
		this.programme = programme;
	}

	public Set<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<Exercice> exercices) {
		this.exercices = exercices;
	}

	@Override
	public String toString() {
		return "Coach [programme=" + programme + ", exercices=" + exercices + "]";
	}
	
	
	
}
