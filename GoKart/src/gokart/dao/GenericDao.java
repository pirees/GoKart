package gokart.dao;

import javax.persistence.EntityManager;
import gokart.classes.EntityBase;

public class GenericDao <T extends EntityBase> {
	
	private static EntityManager em = Fabrica.getEntityManager();

	public String saveOrUpdate(T obj) throws Exception{
		try{
			em.getTransaction().begin();
			if(obj.getId() == 0){
				em.persist(obj);
			}		
			else {
				em.merge(obj);
			}
			em.getTransaction().commit();	
		}
		catch(Exception e){
			throw new Exception("Erro Gravando \n"+e.getMessage());
		}
		return "salvo com sucesso.";
	}
	
	public String remove(Class<T> classe, int id) throws Exception{
		T t = findById(classe, id);
		try{
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception("Erro Deletando \n"+e.getMessage());
		}
		return "Removeu";		
	}
		
	// Recebe uma entidade modelo
	public T findById(Class<T> classe, int id) {
		return em.find(classe, id);
	}	

}
