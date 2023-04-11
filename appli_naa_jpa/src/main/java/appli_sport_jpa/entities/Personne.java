package appli_sport_jpa.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

import appli_sport_jpa.entities.jsonviews.JsonViews;

@MappedSuperclass

public abstract class Personne {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @JsonView(JsonViews.Simple.class)
	    private Long id;
	    @JsonView(JsonViews.Simple.class)
	    private String nom;
	    //@Column(name = "personne_prenom", nullable = false)
	    @JsonView(JsonViews.Simple.class)
	    private String prenom;
	    //@Column(name = "personne_email")
	    @JsonView(JsonViews.Simple.class)
	    private String email;
	    //@Column(name = "personne_login")
	    @JsonView(JsonViews.Simple.class)
	    private String login;
	    //@Column(name = "personne_mdp")
	    @JsonView(JsonViews.Simple.class)
	    private String mdp;
	    //@Column(name = "personne_pointsDeSucces")
	    @JsonView(JsonViews.Simple.class)
	    private Integer pointsDeSucces;
	    //@Column(name = "personne_dateNaissance")
	    @JsonView(JsonViews.Simple.class)
	    private LocalDate dateNaissance;

	
	public Personne() {
		
	}
	
	
	
	public Personne(String nom, String prenom, String email, String login, String mdp, Integer pointsDeSucces,
			LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.mdp = mdp;
		this.pointsDeSucces = pointsDeSucces;
		this.dateNaissance = dateNaissance;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Integer getPointsDeSucces() {
		return pointsDeSucces;
	}

	public void setPointsDeSucces(Integer pointsDeSucces) {
		this.pointsDeSucces = pointsDeSucces;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login
				+ ", mdp=" + mdp + ", pointsDeSucces=" + pointsDeSucces + ", dateNaissance=" + dateNaissance + "]";
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