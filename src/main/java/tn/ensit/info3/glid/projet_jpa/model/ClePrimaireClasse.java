package tn.ensit.info3.glid.projet_jpa.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ClePrimaireClasse {
	private String niveau; // par exemple : 3 GInfo
	private int annee; // par exemple : 2025
	public ClePrimaireClasse() {
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
}
