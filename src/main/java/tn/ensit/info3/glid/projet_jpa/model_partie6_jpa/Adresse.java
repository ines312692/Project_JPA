package tn.ensit.info3.glid.projet_jpa.model_partie6_jpa;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Adresse {
	private String adresse;
	@ManyToOne
	private Commune commune;
	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	public Adresse(String adresse, Commune commune) {
		this.adresse = adresse;
		this.commune = commune;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse, commune);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(adresse, other.adresse) && commune.getId()== other.commune.getId();
	}
	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + ", commune=" + commune + "]";
	}
	
}
