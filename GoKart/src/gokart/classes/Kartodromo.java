package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "kartodromo")
public class Kartodromo implements EntityBase {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private int Cnpj;
	private String Nome;
	private String Endereco;
	
	@ManyToOne
	private Estado est;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCnpj() {
		return Cnpj;
	}

	public void setCnpj(int cnpj) {
		Cnpj = cnpj;
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

	public Estado getEst() {
		return est;
	}

	public void setEst(Estado est) {
		this.est = est;
	}

	public Kartodromo(int id, int cnpj, String nome, String endereco, Estado est) {
		super();
		Id = id;
		Cnpj = cnpj;
		Nome = nome;
		Endereco = endereco;
		this.est = est;
	}

	public Kartodromo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cnpj;
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
		Kartodromo other = (Kartodromo) obj;
		if (Cnpj != other.Cnpj)
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
		return "Kartodromo [Id=" + Id + ", Cnpj=" + Cnpj + ", Nome=" + Nome + ", Endereco=" + Endereco + ", est=" + est
				+ "]";
	}
    
}
