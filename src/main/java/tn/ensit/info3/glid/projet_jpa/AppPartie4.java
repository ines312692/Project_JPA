package tn.ensit.info3.glid.projet_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tn.ensit.info3.glid.projet_jpa.model_partie4_heritage.Employe;
import tn.ensit.info3.glid.projet_jpa.model_partie4_heritage.Utilisateur;

public class AppPartie4 {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple4");
				EntityManager em = emf.createEntityManager()) {
			
			//creerUtilisateurs(em);
			//recupereUtilisateur(em);

		}
	}

	private static void recupereUtilisateur(EntityManager em) {
		Utilisateur u = em.find(Utilisateur.class, 203);
		System.out.println(u);
		
	}

	private static void creerUtilisateurs(EntityManager em) {
		em.getTransaction().begin();
		em.persist(new Utilisateur("Ramzi"));
		em.persist(new Employe("Farhat", 4000));
		em.getTransaction().commit();
		
	}

}
