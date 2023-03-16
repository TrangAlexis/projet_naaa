package appli_naaa.model;

import java.util.Objects;

public class Succes {
	private Integer idSucces;
	private String nomSucces;
	private String description;
	private Integer pointGagnes;
	
	public Succes(Integer idSucces, String nomSucces, String description, Integer pointGagnes) {
		super();
		this.idSucces = idSucces;
		this.nomSucces = nomSucces;
		this.description = description;
		this.pointGagnes = pointGagnes;
	}

	public Integer getIdSucces() {
		return idSucces;
	}

	public void setIdSucces(Integer idSucces) {
		this.idSucces = idSucces;
	}

	public String getNomSucces() {
		return nomSucces;
	}

	public void setNomSucces(String nomSucces) {
		this.nomSucces = nomSucces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPointGagnes() {
		return pointGagnes;
	}

	public void setPointGagnes(Integer pointGagnes) {
		this.pointGagnes = pointGagnes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSucces);
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
		return Objects.equals(idSucces, other.idSucces);
	}
	
	
	
	
}
