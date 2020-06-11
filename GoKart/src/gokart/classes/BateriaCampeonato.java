package gokart.classes;

import javax.persistence.*;


@Entity
@Table(name = "BateriaCampeonato")

public class BateriaCampeonato implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	private int id;
	
	@ManyToOne
	private Campeonato id_campeonato;
	
	@ManyToOne
	private Bateria id_bateria;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Campeonato getId_campeonato() {
		return id_campeonato;
	}

	public void setId_campeonato(Campeonato id_campeonato) {
		this.id_campeonato = id_campeonato;
	}

	public Bateria getId_bateria() {
		return id_bateria;
	}

	public void setId_bateria(Bateria id_bateria) {
		this.id_bateria = id_bateria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((id_bateria == null) ? 0 : id_bateria.hashCode());
		result = prime * result + ((id_campeonato == null) ? 0 : id_campeonato.hashCode());
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
		BateriaCampeonato other = (BateriaCampeonato) obj;
		if (id != other.id)
			return false;
		if (id_bateria == null) {
			if (other.id_bateria != null)
				return false;
		} else if (!id_bateria.equals(other.id_bateria))
			return false;
		if (id_campeonato == null) {
			if (other.id_campeonato != null)
				return false;
		} else if (!id_campeonato.equals(other.id_campeonato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kartódromo: " + this.getId_bateria().getKartodromo().getNome() + " Data:" + this.getId_bateria().getData();
	}	
	
}
