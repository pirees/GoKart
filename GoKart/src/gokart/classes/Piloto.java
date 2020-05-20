package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
@Table(name = "piloto")
public class Piloto implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String testeComit;
	
	@ManyToOne
	private Estado est;

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

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public Estado getEst() {
		return est;
	}

	public void setEst(Estado est) {
		this.est = est;
	}

	public Piloto(int id, String nome, String endereco, String cidade, Estado est) {
		super();
		Id = id;
		Nome = nome;
		Endereco = endereco;
		Cidade = cidade;
		this.est = est;
	}

	public Piloto() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cidade == null) ? 0 : Cidade.hashCode());
		result = prime * result + ((Endereco == null) ? 0 : Endereco.hashCode());
		result = prime * result + Id;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((est == null) ? 0 : est.hashCode());
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
		Piloto other = (Piloto) obj;
		if (Cidade == null) {
			if (other.Cidade != null)
				return false;
		} else if (!Cidade.equals(other.Cidade))
			return false;
		if (Endereco == null) {
			if (other.Endereco != null)
				return false;
		} else if (!Endereco.equals(other.Endereco))
			return false;
		if (Id != other.Id)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (est == null) {
			if (other.est != null)
				return false;
		} else if (!est.equals(other.est))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piloto [Id=" + Id + ", Nome=" + Nome + ", Endereco=" + Endereco + ", Cidade=" + Cidade + ", est=" + est
				+ "]";
	}
	
	
}
