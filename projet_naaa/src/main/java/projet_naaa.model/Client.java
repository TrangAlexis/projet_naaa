package appli_naaa.model;

import java.util.Objects;

public class Client {
	private String idClient;
	private String statut;
	private String nom;
	private String prenom;
	private String alias;
	private String nomCompte;
	private String motDePasse;
	private Integer pointsDeSucces;
	
	public Client(String idClient, String statut, String nom, String prenom, String alias, String nomCompte,
			String motDePasse, Integer pointsDeSucces) {
		super();
		this.idClient = idClient;
		this.statut = statut;
		this.nom = nom;
		this.prenom = prenom;
		this.alias = alias;
		this.nomCompte = nomCompte;
		this.motDePasse = motDePasse;
		this.pointsDeSucces = pointsDeSucces;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNomCompte() {
		return nomCompte;
	}

	public void setNomCompte(String nomCompte) {
		this.nomCompte = nomCompte;
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
	
	
}
