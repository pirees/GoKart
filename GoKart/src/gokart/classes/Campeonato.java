package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campeonato")
public class Campeonato implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nome;
	private int pontos;
	
	@ManyToOne
	private Piloto pil;
	
	@ManyToOne
	private Kartodromo kart;
	
	@ManyToOne
	private Bateria bat;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Piloto getPil() {
		return pil;
	}

	public void setPil(Piloto pil) {
		this.pil = pil;
	}

	public Kartodromo getKart() {
		return kart;
	}

	public void setKart(Kartodromo kart) {
		this.kart = kart;
	}

	public Bateria getBat() {
		return bat;
	}

	public void setBat(Bateria bat) {
		this.bat = bat;
	}

	public Campeonato(int id, String nome, int pontos, Piloto pil, Kartodromo kart, Bateria bat) {
		super();
		Id = id;
		Nome = nome;
		this.pontos = pontos;
		this.pil = pil;
		this.kart = kart;
		this.bat = bat;
	}

	public Campeonato() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((bat == null) ? 0 : bat.hashCode());
		result = prime * result + ((kart == null) ? 0 : kart.hashCode());
		result = prime * result + ((pil == null) ? 0 : pil.hashCode());
		result = prime * result + pontos;
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
		if (Id != other.Id)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (bat == null) {
			if (other.bat != null)
				return false;
		} else if (!bat.equals(other.bat))
			return false;
		if (kart == null) {
			if (other.kart != null)
				return false;
		} else if (!kart.equals(other.kart))
			return false;
		if (pil == null) {
			if (other.pil != null)
				return false;
		} else if (!pil.equals(other.pil))
			return false;
		if (pontos != other.pontos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Campeonato [Id=" + Id + ", Nome=" + Nome + ", pontos=" + pontos + ", pil=" + pil + ", kart=" + kart
				+ ", bat=" + bat + "]";
	}

}
