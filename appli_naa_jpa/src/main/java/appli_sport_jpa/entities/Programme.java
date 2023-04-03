package appli_sport_jpa.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="programme")
public class Programme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programme_id")
	private Long id;
	@Column(name="programme_name")
	private String nom;
	@Column(name="programme_duree")
	private Integer nombreJours;
	@OneToMany(mappedBy = "programme")
	private Set<ProgrammeExercice> exercices;
	@Transient
	private List<Client> clientDansProgramme;
	@Transient
	private List<Client> clientTermineProgramme;
	@Transient
	private Personne coachCreateur;
	
	public Programme() {
		
	}

	public Programme(String nom, Integer nombreJours, Set<ProgrammeExercice> exercices, List<Client> clientDansProgramme,
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

	public Set<ProgrammeExercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<ProgrammeExercice> exercices) {
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