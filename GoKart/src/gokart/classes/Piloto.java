package gokart.classes;

public class Piloto {
	
	private String nome;
	private String senha;
	private String apelido;
	private String cidade;
	private String estado;
	private String contato;
	private int idade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Piloto() {
		super();
	}
	@Override
	public String toString() {
		return "piloto [nome=" + nome + ", senha=" + senha + ", apelido=" + apelido + ", cidade=" + cidade + ", estado="
				+ estado + ", idade=" + idade + "]";
	}
}
