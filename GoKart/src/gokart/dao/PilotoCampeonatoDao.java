package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Campeonato;
import gokart.classes.Nivel;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;

public class PilotoCampeonatoDao {
	
private static EntityManager em = Fabrica.getEntityManager();	
	
	public List<PilotoCampeonato> ListaPilotoCampeonato(Piloto piloto){				
		Query q = em.createQuery("SELECT pcp from PilotoCampeonato pcp"
				+ " where piloto_id = :piloto");	
		
		q.setParameter("piloto", piloto.getId());
		
		return q.getResultList();				
	}	
	
	
	public List<PilotoCampeonato> ListaCampeonatoPiloto(Campeonato cp){		
		
		Query q = em.createQuery("SELECT pcp from PilotoCampeonato pcp"
				+ " where campeonato_id = :camp");	
		
		q.setParameter("camp", cp.getId());
		
		return q.getResultList();				
	}	
	
	
}
