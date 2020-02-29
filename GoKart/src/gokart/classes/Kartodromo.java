package gokart.classes;

public class Kartodromo {

	private String nome;
	private String senha;
	private String cnpj;
	private String cidade;
	private String estado;
	private String endereco;
	private String numeroPilotoCorrida;
	private String tracado;
    private Piloto piloto;
    private String contato;
    
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroPilotoCorrida() {
		return numeroPilotoCorrida;
	}
	public void setNumeroPilotoCorrida(String numeroPilotoCorrida) {
		this.numeroPilotoCorrida = numeroPilotoCorrida;
	}
	public String getTracado() {
		return tracado;
	}
	public void setTracado(String tracado) {
		this.tracado = tracado;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public Kartodromo() {
		super();
	}
	@Override
	public String toString() {
		return "kartodromo [nome=" + nome + ", senha=" + senha + ", cnpj=" + cnpj + ", cidade=" + cidade + ", estado="
				+ estado + ", endereco=" + endereco + ", numeroPilotoCorrida=" + numeroPilotoCorrida + ", tracado="
				+ tracado + ", piloto=" + piloto + "]";
	}	
     
}
