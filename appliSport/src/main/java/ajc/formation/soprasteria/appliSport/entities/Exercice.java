package ajc.formation.soprasteria.appliSport.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@Entity
@Table(name="exercice")
public class Exercice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exercice_id")
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})
	private Long id;
	@Column(name= "exercice_name")
	@NotBlank
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})
	private String nom;
	@Column(name= "description", columnDefinition = "TEXT")
	@Lob // Big stockage de donnée (ici text) dans uen colonne de bdd
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})
	private String description;
	@Column(name="points")
	@JsonView({JsonViews.Simple.class,JsonViews.Programme.class})
	private Long points=0L;
	
//	
//	@Transient
//	@ManyToMany
//	private Set<Programme> programmes;
	
	
	public Exercice() {
		
	}

	public Exercice(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	
	public Exercice(@NotBlank String nom, String description, Long points) {
		super();
		this.nom = nom;
		this.description = description;
		this.points = points;
	}

	
	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Exercice [id=" + id + ", nom=" + nom + ", description=" + description + "]";
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
		Exercice other = (Exercice) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
