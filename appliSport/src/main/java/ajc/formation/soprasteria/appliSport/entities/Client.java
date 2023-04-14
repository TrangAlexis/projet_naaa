package ajc.formation.soprasteria.appliSport.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.appliSport.entities.jsonviews.JsonViews;

@Entity
@Table(name = "client")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "client_id")),
	@AttributeOverride(name = "nom", column = @Column(name = "client_nom", nullable = false)),
	@AttributeOverride(name = "prenom", column = @Column(name = "client_prenom", nullable = false)),
	@AttributeOverride(name = "email", column = @Column(name = "client_email")),
	@AttributeOverride(name = "login", column = @Column(name = "client_login", nullable = false)),
	@AttributeOverride(name = "mdp", column = @Column(name = "client_mdp", nullable = false)),
	@AttributeOverride(name = "pointsDeSucces", column = @Column(name = "client_pointsDeSucces")),
	@AttributeOverride(name = "dateNaissance", column = @Column(name = "client_dateNaissance"))
})

public class Client extends Personne{
	
	@Column(name = "client_premium")
	//@JsonView(JsonViews.Client.class)
	private Boolean premium;
	@ManyToOne
	@JoinColumn(name = "client_prog", foreignKey = @ForeignKey(name = "client_programme_fk"))
//	@Transient
	private Programme programme;
	@OneToOne
	@JoinColumn(name = "compte_id", foreignKey = @ForeignKey(name = "client_compte_id_fk"))
	@JsonView(JsonViews.Simple.class)
	private Compte compte;

	
	public Client() {
		
	}

	

	public Client(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance, boolean premium, Programme programme) {
		super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
		this.premium = premium;
		this.programme = programme;
	}
	

	public Client(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance, boolean premium, Programme programme, Compte compte) {
		super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
		this.premium = premium;
		this.programme = programme;
		this.compte = compte;
	}



	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	@Override
	public String toString() {
		return "Client [premium=" + premium + ", programme=" + programme + "]";
	}

	
	
}
