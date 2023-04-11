package appli_sport_jpa.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client_termine_programme")
@IdClass(ClientTermineProgrammeId.class)
public class ClientTermineProgramme {
	@Id
	@ManyToOne
	@JoinColumn(name="client_termine_programme_id_client", foreignKey = @ForeignKey(name="client_termine_programme_id_client_fk"))
	private Client client;
	@Id
	@ManyToOne
	@JoinColumn(name="client_termine_programme_id_programme", foreignKey = @ForeignKey(name="client_termine_programme_id_programme_fk"))
	private Programme programme;
	
	
	public ClientTermineProgramme() {
	}


	public ClientTermineProgramme(Client client, Programme programme) {
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
		ClientTermineProgramme other = (ClientTermineProgramme) obj;
		return Objects.equals(client, other.client) && Objects.equals(programme, other.programme);
	}
	
	
	
}
