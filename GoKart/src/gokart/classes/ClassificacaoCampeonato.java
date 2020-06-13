package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ClassificacaoCampeonato")
public class ClassificacaoCampeonato implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private long pontuacao;
	
	@ManyToOne
	private PilotoCampeonato pil;
	
	@ManyToOne
	private Campeonato camp;
	
	@ManyToOne
	private BateriaCampeonato bat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public PilotoCampeonato getPil() {
		return pil;
	}

	public void setPil(PilotoCampeonato pil) {
		this.pil = pil;
	}

	public Campeonato getCamp() {
		return camp;
	}

	public void setCamp(Campeonato camp) {
		this.camp = camp;
	}

	public BateriaCampeonato getBat() {
		return bat;
	}

	public void setBat(BateriaCampeonato bat) {
		this.bat = bat;
	}

	public ClassificacaoCampeonato() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bat == null) ? 0 : bat.hashCode());
		result = prime * result + ((camp == null) ? 0 : camp.hashCode());
		result = prime * result + id;
		result = prime * result + ((pil == null) ? 0 : pil.hashCode());
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
		ClassificacaoCampeonato other = (ClassificacaoCampeonato) obj;
		if (bat == null) {
			if (other.bat != null)
				return false;
		} else if (!bat.equals(other.bat))
			return false;
		if (camp == null) {
			if (other.camp != null)
				return false;
		} else if (!camp.equals(other.camp))
			return false;
		if (id != other.id)
			return false;
		if (pil == null) {
			if (other.pil != null)
				return false;
		} else if (!pil.equals(other.pil))
			return false;
		if (pontuacao != other.pontuacao)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassificacaoCampeonato [id=" + id + ", pontuacao=" + pontuacao + ", pil=" + pil + ", camp=" + camp
				+ ", bat=" + bat + "]";
	}
	
}
