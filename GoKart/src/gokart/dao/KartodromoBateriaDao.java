package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.KartodromoBateria;

public class KartodromoBateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	

	public List <KartodromoBateria> ProcuraKartodromo(String tracado)throws Exception{	
				
		//Query q = em.createQuery("SELECT k from KartodromoBateria k"
		//		+" where tracado like :tracado");
		
		Query q = em.createQuery("select k from KartodromoBateria k" 
				+" where tracado like :tracado");
		
		q.setParameter("tracado", "%"+tracado.toUpperCase()+"%" );				
		

				
		return q.getResultList();		
	}

}
