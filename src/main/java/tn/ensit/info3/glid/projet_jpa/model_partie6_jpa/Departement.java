package tn.ensit.info3.glid.projet_jpa.model_partie6_jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
	private Set<Commune> communes = new HashSet<>();
	public Departement() {
	}
	public Departement(String nom) {
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
	public void addCommune(Commune commune) {
		this.communes.add(commune);
	}
	public Set<Commune> getCommunes(){
		return communes;
	}
	
	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]" +"\n"+
	"Communes : " + this.communes;
	}
	
}
