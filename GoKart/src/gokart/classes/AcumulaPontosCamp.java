package gokart.classes;

import javax.persistence.ManyToOne;

public class AcumulaPontosCamp {
	
	private int id;
	private int posicao;
	private long pontuacao;
	private PilotoCampeonato Pil_campeonato;
	
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
	
	public PilotoCampeonato getPil_campeonato() {
		return Pil_campeonato;
	}
	public void setPil_campeonato(PilotoCampeonato pil_campeonato) {
		Pil_campeonato = pil_campeonato;
	}
	


}
