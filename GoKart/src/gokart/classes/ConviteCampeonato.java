package gokart.classes;

import javax.persistence.*;


@Entity
@Table(name = "ConviteCampeonato")

public class ConviteCampeonato implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	private boolean aceito;
	
	@ManyToOne
	private Campeonato id_campeonato;
	
	@ManyToOne
	private Piloto id_piloto;
	

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

	public Piloto getId_piloto() {
		return id_piloto;
	}

	public void setId_piloto(Piloto id_piloto) {
		this.id_piloto = id_piloto;
	}
	
	

	public boolean isAceito() {
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (aceito ? 1231 : 1237);		
		result = prime * result + id;
		result = prime * result + ((id_campeonato == null) ? 0 : id_campeonato.hashCode());
		result = prime * result + ((id_piloto == null) ? 0 : id_piloto.hashCode());
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
		ConviteCampeonato other = (ConviteCampeonato) obj;
		if (aceito != other.aceito)
			return false;		
		if (id != other.id)
			return false;
		if (id_campeonato == null) {
			if (other.id_campeonato != null)
				return false;
		} else if (!id_campeonato.equals(other.id_campeonato))
			return false;
		if (id_piloto == null) {
			if (other.id_piloto != null)
				return false;
		} else if (!id_piloto.equals(other.id_piloto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getId_campeonato().getNomeCampeonato();
	}
	

}
