package gokart.classes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kartodromoBateria")
public class KartodromoBateria implements EntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Date data;
	
	@Column
	private String horaBateria;
	
	@Column
	private int nrMaxPiloto;
	
	@ManyToOne
	private Kartodromo kartodromo;
	
	"hahahaha"

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraBateria() {
		return horaBateria;
	}

	public void setHoraBateria(String horaBateria) {
		this.horaBateria = horaBateria;
	}

	public int getNrMaxPiloto() {
		return nrMaxPiloto;
	}

	public void setNrMaxPiloto(int nrMaxPiloto) {
		this.nrMaxPiloto = nrMaxPiloto;
	}

	public Kartodromo getKartodromo() {
		return kartodromo;
	}

	public void setKartodromo(Kartodromo kartodromo) {
		this.kartodromo = kartodromo;
	}

	public KartodromoBateria() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((horaBateria == null) ? 0 : horaBateria.hashCode());
		result = prime * result + id;
		result = prime * result + ((kartodromo == null) ? 0 : kartodromo.hashCode());
		result = prime * result + nrMaxPiloto;
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
		KartodromoBateria other = (KartodromoBateria) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (horaBateria == null) {
			if (other.horaBateria != null)
				return false;
		} else if (!horaBateria.equals(other.horaBateria))
			return false;
		if (id != other.id)
			return false;
		if (kartodromo == null) {
			if (other.kartodromo != null)
				return false;
		} else if (!kartodromo.equals(other.kartodromo))
			return false;
		if (nrMaxPiloto != other.nrMaxPiloto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KartodromoBateria [id=" + id + ", data=" + data + ", horaBateria=" + horaBateria + ", nrMaxPiloto="
				+ nrMaxPiloto + ", kartodromo=" + kartodromo + "]";
	}
	
	

}
