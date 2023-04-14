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
	@AttributeOverride(name = "pointsDeSucces", column = @Column(name = "client_pointsDeSucces"))
})

public class Client extends Personne{
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

	public Client(String nom, Integer pointsDeSucces, Programme programme, Compte compte) {
		super(nom, pointsDeSucces);
		this.programme = programme;
		this.compte = compte;
	}

	public Client(String nom, Integer pointsDeSucces, Programme programme) {
		super(nom, pointsDeSucces);
		this.programme = programme;
	}

	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}





	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	@Override
	public String toString() {
		return "Client{" +
				"programme=" + programme +
				", compte=" + compte +
				'}';
	}
}
