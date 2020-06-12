package gokart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.PontuacaoCampeonato;

public class PontuacaoCampeonatoDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<PontuacaoCampeonato> listaPontuacao(Campeonato cp) throws Exception {

		Query q = em.createQuery("SELECT pt from PontuacaoCampeonato pt"
							     + " where id_campeonato_id = :id_cp");

		q.setParameter("id_cp", cp.getId());

		return q.getResultList();

	}

}
