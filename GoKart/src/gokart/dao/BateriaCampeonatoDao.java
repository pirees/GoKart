package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;

public class BateriaCampeonatoDao  {
	
	private static EntityManager em = Fabrica.getEntityManager();	
	
	public List<BateriaCampeonato> listaBateriaCp(Campeonato cp) throws Exception{
		

		Query q = em.createQuery("SELECT bc from BateriaCampeonato bc"
				+" where id_campeonato_id = :id_cp");
		
		q.setParameter("id_cp", cp.getId());
		
		return q.getResultList();	
		
	}
	
	

}
