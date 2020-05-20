package gokart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unitGoKart");

	// getConnection
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
