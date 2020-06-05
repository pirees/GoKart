package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Bateria;
import gokart.classes.KartodromoBateria;

public class BateriaDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Bateria> ListaBateria() throws Exception {	

		Query a = em.createQuery("select b from Bateria b");

		return a.getResultList();
	}

}
