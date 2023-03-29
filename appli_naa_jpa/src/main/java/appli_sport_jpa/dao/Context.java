package appli_sport_jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Context {

	private static Context singleton;
	private EntityManagerFactory emf;

	private Context() {
		emf = Persistence.createEntityManagerFactory("bdd_naaa");
	}

	public static Context getInstance() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void destroy() {
		if (singleton != null) {
			singleton.getEntityManagerFactory().close();
			singleton = null;
		}
	}
}
