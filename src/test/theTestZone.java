package test;


import java.util.ArrayList;
import java.util.List;

import main.dao.ClientDao;
import main.dao.Context;
import main.dao.ExercicesDao;
import main.dao.ProgrammesDao;
import main.dao.SuccesDao;
import main.model.Client;
import main.model.Exercices;
import main.model.Programmes;
import main.model.Succes;

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
		
		Client client1= new Client(null,"F","BoB","Billy","CompteBob","mdpBob",0,"billy.bob@gmail.com",null);
		clientDao.insert(client1);
		System.out.println(clientDao.findByCompte("CompteBob"));
		Client client2= new Client(null,"F","Baba","Yaga","CompteBaba","mdpBaba",0,"billy.bob@gmail.com",null);
		clientDao.insert(client2);
		System.out.println(clientDao.findAll());
		
		client1=clientDao.findByCompte("CompteBob");
		client1.setNom("BILLY");
		clientDao.update(client1);

		clientDao.deleteByCompte("CompteBob");
		clientDao.deleteByCompte("CompteBaba");
		
		
		
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
		
		
		System.out.println("-------------SUCCES-----------");
		SuccesDao succesDao = Context.getSuccesDao();
		
		Succes succes1 = new Succes(1, "Créer in compte", "Créer un compte", 10);
		succesDao.insert(succes1);
		System.out.println(succesDao.findByKey(1));
		Succes succes2 = new Succes(2, "Faire une pompe", "Faire une pompe", 25);
		succesDao.insert(succes2);
		System.out.println(succesDao.findAll());
		
		succes2.setDescription("FAIRE UNE POMPE");
		succesDao.update(succes2);
		
		succesDao.delete(succes1);
		succesDao.delete(succes2);
		
		
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
