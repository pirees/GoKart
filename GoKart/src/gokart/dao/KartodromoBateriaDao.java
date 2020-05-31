package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.KartodromoBateria;

public class KartodromoBateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	

	public List <KartodromoBateria> ProcuraKartodromo(String nome)throws Exception{	
		
		
		
		Query q = em.createQuery("SELECT k from kartodromobateria k"
				+" where tracado like :tracado");
		
		q.setParameter("tracado", "%"+nome.toUpperCase()+"%" );				
		

				
		return q.getResultList();		
	}

}
