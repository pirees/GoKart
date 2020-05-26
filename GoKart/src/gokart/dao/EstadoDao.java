package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Estado;
import gokart.classes.Piloto;

public class EstadoDao {
	
	private static EntityManager em = Fabrica.getEntityManager();
	
	public List<Estado> LoadEstado(){				
		Query q = em.createQuery("SELECT e from Estado e order by nome");		
		return q.getResultList();				
	}
	

}
