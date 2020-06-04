package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.KartodromoBateria;

public class KartodromoBateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	

	public List <KartodromoBateria> ProcuraKartodromo(String nome)throws Exception{	
		
//		Query q = em.createQuery("select k from KartodromoBateria k" 
//				+" where tracado like :tracado");
//		
//		q.setParameter("tracado", "%"+tracado.toUpperCase()+"%" );	
		
		Query a = em.createQuery("select kb from KartodromoBateria kb"
				+" inner join kb.kartodromo k"
				+" where k.nome like :nome");
		
		a.setParameter("nome", "%"+nome.toUpperCase()+"%" );	
						
		return a.getResultList();		
	}

}