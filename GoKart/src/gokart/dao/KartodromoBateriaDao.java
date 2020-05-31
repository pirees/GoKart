package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.KartodromoBateria;

public class KartodromoBateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	

	public List <KartodromoBateria> ProcuraKartodromo(String nome)throws Exception{	
				
		//Query q = em.createQuery("SELECT k from KartodromoBateria k"
		//		+" where tracado like :tracado");
		
		Query q = em.createQuery("select kartodromobateria, nome, horaBateria, nrMaxPiloto, tracado from KartodromoBateria kartodromobateria" 
				+" inner join kartodromo on kartodromo.id = kartodromobateria.kartodromo_id"
				+" where nome like :nome");
		
		q.setParameter("nome", "%"+nome.toUpperCase()+"%" );				
		

				
		return q.getResultList();		
	}

}
