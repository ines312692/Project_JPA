package tn.ensit.info3.glid.projet_jpa.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Commune implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Maire maire;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Departement departement;
	public Commune() {
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Maire getMaire() {
		return maire;
	}
	public void setMaire(Maire maire) {
		this.maire = maire;
	}
	public int getId() {
		return id;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Commune [id=" + id + ", nom=" + nom + ", maire=" + maire + ", departement=" + departement + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	
}
