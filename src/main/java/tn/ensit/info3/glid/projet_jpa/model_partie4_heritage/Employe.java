package tn.ensit.info3.glid.projet_jpa.model_partie4_heritage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Employe extends Utilisateur{
	// @Column(nullable = false) // Ne marche pas pour le SINGLE_TABLE
	private double salaire;
	public Employe() {
	}
	public Employe(String nom, double salaire) {
		super(nom);
		this.salaire = salaire;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	@Override
	public String toString() {
		return "Employe (salaire=" + salaire + ", nom=" + getNom() + ", id =" + getId() + ")";
	}
	
	
}
