package main.model;

import java.util.Objects;

public class Client {
	private Integer idClient;
	private String statut;
	private String nom;
	private String prenom;
	private String Compte;
	private String motDePasse;
	private Integer pointsDeSucces;
	private String e_mail;
	private Integer idSucces;
	
	
	public Client(Integer idClient, String statut, String nom, String prenom, String Compte,
			String motDePasse, Integer pointsDeSucces, String e_mail, Integer idSucces) {
		super();
		this.idClient = idClient;
		this.statut = statut;
		this.nom = nom;
		this.prenom = prenom;
		this.Compte = Compte;
		this.motDePasse = motDePasse;
		this.pointsDeSucces = pointsDeSucces;
		this.e_mail = e_mail;
		this.idSucces = idSucces;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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


	public String getCompte() {
		return Compte;
	}

	public void setCompte(String compte) {
		Compte = compte;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getPointsDeSucces() {
		return pointsDeSucces;
	}

	public void setPointsDeSucces(Integer pointsDeSucces) {
		this.pointsDeSucces = pointsDeSucces;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(idClient, other.idClient);
	}

	public Integer getIdSucces() {
		return idSucces;
	}

	public void setIdSucces(Integer idSucces) {
		this.idSucces = idSucces;
	}
	
	
	
}
