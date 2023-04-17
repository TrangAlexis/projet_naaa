package appli_sport_jpa.entities;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="client_termine_programme")
@IdClass(ClientTermineProgrammeId.class)

public class ClientTermineProgramme {
	

	public ClientTermineProgramme() {
	}




	
}
