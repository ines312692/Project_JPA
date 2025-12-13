package tn.ensit.info3.glid.projet_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppPartie2 {

	public static void main(String[] args) {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple2");
				EntityManager em = emf.createEntityManager()) {
			// Traitement des données
		}
	}

}
