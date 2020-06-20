package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.Kartodromo;

public class KartodromoDao {

private static EntityManager em = Fabrica.getEntityManager();
	
	public Kartodromo ValidaLogin(String email, String senha)throws Exception{	
		
		List<Kartodromo> lista;
		
		Query q = em.createQuery("SELECT k from Kartodromo k"
				+" where email = :email"
				+" and senha = :senha");
		
		q.setParameter("email", email);
		q.setParameter("senha", senha);		
		
		lista = q.getResultList();	
		
		/*Caso exista um kartodromo, entra no bloco do FOR e retorna, caso contrario retorna null*/				
		for (Kartodromo ki : lista) {				
			return ki;					
		}
				
		return null;		
	}
	
	public Kartodromo ValidaCNPJ(String cnpj)throws Exception{	

		List<Kartodromo> lista;

		Query q = em.createQuery("SELECT k from Kartodromo k"
				+" where cnpj = :cnpj");

		q.setParameter("cnpj", cnpj);		

		lista = q.getResultList();	
			
		for (Kartodromo ki : lista) {				
			return ki;					
		}

		return null;		
	}

}
