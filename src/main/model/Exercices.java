package main.model;

import java.util.Objects;

public class Exercices {
	private Integer idExercices;
	private String nomExercice;
	private String description;
	private Integer repetition = 0;
	
	public Exercices(Integer idExercices, String nomExercie, String description) {
		super();
		this.idExercices = idExercices;
		this.nomExercice = nomExercie;
		this.description = description;
	}

	
	
	public Exercices(Integer idExercices, String nomExercice, String description, Integer repetition) {
		super();
		this.idExercices = idExercices;
		this.nomExercice = nomExercice;
		this.description = description;
		this.repetition = repetition;
	}


	public Integer getRepetition() {
		return repetition;
	}


	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}



	public Integer getIdExercices() {
		return idExercices;
	}

	public void setIdExercices(Integer idExercices) {
		this.idExercices = idExercices;
	}

	public String getNomExercice() {
		return nomExercice;
	}

	public void setNomExercice(String nomExercie) {
		this.nomExercice = nomExercie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idExercices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercices other = (Exercices) obj;
		return Objects.equals(idExercices, other.idExercices);
	}
	
	
	
}
