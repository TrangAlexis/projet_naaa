package appli_naaa.app;


import java.util.ArrayList;
import java.util.List;

import appli_naaa.dao.ClientDao;
import appli_naaa.dao.Context;
import appli_naaa.dao.ExercicesDao;
import appli_naaa.dao.ProgrammesDao;
import appli_naaa.model.Client;
import appli_naaa.model.Exercices;
import appli_naaa.model.Programmes;

public class theTestZone {
	public static void main(String[] args) {
		String s="abcd";
		System.out.println(s.substring(0,2)+" "+s.substring(2,4));
		s="a,b:c,d:";
		String[] a = s.split(":");
		for(String str:a) {
		System.out.println(str+"bouh");
		};
		for(String str:a) {
		System.out.println(str.split(",")[0]);
		};
		
		
		//TESTS DAO
		
		System.out.println("-----------CLIENTS---------");
		ClientDao clientDao = Context.getClientDao();
		
		Client client1= new Client(10,"F","BoB","Billy","CompteBob","mdpBob",50,"billy.bob@gmail.com",10);
		clientDao.insert(client1);
		System.out.println(clientDao.findByKey(10));
		Client client2= new Client(20,"F","Baba","Yaga","CompteBaba","mdpBaba",50,"billy.bob@gmail.com",20);
		clientDao.insert(client2);
		System.out.println(clientDao.findAll());
		
		client1.setCompte("ATCHOUM");
		clientDao.update(client1);

		clientDao.deleteByKey(10);
		clientDao.delete(client2);
		
		
		
		System.out.println("-----------EXERCICES---------");
		ExercicesDao exercicesDao = Context.getExercicesDao();
		
		Exercices exercice1 = new Exercices(11, "pompes", "Mains sur le sol et pompe", 3);
		exercicesDao.insert(exercice1);
		System.out.println(exercicesDao.findByKey(11));
		Exercices exercice2 = new Exercices(12, "abdos", "Dos au sol et crunch");
		exercicesDao.insert(exercice2);
		System.out.println(exercicesDao.findAll());
		
		exercice2.setNomExercice("ABDOS");
		exercicesDao.update(exercice2);
		
		exercicesDao.deleteByKey(11);
		exercicesDao.delete(exercice2);
		
		
		System.out.println("-----------PROGRAMMES---------");
		ProgrammesDao programmesDao = Context.getProgrammesDao();
		
		exercicesDao.insert(exercice1);
		exercicesDao.insert(exercice2);
		List<Exercices> list_exercices_programme1 = new ArrayList<>();
		list_exercices_programme1.add(exercice1);
		list_exercices_programme1.add(exercice2);
		list_exercices_programme1.add(exercice1);
		Programmes programme1 = new Programmes(15, "Programme normale", list_exercices_programme1);
		programmesDao.insert(programme1);
		
		Programmes programme_found = programmesDao.findByKey(15);
		System.out.println(programme_found.getIdProgramme()+" "+programme_found.getNomProgramme()+"\n"
		+programme_found.getListeExercicesString()+"\n");
		for (Exercices ex:programme_found.getListeExercices()) {
			System.out.println(ex.getNomExercice()+" "+ex.getRepetition());
		}

		Programmes programme2 = new Programmes(16,"programme 2",list_exercices_programme1);
		programmesDao.insert(programme2);
		System.out.println(programmesDao.findAll());
		
		programme1.setNomProgramme("Banane");
		programmesDao.update(programme1);
		
		
		programmesDao.delete(programme1);
		programmesDao.delete(programme2);
		exercicesDao.delete(exercice1);
		exercicesDao.delete(exercice2);
	}
	
	

}
