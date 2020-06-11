package gokart.classes;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pilotoCampeonato")
public class PilotoCampeonato implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Piloto piloto;
	
	@ManyToOne
	private Campeonato campeonato;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piloto getPil() {
		return piloto;
	}

	public void setPil(Piloto pil) {
		this.piloto = pil;
	}

	public Campeonato getCamp() {
		return campeonato;
	}

	public void setCamp(Campeonato camp) {
		this.campeonato = camp;
	}

	public PilotoCampeonato() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result + id;
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
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
		PilotoCampeonato other = (PilotoCampeonato) obj;
		if (campeonato == null) {
			if (other.campeonato != null)
				return false;
		} else if (!campeonato.equals(other.campeonato))
			return false;
		if (id != other.id)
			return false;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.piloto.getNome();
	}



	
}
