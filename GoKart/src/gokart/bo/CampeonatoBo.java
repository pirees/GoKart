package gokart.bo;

import gokart.classes.Campeonato;
import gokart.dao.GenericDao;

public class CampeonatoBo {
	
	public String Salvar(Campeonato campeonato) 
			throws Exception {
		validarDadosGrupo(campeonato);
		GenericDao<Campeonato> tcDao = new GenericDao<Campeonato>();
		try {
			return tcDao.saveOrUpdate(campeonato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Campeonato campeonato) 
			throws Exception {
		validarDadosGrupo(campeonato);
		GenericDao<Campeonato> tcDao = new GenericDao<Campeonato>();
		try {
			return tcDao.remove(Campeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Campeonato campeonato) throws Exception {
		if (campeonato.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}

}
