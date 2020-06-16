package gokart.classes;

import javax.persistence.*;

@Entity
@Table(name = "PontuacaoCampeonato")

public class PontuacaoCampeonato implements EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int posicao;
	private long pontuacao;

	@ManyToOne
	private Campeonato id_campeonato;

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

	public long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Campeonato getId_campeonato() {
		return id_campeonato;
	}

	public void setId_campeonato(Campeonato id_campeonato) {
		this.id_campeonato = id_campeonato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((id_campeonato == null) ? 0 : id_campeonato.hashCode());
		result = prime * result + (int) (pontuacao ^ (pontuacao >>> 32));
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
		PontuacaoCampeonato other = (PontuacaoCampeonato) obj;
		if (id != other.id)
			return false;
		if (id_campeonato == null) {
			if (other.id_campeonato != null)
				return false;
		} else if (!id_campeonato.equals(other.id_campeonato))
			return false;
		if (pontuacao != other.pontuacao)
			return false;
		if (posicao != other.posicao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PontuacaoCampeonato [id=" + id + ", posicao=" + posicao + ", pontuacao=" + pontuacao
				+ ", id_campeonato=" + id_campeonato + "]";
	}
}