package tn.ensit.info3.glid.projet_jpa;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Adresse;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Commune;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Departement;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Maire;

public class AppPartie3 {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple3");
				EntityManager em = emf.createEntityManager()) {
			//demoComposition(em);	
			//demoCollections(em);

		}
	}

	private static void demoCollections(EntityManager em) {
		em.getTransaction().begin();
		Departement tunis = new Departement("Tunis");
		tunis.addCommune(new Commune("Bardo"));
		tunis.addCommune(new Commune("Bardo"));
		tunis.addCommune(new Commune("La Goulette"));
		tunis.addCommune(new Commune("La Goulette"));
		tunis.addCommune(new Commune("El Kram"));
		tunis.addCommune(new Commune("El Kram"));
		em.persist(tunis);
		em.getTransaction().commit();
		
		Departement d = em.find(Departement.class, 1);
		System.out.println(d);
		
	}

	private static void demoComposition(EntityManager em) {
		em.getTransaction().begin();
		Commune c = new Commune();
		c.setNom("Gotham City");
		em.persist(c);
		em.getTransaction().commit();
		System.out.println("Creation de la commune : " + c);
		em.getTransaction().begin();
		Maire m = new Maire();
		m.setNom("Batman");
		m.setAdresse(new Adresse("Underground", c));
		em.persist(m);
		em.getTransaction().commit();
		System.out.println("Creation du maire : " + m);
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Donnez l'id du maire à supprimer");
			int id = sc.nextInt();
			em.getTransaction().begin();
			m = em.find(Maire.class, id);
			em.remove(m);
			em.getTransaction().commit();
			System.out.println("Maire supprimé !");
		}

		
	}

}
