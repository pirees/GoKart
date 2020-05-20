package gokart.classes;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class PilotoBateria implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Piloto pil;
	
	@ManyToOne
	private Bateria bat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piloto getPil() {
		return pil;
	}

	public void setPil(Piloto pil) {
		this.pil = pil;
	}

	public Bateria getBat() {
		return bat;
	}

	public void setBat(Bateria bat) {
		this.bat = bat;
	}

	public PilotoBateria() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bat == null) ? 0 : bat.hashCode());
		result = prime * result + id;
		result = prime * result + ((pil == null) ? 0 : pil.hashCode());
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
		PilotoBateria other = (PilotoBateria) obj;
		if (bat == null) {
			if (other.bat != null)
				return false;
		} else if (!bat.equals(other.bat))
			return false;
		if (id != other.id)
			return false;
		if (pil == null) {
			if (other.pil != null)
				return false;
		} else if (!pil.equals(other.pil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PilotoBateria [id=" + id + ", pil=" + pil + ", bat=" + bat + "]";
	}

	
	
}
