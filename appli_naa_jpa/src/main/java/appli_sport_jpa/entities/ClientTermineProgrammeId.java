package appli_sport_jpa.entities;

import java.util.Objects;

public class ClientTermineProgrammeId {
	private Programme programme;
	private Client client;
	public ClientTermineProgrammeId() {
	}
	public ClientTermineProgrammeId(Programme programme, Client client) {
		this.programme = programme;
		this.client = client;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
