package tn.ensit.info3.glid.projet_jpa.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
@Entity
public class Classe implements Serializable{
	@EmbeddedId
	private ClePrimaireClasse cpc;
	private int nombreEE; // nombre d'élèves ingénieurs
	
	Classe(){
	}

	public ClePrimaireClasse getCpc() {
		return cpc;
	}

	public void setCpc(ClePrimaireClasse cpc) {
		this.cpc = cpc;
	}

	public int getNombreEE() {
		return nombreEE;
	}

	public void setNombreEE(int nombreEE) {
		this.nombreEE = nombreEE;
	}

}
