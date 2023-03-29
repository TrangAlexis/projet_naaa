package appli_sport_jpa.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Programme {
	private Long id;
	private String nom;
	private Integer nombreJours;
	private Set<Exercice> exercices;
	private List<Client> clientDansProgramme;
	private List<Client> clientTermineProgramme;
	
	public Programme() {
		
	}

	public Programme(String nom, Integer nombreJours, Set<Exercice> exercices, List<Client> clientDansProgramme,
			List<Client> clientTermineProgramme) {
		super();
		this.nom = nom;
		this.nombreJours = nombreJours;
		this.exercices = exercices;
		this.clientDansProgramme = clientDansProgramme;
		this.clientTermineProgramme = clientTermineProgramme;
	}


	public Integer getNombreJours() {
		return nombreJours;
	}


	public void setNombreJours(Integer nombreJours) {
		this.nombreJours = nombreJours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<Exercice> exercices) {
		this.exercices = exercices;
	}

	public List<Client> getClientDansProgramme() {
		return clientDansProgramme;
	}

	public void setClientDansProgramme(List<Client> clientDansProgramme) {
		this.clientDansProgramme = clientDansProgramme;
	}

	public List<Client> getClientTermineProgramme() {
		return clientTermineProgramme;
	}

	public void setClientTermineProgramme(List<Client> clientTermineProgramme) {
		this.clientTermineProgramme = clientTermineProgramme;
	}

	@Override
	public String toString() {
		return "Programme [id=" + id + ", nom=" + nom + ", exercices=" + exercices + ", clientDansProgramme="
				+ clientDansProgramme + ", clientTermineProgramme=" + clientTermineProgramme + "]";
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
		Programme other = (Programme) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
