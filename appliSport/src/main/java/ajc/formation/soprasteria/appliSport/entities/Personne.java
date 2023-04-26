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
	@JsonView(JsonViews.Simple.class)
	private String nom;
	// @Column(name = "personne_pointsDeSucces")
	@JsonView(JsonViews.Simple.class)
	private Integer pointsDeSucces;
	@JsonView(JsonViews.Simple.class)
	private String avatar;


	public Personne() {

	}

	public Personne(String nom, Integer pointsDeSucces) {
		this.nom = nom;
		this.pointsDeSucces = pointsDeSucces;
	}
	
	


	public Personne(String nom, Integer pointsDeSucces, String avatar) {
		this.nom = nom;
		this.pointsDeSucces = pointsDeSucces;
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Personne personne = (Personne) o;
		return Objects.equals(nom, personne.nom);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
}
