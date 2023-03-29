package appli_sport_jpa.entities;

import java.util.Objects;

public class Succes {
	private Long id;
	private Integer nombrePoints;
	private String titre;
	
	public Succes() {
		
	}

	public Succes(Integer nombrePoints, String titre) {
		super();
		this.nombrePoints = nombrePoints;
		this.titre = titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNombrePoints() {
		return nombrePoints;
	}

	public void setNombrePoints(Integer nombrePoints) {
		this.nombrePoints = nombrePoints;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Succes [id=" + id + ", nombrePoints=" + nombrePoints + ", titre=" + titre + "]";
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
		Succes other = (Succes) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
