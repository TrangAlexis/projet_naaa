package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity

@Table(name = "coach")
@AttributeOverrides({
	@AttributeOverride(name = "nom", column = @Column(name = "coach_nom", nullable = false)),
	@AttributeOverride(name = "pointsDeSucces", column = @Column(name = "coach_pointsDeSucces"))
})
public class Coach extends Personne {

    @Transient
	private Set<Programme> programme;
    @Transient
	private Set<Exercice> exercices;
	@OneToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "coach_compte_id_fk"))
	@JsonView(JsonViews.Simple.class)
	private Compte compte;
	
	public Coach() {
		
	}

	public Coach(String nom, Integer pointsDeSucces, Set<Programme> programme, Set<Exercice> exercices, Compte compte) {
		super(nom, pointsDeSucces);
		this.programme = programme;
		this.exercices = exercices;
		this.compte = compte;
	}

	public Coach(String nom, Integer pointsDeSucces, Set<Programme> programme, Set<Exercice> exercices) {
		super(nom, pointsDeSucces);
		this.programme = programme;
		this.exercices = exercices;
	}

	public Coach(String nom, Integer pointsDeSucces) {
		super(nom, pointsDeSucces);
	}

	public Set<Programme> getProgramme() {
		return programme;
	}

	public void setProgramme(Set<Programme> programme) {
		this.programme = programme;
	}

	public Set<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<Exercice> exercices) {
		this.exercices = exercices;
	}

	
	
	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	@Override
	public String toString() {
		return "Coach [programme=" + programme + ", exercices=" + exercices + "]";
	}





}