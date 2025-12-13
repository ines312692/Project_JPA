package tn.ensit.info3.glid.projet_jpa.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@OneToMany(mappedBy = "departement", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Commune> communes;
	public Departement() {
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Commune> getCommunes() {
		return communes;
	}
	public void setCommunes(Set<Commune> communes) {
		this.communes = communes;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", communes=" + communes + "]";
	}
	
}
