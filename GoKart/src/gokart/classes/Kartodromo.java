package gokart.classes;

import java.sql.Time;

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
	private int id;
	
	private int cnpj;
	private String nome;
	private String endereco;
	private String email;
	private String senha;
	private String repetirSenha;
	private Time horaAtendimento;
	
	@ManyToOne
	private Estado est;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}

	public Time getHoraAtendimento() {
		return horaAtendimento;
	}

	public void setHoraAtendimento(Time horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}

	public Estado getEst() {
		return est;
	}

	public void setEst(Estado est) {
		this.est = est;
	}

	public Kartodromo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnpj;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((est == null) ? 0 : est.hashCode());
		result = prime * result + ((horaAtendimento == null) ? 0 : horaAtendimento.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((repetirSenha == null) ? 0 : repetirSenha.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		if (cnpj != other.cnpj)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (est == null) {
			if (other.est != null)
				return false;
		} else if (!est.equals(other.est))
			return false;
		if (horaAtendimento == null) {
			if (other.horaAtendimento != null)
				return false;
		} else if (!horaAtendimento.equals(other.horaAtendimento))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (repetirSenha == null) {
			if (other.repetirSenha != null)
				return false;
		} else if (!repetirSenha.equals(other.repetirSenha))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kartodromo [id=" + id + ", cnpj=" + cnpj + ", nome=" + nome + ", endereco=" + endereco + ", email="
				+ email + ", senha=" + senha + ", repetirSenha=" + repetirSenha + ", horaAtendimento=" + horaAtendimento
				+ ", est=" + est + "]";
	}
	
}
