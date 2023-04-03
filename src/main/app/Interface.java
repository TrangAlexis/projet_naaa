package main.app;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import main.dao.ClientDao;
import main.dao.Context;
import main.model.Client;

public class Interface {
	public static void main(String[] args) throws InterruptedException {

		ecran_accueil();

		
	}
	
	private static void ecran_accueil() throws InterruptedException {
		Scanner sc_ecran_accueil = new Scanner(System.in);
		
		refresh_screen();
		System.out.println("*-----------------------------*");
		System.out.println("|          Sport Appli        |");
		System.out.println("*-----------------------------*");
		System.out.println("INSCRIPTION (1)");
		System.out.println("CONNEXION   (2)");

		String choix = sc_ecran_accueil.nextLine();
		switch (choix) {
		case "1":
			ecran_inscription();
			break;
		}
		sc_ecran_accueil.close();
	}
	
	private static void ecran_inscription() throws InterruptedException {
		Scanner sc_ecran_inscription = new Scanner(System.in);
		refresh_screen();
		System.out.println("*-----------------------------*");
		System.out.println("|          Inscription        |");
		System.out.println("*-----------------------------*");
		System.out.println("Accueil             (1)");
		System.out.println("Create your account (2)");

		String choix = sc_ecran_inscription.nextLine();

		switch (choix) {
		case "1":
			ecran_accueil();
			break;
		case "2":
			ecran_creation_compte();
			break;
		}

		sc_ecran_inscription.close();
	}
	
	private static void ecran_creation_compte() throws InterruptedException {
		Scanner sc_ecran_creation_compte = new Scanner(System.in);
		refresh_screen();
		System.out.println("*-----------------------------*");
		System.out.println("|       Création Compte       |");
		System.out.println("*-----------------------------*");
		System.out.println("Nom: ");
		String nom = sc_ecran_creation_compte.nextLine();
		System.out.println("Prénom: ");
		String prenom = sc_ecran_creation_compte.nextLine();
		System.out.println("Nom de Compte: ");
		String compte = sc_ecran_creation_compte.nextLine();
		System.out.println("Mot de passe: ");
		String mdp = sc_ecran_creation_compte.nextLine();
		System.out.println("e_mail: ");
		String e_mail = sc_ecran_creation_compte.nextLine();
		
		ClientDao clientDao = Context.getClientDao();
		Client client = new Client(null,"F",nom,prenom,compte,mdp,0,e_mail,null);
		clientDao.insert(client);
		client = clientDao.findByCompte(compte);
		client.setIdSucces(client.getIdClient());
		clientDao.update(client);
		System.out.println("Compte créé");
		TimeUnit.SECONDS.sleep(1);
		System.out.print("Retour à l'écran d'accueil");
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		TimeUnit.SECONDS.sleep(1);
		System.out.print(".");
		ecran_accueil();
	}
	
	
	private static void refresh_screen() {
		for (int i=0; i<60; i++) {
			System.err.println("");
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
