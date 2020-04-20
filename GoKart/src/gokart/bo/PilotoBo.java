package gokart.bo;

import gokart.classes.Piloto;
import gokart.dao.GenericDao;

public class PilotoBo {
	
	public String Salvar(Piloto piloto) 
			throws Exception {
		validarDadosGrupo(piloto);
		GenericDao<Piloto> tcDao = new GenericDao<Piloto>();
		try {
			return tcDao.saveOrUpdate(piloto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Piloto piloto) 
			throws Exception {
		validarDadosGrupo(piloto);
		GenericDao<Piloto> tcDao = new GenericDao<Piloto>();
		try {
			return tcDao.remove(Piloto.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Piloto piloto) throws Exception {
		if (piloto.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}

}
