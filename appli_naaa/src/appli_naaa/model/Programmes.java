package appli_naaa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import appli_naaa.dao.Context;
import appli_naaa.dao.ExercicesDao;


public class Programmes {
	private Integer idProgramme;
	private String nomProgramme;
	private List<Exercices> listeExercices;
	private String listeExercicesString;
	
	public Programmes(Integer idProgramme, String nomProgramme, List<Exercices> listeExercices) {
		super();
		this.idProgramme = idProgramme;
		this.nomProgramme = nomProgramme;
		this.listeExercices = listeExercices;
	}
	
	public Programmes(Integer idProgramme, String nomProgramme, String listeExercicesString) {
		super();
		this.idProgramme = idProgramme;
		this.nomProgramme = nomProgramme;
		this.listeExercicesString = listeExercicesString;
	}

	public Integer getIdProgramme() {
		return idProgramme;
	}

	public void setIdProgramme(Integer idProgramme) {
		this.idProgramme = idProgramme;
	}

	public String getNomProgramme() {
		return nomProgramme;
	}

	public void setNomProgramme(String nomProgramme) {
		this.nomProgramme = nomProgramme;
	}

	public List<Exercices> getListeExercices() {
		return listeExercices;
	}

	public void setListeExercices(List<Exercices> listeExercices) {
		this.listeExercices = listeExercices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProgramme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmes other = (Programmes) obj;
		return Objects.equals(idProgramme, other.idProgramme);
	}
	
	public List<Exercices> getListeExercicesList(){
		//System.out.println(this.listeExercicesString);
		List<Exercices> listeExercicesList = new ArrayList<>();
		for (String exo_rep:this.listeExercicesString.split(",")) {
			ExercicesDao exercicesDao = Context.getExercicesDao();
			Exercices exo=exercicesDao.findByKey(Integer.parseInt(exo_rep.split(":")[0]));
			exo.setRepetition(Integer.parseInt(exo_rep.split(":")[1]));
			listeExercicesList.add(exo);
		}
		return listeExercicesList;
	}
	
	public String getListeExercicesString() {
		String stringListeExercices = "";
		for (Exercices e:listeExercices) {
			stringListeExercices+=e.getIdExercices()+":"+e.getRepetition()+",";
		}
		return stringListeExercices;
	}
	
}
