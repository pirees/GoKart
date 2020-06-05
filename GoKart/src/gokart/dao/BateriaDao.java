package gokart.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Bateria;;

public class BateriaDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Bateria> ProcuraKartodromo(String nome, LocalDate data)throws Exception{	

		Query a = null;
		if(nome.equals("")) {
			a = em.createQuery("select b from Bateria b"
					+" inner join b.kartodromo k"
					+" where k.nome like :nome");
		}
		else {
			a = em.createQuery("select b from Bateria b"
					+" where b.data like :data");
		}
		a.setParameter("data", data );
		a.setParameter("nome", "%"+nome.toUpperCase()+"%" );	

		return a.getResultList();		
	}

}

