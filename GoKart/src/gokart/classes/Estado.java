package gokart.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estado")
public class Estado implements EntityBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	
	private String Nome;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Estado(int id, String nome) {
		super();
		Id = id;
		Nome = nome;
	}
	public Estado() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
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
		Estado other = (Estado) obj;
		if (Id != other.Id)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Estado [Id=" + Id + ", Nome=" + Nome + "]";
	}
}
