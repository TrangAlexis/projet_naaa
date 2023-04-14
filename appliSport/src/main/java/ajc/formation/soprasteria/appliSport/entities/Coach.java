package ajc.formation.soprasteria.appliSport.entities;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDate;
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
	@AttributeOverride(name = "id", column = @Column(name = "coach_id")),
	@AttributeOverride(name = "nom", column = @Column(name = "coach_nom", nullable = false)),
	@AttributeOverride(name = "prenom", column = @Column(name = "coach_prenom", nullable = false)),
	@AttributeOverride(name = "email", column = @Column(name = "coach_email")),
	@AttributeOverride(name = "login", column = @Column(name = "coach_login", nullable = false)),
	@AttributeOverride(name = "mdp", column = @Column(name = "coach_mdp", nullable = false)),
	@AttributeOverride(name = "pointsDeSucces", column = @Column(name = "coach_pointsDeSucces")),
	@AttributeOverride(name = "dateNaissance", column = @Column(name = "coach_dateNaissance"))
})
public class Coach extends Personne{
	
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
	

	public Coach(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance) {
		super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
	}

	


	public Coach(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance, Set<Programme> programme, Set<Exercice> exercices, Compte compte) {
		super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
		this.programme = programme;
		this.exercices = exercices;
		this.compte = compte;
	}


	public Coach(Set<Programme> programme, Set<Exercice> exercices) {
		super();
		this.programme = programme;
		this.exercices = exercices;
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