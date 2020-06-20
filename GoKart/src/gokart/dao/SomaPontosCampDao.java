package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.PilotoCampeonato;
import gokart.classes.SomaPontosCamp;

public class SomaPontosCampDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<SomaPontosCamp> listar(Campeonato cp) throws Exception {

		Query q = em.createQuery("SELECT spc from SomaPontosCamp spc"
								+ " where spc.cp = :id_cp"
								+ " order by pontos desc");

		q.setParameter("id_cp", cp);

		return q.getResultList();

	}
	
	
	public List<SomaPontosCamp> listarPiloto(Campeonato cp, PilotoCampeonato pc) throws Exception {

		Query q = em.createQuery("SELECT spc from SomaPontosCamp spc"
								+ " where spc.cp = :id_cp"
								+ " and   spc.pc = :id_pl");

		q.setParameter("id_cp", cp);
		q.setParameter("id_pl", pc);

		return q.getResultList();

	}
	
	
	
	

}
