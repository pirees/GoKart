package gokart.classes;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bateria")
public class Bateria implements EntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private Date Data;
	
	@ManyToOne
	private Piloto pil;
	
	@ManyToOne
	private Kartodromo kart;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
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

	public Bateria(int id, Date data, Piloto pil, Kartodromo kart) {
		super();
		Id = id;
		Data = data;
		this.pil = pil;
		this.kart = kart;
	}

	public Bateria() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Data == null) ? 0 : Data.hashCode());
		result = prime * result + Id;
		result = prime * result + ((kart == null) ? 0 : kart.hashCode());
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
		Bateria other = (Bateria) obj;
		if (Data == null) {
			if (other.Data != null)
				return false;
		} else if (!Data.equals(other.Data))
			return false;
		if (Id != other.Id)
			return false;
		if (kart == null) {
			if (other.kart != null)
				return false;
		} else if (!kart.equals(other.kart))
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
		return "Bateria [Id=" + Id + ", Data=" + Data + ", pil=" + pil + ", kart=" + kart + "]";
	}	

}
