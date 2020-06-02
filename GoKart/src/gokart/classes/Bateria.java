package gokart.classes;



import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
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
	private int id;
	
	@Column
	private LocalDate data;
	
	@Column
	private String nome;
	("teste");
	@Column
	private int nrMaxPiloto;
	
	@Column
	private Time horaBateria;	
	
	@ManyToOne
	private Piloto piloto;
	
	@ManyToOne
	private Kartodromo kartodromo;	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNrMaxPiloto() {
		return nrMaxPiloto;
	}

	public void setNrMaxPiloto(int nrMaxPiloto) {
		this.nrMaxPiloto = nrMaxPiloto;
	}

	public Time getHoraBateria() {
		return horaBateria;
	}

	public void setHoraBateria(Time horaBateria) {
		this.horaBateria = horaBateria;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Kartodromo getKartodromo() {
		return kartodromo;
	}

	public void setKartodromo(Kartodromo kartodromo) {
		this.kartodromo = kartodromo;
	}	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((horaBateria == null) ? 0 : horaBateria.hashCode());
		result = prime * result + id;
		result = prime * result + ((kartodromo == null) ? 0 : kartodromo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + nrMaxPiloto;
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nrMaxPiloto != other.nrMaxPiloto)
			return false;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		return "Bateria [id=" + id + ", data=" + data + ", nome=" + nome + ", nrMaxPiloto=" + nrMaxPiloto
				+ ", horaBateria=" + horaBateria + ", piloto=" + piloto + ", kartodromo=" + kartodromo + "]";
	}

	public Bateria() {
		super();
	}
	
}
