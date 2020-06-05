package gokart.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Bateria;;

public class BateriaDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Bateria> ProcurarBateria(String nome, LocalDate data)throws Exception{	

		  Query	a = em.createQuery("select b from Bateria b"
					+" inner join b.kartodromo k"
					+" where k.nome like :nome"
		            +" and b.data like :data");
		
		  a.setParameter("nome", "%"+nome.toUpperCase()+"%" );
		  a.setParameter("data", data );	

		return a.getResultList();		
	}
	
	public List<Bateria> ListaBateria() throws Exception {	

		Query a = em.createQuery("select b from Bateria b");

		return a.getResultList();
	}

}

