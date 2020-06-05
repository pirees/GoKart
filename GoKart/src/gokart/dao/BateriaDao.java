<<<<<<< HEAD
package gokart.dao;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.Bateria;


public class BateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	

	public List<Bateria> ProcuraKartodromo(String nome, LocalDate data)throws Exception{	
		
		Query a = null;
		if(nome.equals("")) {
		a = em.createQuery("select b from Bateria b"
				+" inner join b.kartodromo k"
				+" where k.nome like :nome");
		}
		else {
			a = em.createQuery("select b from Bateria b"
				+" where b.data like :data");
		}
		a.setParameter("data", data );
		a.setParameter("nome", "%"+nome.toUpperCase()+"%" );	
						
		return a.getResultList();		
	}

//	public List<Grupo> listar(String paramNome, Date dateI, Date dateF) throws Exception{		
//		EntityManager em = Fabrica.getEntityManager();
//		String cWhere = "";
//		Query q = null;
//		if (paramNome.equals("")) {
//			q = em.createQuery("select g from Grupo g");
//		}
//		else {
//		    //query
//			q = em.createQuery("select g from Grupo g"
//					+" where data between :dataInicial"
//					+" and :dataFinal ");
//			q.setParameter("dataInicial", dateI);
//			q.setParameter("dataFinal", dateF);
//			
////			q = em.createQuery("select g from Grupo g"
////					+" where nome like :nome");
////			q.setParameter("nome", "%"+paramNome.toUpperCase()+"%"  );
//		}
//		
//		return q.getResultList();		
//	} //listar
}
=======
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
>>>>>>> branch 'master' of https://github.com/pirees/GoKart.git
