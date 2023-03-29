package appli_sport_jpa.entities;

public class Client extends Personne{

	private boolean premium;
	private Programme programme;
	
	public Client() {
		
	}

	public Client(boolean premium, Programme programme) {
		super();
		this.premium = premium;
		this.programme = programme;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	@Override
	public String toString() {
		return "Client [premium=" + premium + ", programme=" + programme + "]";
	}
	
	
	
}
