package gokart.classes;

import java.sql.Time;

import javax.persistence.*;


@Entity
@Table(name = "ConviteCampeonato")
public class ClassificacaoBateria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;	
	
	private int posicao;
	private Time melhorVolta;
	
	@ManyToOne	
	private Bateria id_bateria;
	
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

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Time getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Time melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	public Bateria getId_bateria() {
		return id_bateria;
	}

	public void setId_bateria(Bateria id_bateria) {
		this.id_bateria = id_bateria;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((id_bateria == null) ? 0 : id_bateria.hashCode());
		result = prime * result + ((id_campeonato == null) ? 0 : id_campeonato.hashCode());
		result = prime * result + ((id_piloto == null) ? 0 : id_piloto.hashCode());
		result = prime * result + ((melhorVolta == null) ? 0 : melhorVolta.hashCode());
		result = prime * result + posicao;
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
		ClassificacaoBateria other = (ClassificacaoBateria) obj;
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
		if (id_piloto == null) {
			if (other.id_piloto != null)
				return false;
		} else if (!id_piloto.equals(other.id_piloto))
			return false;
		if (melhorVolta == null) {
			if (other.melhorVolta != null)
				return false;
		} else if (!melhorVolta.equals(other.melhorVolta))
			return false;
		if (posicao != other.posicao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassificacaoBateria [id=" + id + ", posicao=" + posicao + ", melhorVolta=" + melhorVolta
				+ ", id_bateria=" + id_bateria + ", id_campeonato=" + id_campeonato + ", id_piloto=" + id_piloto + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
