package gokart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nome_Da_Unit_De_Persistencia");

	// getConnection
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
