package appli_naaa.model;

import java.util.Objects;

public class Programmes {
	private String idProgramme;
	private String nomProgramme;
	private String listeExercices;
	
	public Programmes(String idProgramme, String nomProgramme, String listeExercices) {
		super();
		this.idProgramme = idProgramme;
		this.nomProgramme = nomProgramme;
		this.listeExercices = listeExercices;
	}

	public String getIdProgramme() {
		return idProgramme;
	}

	public void setIdProgramme(String idProgramme) {
		this.idProgramme = idProgramme;
	}

	public String getNomProgramme() {
		return nomProgramme;
	}

	public void setNomProgramme(String nomProgramme) {
		this.nomProgramme = nomProgramme;
	}

	public String getListeExercices() {
		return listeExercices;
	}

	public void setListeExercices(String listeExercices) {
		this.listeExercices = listeExercices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProgramme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmes other = (Programmes) obj;
		return Objects.equals(idProgramme, other.idProgramme);
	}
	
	
	
}
