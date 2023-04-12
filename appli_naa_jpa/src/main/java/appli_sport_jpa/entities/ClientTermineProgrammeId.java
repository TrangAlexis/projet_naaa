package appli_sport_jpa.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@IdClass(ClientTermineProgrammeId.class)
public class ClientTermineProgrammeId implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="client_termine_programme_id_client", foreignKey = @ForeignKey(name="client_termine_programme_id_client_fk"))
	private Client client;
	@ManyToOne
	@JoinColumn(name="client_termine_programme_id_programme", foreignKey = @ForeignKey(name="client_termine_programme_id_programme_fk"))
	private Programme programme;
	
	
	public ClientTermineProgrammeId() {
	}


	public ClientTermineProgrammeId(Client client, Programme programme) {
		super();
		this.client = client;
		this.programme = programme;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Programme getProgramme() {
		return programme;
	}


	public void setProgramme(Programme programme) {
		this.programme = programme;
	}


	@Override
	public int hashCode() {
		return Objects.hash(client, programme);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientTermineProgrammeId other = (ClientTermineProgrammeId) obj;
		return Objects.equals(client, other.client) && Objects.equals(programme, other.programme);
	}




	
}
