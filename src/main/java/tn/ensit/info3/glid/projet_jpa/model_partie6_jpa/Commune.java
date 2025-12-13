package tn.ensit.info3.glid.projet_jpa.model_partie6_jpa;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@NamedQueries({
		@NamedQuery(
				name = "Commune.byName",
				query = "SELECT c FROM Commune c WHERE LOWER(c.nom) = LOWER(:nom)")
		
})

@Entity
public class Commune implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private int population;
	@ManyToOne
	private Departement departement;
	public Commune() {
	}
	public Commune(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Commune [id=" + id + ", nom=" + nom + ", population= " + population + ", departement : "+ departement.getNom()+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commune other = (Commune) obj;
		return Objects.equals(nom, other.nom);
	}
	
}
