package tn.ensit.info3.glid.projet_jpa.model_partie3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maire implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@Embedded
	private Adresse adresse;
	@ElementCollection
	private Set<String> emails = new HashSet<>();
	public Maire() {
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public void addEmail(String email) {
		this.emails.add(email);
	}
	public Set<String> getEmails(){
		return this.emails;
	}
	@Override
	public String toString() {
		return "Maire [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "emails :"+ emails +"]";
	}
	
}
