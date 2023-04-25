package ajc.formation.soprasteria.appliSport.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;


@Entity
@Table(name="programme_simplifie")
public class ProgrammeSimplifie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programme_id")
	@JsonView(JsonViews.Programme.class)
	private Long id;
	@Column(name="programme_name")
	@JsonView(JsonViews.Programme.class)
	private String nom;
	@Column(name="programme_duree")
	@JsonView(JsonViews.Programme.class)
	private Integer nombreJours;
	@Column(name="programme_points")
	@JsonView(JsonViews.Programme.class)
	private Long points;
	@Column(name="url_image")
	@JsonView(JsonViews.Programme.class)
	private String urlImage;
	@Column(name="exos")
	@OneToMany(mappedBy="programmeSimplifies")
	@JsonView(JsonViews.Programme.class)
	private Set<Exercice> exercices;
	
	@Transient
	@OneToMany(mappedBy = "programme")
	private Set<Client> clientDansProgramme;
	@Transient
	private List<Client> clientTermineProgramme;
	@Transient
	private Coach coachCreateur;
	
	public ProgrammeSimplifie() {
		
	}

	public ProgrammeSimplifie(String nom, Integer nombreJours, Set<Exercice> exercices, Set<Client> clientDansProgramme,
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

	public Set<Client> getClientDansProgramme() {
		return clientDansProgramme;
	}

	public void setClientDansProgramme(Set<Client> clientDansProgramme) {
		this.clientDansProgramme = clientDansProgramme;
	}

	public List<Client> getClientTermineProgramme() {
		return clientTermineProgramme;
	}

	public void setClientTermineProgramme(List<Client> clientTermineProgramme) {
		this.clientTermineProgramme = clientTermineProgramme;
	}
	
	
	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}



	public Coach getCoachCreateur() {
		return coachCreateur;
	}

	public void setCoachCreateur(Coach coachCreateur) {
		this.coachCreateur = coachCreateur;
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
		ProgrammeSimplifie other = (ProgrammeSimplifie) obj;
		return Objects.equals(id, other.id);
	}


	
}
