package tn.ensit.info3.glid.projet_jpa.model_partie2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class CommuneMaire implements Serializable{
	@EmbeddedId
	private CommuneMaireId communeMaireId;
	@ManyToOne
	@MapsId("idCommune")
	private Commune commune;
	@ManyToOne
	@MapsId("idMaire")
	private Maire maire;
	private LocalDate dateFin;
	public CommuneMaire() {
	}
	public CommuneMaireId getCommuneMaireId() {
		return communeMaireId;
	}
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	public Maire getMaire() {
		return maire;
	}
	public void setMaire(Maire maire) {
		this.maire = maire;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public void setCommuneMaireId(CommuneMaireId communeMaireId) {
		this.communeMaireId = communeMaireId;
	}	
}
