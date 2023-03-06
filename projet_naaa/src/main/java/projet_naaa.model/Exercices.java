package appli_naaa.model;

import java.util.Objects;

public class Exercices {
	private String idExercices;
	private String nomExercie;
	private String description;
	
	public Exercices(String idExercices, String nomExercie, String description) {
		super();
		this.idExercices = idExercices;
		this.nomExercie = nomExercie;
		this.description = description;
	}

	public String getIdExercices() {
		return idExercices;
	}

	public void setIdExercices(String idExercices) {
		this.idExercices = idExercices;
	}

	public String getNomExercie() {
		return nomExercie;
	}

	public void setNomExercie(String nomExercie) {
		this.nomExercie = nomExercie;
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
