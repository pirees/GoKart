package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Campeonato")
public class Campeonato implements EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeCampeonato;
	private int nrBatCampeonato;
	private int ptMelhorVolta;

	@ManyToOne
	private Piloto pilotoAdm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public int getNrBatCampeonato() {
		return nrBatCampeonato;
	}

	public void setNrBatCampeonato(int nrBatCampeonato) {
		this.nrBatCampeonato = nrBatCampeonato;
	}

	public int getPtMelhorVolta() {
		return ptMelhorVolta;
	}

	public void setPtMelhorVolta(int ptMelhorVolta) {
		this.ptMelhorVolta = ptMelhorVolta;
	}

	public Piloto getPilotoAdm() {
		return pilotoAdm;
	}

	public void setPilotoAdm(Piloto pilotoAdm) {
		this.pilotoAdm = pilotoAdm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nomeCampeonato == null) ? 0 : nomeCampeonato.hashCode());
		result = prime * result + nrBatCampeonato;
		result = prime * result + ((pilotoAdm == null) ? 0 : pilotoAdm.hashCode());
		result = prime * result + ptMelhorVolta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		if (id != other.id)
			return false;
		if (nomeCampeonato == null) {
			if (other.nomeCampeonato != null)
				return false;
		} else if (!nomeCampeonato.equals(other.nomeCampeonato))
			return false;
		if (nrBatCampeonato != other.nrBatCampeonato)
			return false;
		if (pilotoAdm == null) {
			if (other.pilotoAdm != null)
				return false;
		} else if (!pilotoAdm.equals(other.pilotoAdm))
			return false;
		if (ptMelhorVolta != other.ptMelhorVolta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getNomeCampeonato();
	}
	
	

	
	

}
