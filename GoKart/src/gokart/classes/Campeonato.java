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
	private int id;
	private String nomeCampeonato;
	private int nrMaxPiloto;
	private int nrBatCampeonato;
	private int qntPilotoCampeonato;
	private int potuacaoMV;
	private String test;
	@ManyToOne
	private Piloto pil;
	
	@ManyToOne
	private Kartodromo kart;
	
	@ManyToOne
	private Bateria bat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public int getNrMaxPiloto() {
		return nrMaxPiloto;
	}

	public void setNrMaxPiloto(int nrMaxPiloto) {
		this.nrMaxPiloto = nrMaxPiloto;
	}

	public int getNrBatCampeonato() {
		return nrBatCampeonato;
	}

	public void setNrBatCampeonato(int nrBatCampeonato) {
		this.nrBatCampeonato = nrBatCampeonato;
	}

	public int getQntPilotoCampeonato() {
		return qntPilotoCampeonato;
	}

	public void setQntPilotoCampeonato(int qntPilotoCampeonato) {
		this.qntPilotoCampeonato = qntPilotoCampeonato;
	}

	public int getPotuacaoMV() {
		return potuacaoMV;
	}

	public void setPotuacaoMV(int potuacaoMV) {
		this.potuacaoMV = potuacaoMV;
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

	public Campeonato() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bat == null) ? 0 : bat.hashCode());
		result = prime * result + id;
		result = prime * result + ((kart == null) ? 0 : kart.hashCode());
		result = prime * result + ((nomeCampeonato == null) ? 0 : nomeCampeonato.hashCode());
		result = prime * result + nrBatCampeonato;
		result = prime * result + nrMaxPiloto;
		result = prime * result + ((pil == null) ? 0 : pil.hashCode());
		result = prime * result + potuacaoMV;
		result = prime * result + qntPilotoCampeonato;
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
		if (bat == null) {
			if (other.bat != null)
				return false;
		} else if (!bat.equals(other.bat))
			return false;
		if (id != other.id)
			return false;
		if (kart == null) {
			if (other.kart != null)
				return false;
		} else if (!kart.equals(other.kart))
			return false;
		if (nomeCampeonato == null) {
			if (other.nomeCampeonato != null)
				return false;
		} else if (!nomeCampeonato.equals(other.nomeCampeonato))
			return false;
		if (nrBatCampeonato != other.nrBatCampeonato)
			return false;
		if (nrMaxPiloto != other.nrMaxPiloto)
			return false;
		if (pil == null) {
			if (other.pil != null)
				return false;
		} else if (!pil.equals(other.pil))
			return false;
		if (potuacaoMV != other.potuacaoMV)
			return false;
		if (qntPilotoCampeonato != other.qntPilotoCampeonato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", nomeCampeonato=" + nomeCampeonato + ", nrMaxPiloto=" + nrMaxPiloto
				+ ", nrBatCampeonato=" + nrBatCampeonato + ", qntPilotoCampeonato=" + qntPilotoCampeonato
				+ ", potuacaoMV=" + potuacaoMV + ", pil=" + pil + ", kart=" + kart + ", bat=" + bat + "]";
	}
	
	
		
}
