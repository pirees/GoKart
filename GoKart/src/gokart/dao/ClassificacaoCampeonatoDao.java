package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.ClassificacaoCampeonato;

import gokart.classes.PilotoCampeonato;

public class ClassificacaoCampeonatoDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<ClassificacaoCampeonato> listarCC(BateriaCampeonato bc, PilotoCampeonato piloto) {

		Query q = null;

		q = em.createQuery(
				"select cc from ClassificacaoCampeonato cc" + " where cc.bat = :batid" + " and cc.pil = :pil_id");

		q.setParameter("batid", bc);
		q.setParameter("pil_id", piloto);

		return q.getResultList();

	}

	public List<ClassificacaoCampeonato> listar(Campeonato camp) {

		Query q = null;

		q = em.createQuery("select cc from ClassificacaoCampeonato cc"
						 + " where cc.camp = :campid");

		q.setParameter("campid", camp);

		return q.getResultList();

	}

}
