package gokart.classes;

import javax.persistence.ManyToOne;

public class AcumulaPontosCamp {
	
	private int id;	
	private long pontuacao;
	private PilotoCampeonato Pil_campeonato;
	
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
	
	public PilotoCampeonato getPil_campeonato() {
		return Pil_campeonato;
	}
	public void setPil_campeonato(PilotoCampeonato pil_campeonato) {
		Pil_campeonato = pil_campeonato;
	}
	


}
