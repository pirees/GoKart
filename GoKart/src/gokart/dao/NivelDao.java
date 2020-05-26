package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Nivel;

public class NivelDao {
	
	private static EntityManager em = Fabrica.getEntityManager();	
	
	public List<Nivel> LoadNivel(){				
		Query q = em.createQuery("SELECT n from Nivel n");		
		return q.getResultList();				
	}
	

}
