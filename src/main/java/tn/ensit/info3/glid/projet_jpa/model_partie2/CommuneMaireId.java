package tn.ensit.info3.glid.projet_jpa.model_partie2;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CommuneMaireId {
	private int idCommune;
	private int idMaire;
	private LocalDate dateDebut;
	public CommuneMaireId() {
	}
	public CommuneMaireId(int idCommune, int idMaire, LocalDate dateDebut) {
		this.idCommune = idCommune;
		this.idMaire = idMaire;
		this.dateDebut = dateDebut;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, idCommune, idMaire);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommuneMaireId other = (CommuneMaireId) obj;
		return Objects.equals(dateDebut, other.dateDebut) && idCommune == other.idCommune && idMaire == other.idMaire;
	}
		
}
