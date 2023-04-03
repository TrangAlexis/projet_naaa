package appli_sport_jpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="exercice")
public class Exercice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exercice_id")
	private Long id;
	@Column(name= "exercice_name")
	private String nom;
	@Column(name= "description", columnDefinition = "TEXT")
	@Lob // Big stockage de donnée (ici text) dans uen colonne de bdd
	private String description;
	
	public Exercice() {
		
	}

	public Exercice(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
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
