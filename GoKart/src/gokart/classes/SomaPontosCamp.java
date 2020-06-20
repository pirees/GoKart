package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SomaPontosCamp")
public class SomaPontosCamp implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	@ManyToOne	
	private Campeonato cp;	
	
	@ManyToOne
	private PilotoCampeonato pc;	
	
	private double pontos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Campeonato getCp() {
		return cp;
	}

	public void setCp(Campeonato cp) {
		this.cp = cp;
	}

	public PilotoCampeonato getPc() {
		return pc;
	}

	public void setPc(PilotoCampeonato pc) {
		this.pc = pc;
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}
	
	

}
