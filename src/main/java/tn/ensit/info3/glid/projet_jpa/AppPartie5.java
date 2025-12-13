package tn.ensit.info3.glid.projet_jpa;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Adresse;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Commune;
import tn.ensit.info3.glid.projet_jpa.model_partie3.Maire;

public class AppPartie5 {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple3");
				EntityManager em = emf.createEntityManager()) {
			//creerMaires(em);
			//afficherNombreMaires(em);
			afficherNomAdressMaire(em);
			//afficherNomsAdressesMaires(em);

		}
	}

	private static void afficherNomAdressMaire(EntityManager em) {
		Query query = em.createNativeQuery("SELECT nom, adresse FROM maire WHERE id=?");
		query.setParameter(1, 2);
		Object[] resultat = (Object[]) query.getSingleResult();
		System.out.println("Nom maire : "+ resultat[0] +" - Adresse : " + resultat[1]);
	}

	private static void afficherNomsAdressesMaires(EntityManager em) {
		Query query = em.createNativeQuery("SELECT nom, adresse FROM maire");
		List<Object[]> resultats = query.getResultList();
		System.out.printf("| %10s | %10s |\n", "NOM", "Adresse");
		System.out.printf("|%s|%s|\n", "_".repeat(12), "_".repeat(12));
		for(Object[] ligne : resultats) {
			System.out.printf("| %10s | %10s |\n", ligne[0], ligne[1]);
		}
		
	}

	private static void afficherNombreMaires(EntityManager em) {
		String requete = "SELECT count(*) FROM maire";
		Query query = em.createNativeQuery(requete);
		Long nombreMaires = (Long) query.getSingleResult();
		System.out.println("Nombre de maires : " + nombreMaires);

	}

	private static void creerMaires(EntityManager em) {
		try (Scanner sc = new Scanner(System.in)) {
			em.getTransaction().begin();
			System.out.println("Donnez le nom du maire à ajouter (Chaîne vide pour quitter): ");
			String nom = sc.nextLine();
			if(nom.isBlank()) {
				em.getTransaction().rollback();
				System.out.println(">> Fin ajout maires");
				return;
			}
			System.out.println("Donnez l'adresse du maire :");
			String adresse = sc.nextLine();
			Maire m = new Maire();
			m.setNom(nom);
			m.setAdresse(new Adresse(adresse, em.find(Commune.class, 2)));
			em.persist(m);
			em.getTransaction().commit();
			creerMaires(em);
		}
	}

}
