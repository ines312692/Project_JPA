package tn.ensit.info3.glid.projet_jpa;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import tn.ensit.info3.glid.projet_jpa.model_partie6_jpa.Commune;
import tn.ensit.info3.glid.projet_jpa.model_partie6_jpa.Maire;

public class AppPartie6 {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple6");
				EntityManager em = emf.createEntityManager();
				Scanner sc = new Scanner(System.in)) {
			// afficherMaires(em);
			// afficherDepartementPopulation(em);
			// afficherDepartementCommunes(em);
			// afficherStatistiquesCommunes(em);
			// afficherDepartementParNom(em, sc);
			supprimerMaires(em);

			System.out.println("Tapez sur la touche entrée pour quitter ...");
			sc.nextLine();

		}
	}

	private static void supprimerMaires(EntityManager em) {
		em.getTransaction().begin();
		int count = em.createQuery("DELETE FROM Maire m WHERE LOWER(m.nom) like '%r%'")
				.executeUpdate();
		em.flush(); // facultatif mais recommandé
		em.clear(); // obligatoire
		em.getTransaction().commit();
		System.out.println(count + " maires supprimés.");
	}

	private static void afficherDepartementParNom(EntityManager em, Scanner sc) {
		System.out.println("Donnez le nom du département à afficher :");
		String nom = sc.nextLine();
		TypedQuery<Commune> query = em.createNamedQuery("Commune.byName", Commune.class);
		query.setParameter("nom", nom);
		Commune c = query.getSingleResult();
		System.out.println(c);
	}

	private static void afficherStatistiquesCommunes(EntityManager em) {
		TypedQuery<Statistiques> query = em.createQuery("SELECT count(c), sum(c.population)FROM Commune c",
				Statistiques.class);
		Statistiques statistiques = query.getSingleResult();
		System.out.println(statistiques);
	}

	private static void afficherDepartementCommunes(EntityManager em) {
		Query query = em.createQuery("SELECT c.nom, c.departement.nom FROM Commune c");
		List<Object[]> resultats = query.getResultList();
		for (Object[] r : resultats) {
			System.out.println("Departement " + r[0] + " -> Commune " + r[1]);
		}

	}

	private static void afficherDepartementPopulation(EntityManager em) {
		Query query = em.createQuery(
				"SELECT departement.nom, sum(commune.population)FROM Departement departement JOIN departement.communes commune GROUP BY departement.nom");
		List<Object[]> resultats = query.getResultList();
		System.out.printf("%s\n", "_".repeat(37));
		System.out.printf("| %-15s | %-15s |\n", "Departement", "Population");
		System.out.printf("%s\n", "_".repeat(37));
		for (Object[] o : resultats) {
			System.out.printf("| %-15s | %-15s |\n", o[0], o[1]);
		}
		System.out.printf("%s\n", "_".repeat(37));

	}

	private static void afficherMaires(EntityManager em) {
		List<Maire> maires = em.createQuery("SELECT m FROM Maire m", Maire.class).getResultList();

		for (Maire m : maires) {
			System.out.printf("Maire %d : \n" + "- Nom : %s \n- Adresse : %s \n- Commune : %s \n- emails : %s \n",
					m.getId(), m.getNom(), m.getAdresse().getAdresse(), m.getAdresse().getCommune().getNom(),
					m.getEmails());
		}

	}

}

record Statistiques(long nombreCommunes, long populationCommunes) {
}