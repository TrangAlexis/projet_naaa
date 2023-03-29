package appli_sport_jpa.entities;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Personne {
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String mdp;
	private Integer pointsDeSucces;
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
