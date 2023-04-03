package appli_sport_jpa.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

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
	private boolean premium;
	@ManyToOne()
	@Column(name = "client_programme")
	private Programme programme;
	
	public Client() {
		
	}

	

	public Client(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance, boolean premium, Programme programme) {
		super(nom, prenom, email, login, mdp, pointsDeSucces, dateNaissance);
		this.premium = premium;
		this.programme = programme;
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
