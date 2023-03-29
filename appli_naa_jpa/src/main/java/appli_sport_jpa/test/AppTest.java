package appli_sport_jpa.test;

import appli_sport_jpa.dao.Context;
import appli_sport_jpa.dao.DaoExercice;
import appli_sport_jpa.dao.DaoProgramme;
import appli_sport_jpa.entities.Exercice;
import appli_sport_jpa.entities.Programme;

public class AppTest {
	public static void main(String[] args) {
		
		DaoExercice daoExercice = Context.getDaoExercice();
		DaoProgramme daoProgramme = Context.getDaoProgramme();
		
		Exercice exo1 = new Exercice("pompe", "c'est nul");
		Exercice exo2 = new Exercice("developpé couché", "jehdh");
		daoExercice.save(exo2);
		daoExercice.save(exo1);
		
		Programme prog1 = new Programme("prog1", 15, null, null, null);
		
		daoProgramme.save(prog1);
	}
}
