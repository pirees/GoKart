package gokart.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.Piloto;

public class PilotoDao {
	
	private static EntityManager em = Fabrica.getEntityManager();
	
	public Piloto ValidaLogin(String email, String senha){	
		
		List<Piloto> lista;
		
		Query q = em.createQuery("SELECT p from Piloto p"
				+" where email = :email"
				+" and senha = :senha");
		
		q.setParameter("email", email);
		q.setParameter("senha", senha);		
		
		lista = q.getResultList();
				
		for (Piloto pi : lista) {			
			System.out.println(pi.getNome());			
		}
				
		return null;		
	}
	
	public List<Piloto> listarNomePiloto() throws Exception{		
		EntityManager em = Fabrica.getEntityManager();
	
		// select (campos)
		Query q = em.createQuery("select nome from Piloto");
		
		
		return q.getResultList();		
	} 
	
	public List<Piloto> listarNivelPiloto() throws Exception{		
		EntityManager em = Fabrica.getEntityManager();
	
		// select (campos)
		Query q = em.createQuery("SELECT nivel.nivel from piloto inner join nivel on piloto.nivel_id = nivel.id");
				
		return q.getResultList();		
	} 
}
