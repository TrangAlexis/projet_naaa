package ajc.formation.soprasteria.appliSport.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@MappedSuperclass

public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Simple.class)
	private Long id;
	@JsonView(JsonViews.Simple.class)
	private String nom;
	// @Column(name = "personne_pointsDeSucces")
	@JsonView(JsonViews.Simple.class)
	private Integer pointsDeSucces;


	public Personne() {

	}

	public Personne(String nom, Integer pointsDeSucces) {
		this.nom = nom;
		this.pointsDeSucces = pointsDeSucces;
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

	public Integer getPointsDeSucces() {
		return pointsDeSucces;
	}

	public void setPointsDeSucces(Integer pointsDeSucces) {
		this.pointsDeSucces = pointsDeSucces;
	}

	@Override
	public String toString() {
		return "Personne{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", pointsDeSucces=" + pointsDeSucces +
				'}';
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}
