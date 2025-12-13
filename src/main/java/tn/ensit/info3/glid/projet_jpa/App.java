package tn.ensit.info3.glid.projet_jpa;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tn.ensit.info3.glid.projet_jpa.model.Civilite;
import tn.ensit.info3.glid.projet_jpa.model.Commune;
import tn.ensit.info3.glid.projet_jpa.model.Maire;

public class App {
	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple1");
				EntityManager em = emf.createEntityManager(); 
			 Scanner sc = new Scanner(System.in)) {
			//ecrire(em, sc);
			// chercher(em);
			// modifier(em, sc);
			//supprimer(em, sc);
			//creerCommune(em);
			//chercherCommune(em);
		}
	}

	private static void chercherCommune(EntityManager em) {
		Commune commune = em.find(Commune.class, 2);
		System.out.println("Maire de commune 2 : "+ commune.getMaire().getNom());
	}

	private static void creerCommune(EntityManager em) {
		em.getTransaction().begin();
		// Créer un maire
		Maire m = new Maire();
		m.setNom("Ben Foulen");
		m.setPrenom("Foulen");
		m.setCivilite(Civilite.M);
		// Créer une commune avec cet maire
		Commune c = new Commune();
		c.setNom("Tunis");
		c.setMaire(m);
		// Persrister la commune
		em.persist(c);
		em.getTransaction().commit();
		
	}

	private static void supprimer(EntityManager em, Scanner sc) {
		em.getTransaction().begin();
		System.out.println("Donnre l'id du maire à supprimer");
		int id = sc.nextInt();
		Maire m = em.find(Maire.class, id);
		em.remove(m);
		em.getTransaction().commit();
	}

	private static void modifier(EntityManager em, Scanner sc) {
		em.getTransaction().begin();
		Maire m = em.find(Maire.class, 1);
		System.out.println("Donnez le nouveau nom : ");
		m.setNom(sc.nextLine());
		em.getTransaction().commit();
		
	}

	private static void chercher(EntityManager em) {
		Maire m = em.find(Maire.class, 1);
		System.out.println("Nom du maire : " +  m.getNom());
		
	}

	private static void ecrire(EntityManager em, Scanner sc) {
		em.getTransaction().begin();
		Maire m1 = new Maire();
		System.out.println("Donnez le nom du maire : ");
		m1.setNom(sc.nextLine());
		System.out.println("Donnez le prénom du maire : ");
		m1.setPrenom(sc.nextLine());
		System.out.println("Donnez la civilité (tapez m pour Monsieur, autre pour Madamme): ");
		String choix = sc.nextLine();
		m1.setCivilite(choix.equalsIgnoreCase("m")? Civilite.M : Civilite.Mme);
		
		em.persist(m1);
		em.getTransaction().commit();
		
	}
	
	
}
