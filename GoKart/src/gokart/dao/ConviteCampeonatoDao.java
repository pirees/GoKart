package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import gokart.classes.ConviteCampeonato;
import gokart.classes.Piloto;


public class ConviteCampeonatoDao {
	
	private static EntityManager em = Fabrica.getEntityManager();
	
	public List<ConviteCampeonato> ListarConvites(Piloto piloto) throws Exception {	

		Query a = em.createQuery("select cc from ConviteCampeonato cc"
				+" where id_piloto_Id like :Id_piloto");
		
		a.setParameter("Id_piloto", piloto.getId());

		return a.getResultList();
	}
}
