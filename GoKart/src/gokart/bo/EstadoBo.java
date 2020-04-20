package gokart.bo;

import gokart.classes.Estado;
import gokart.dao.GenericDao;

public class EstadoBo {
	
	public String Salvar(Estado estado) 
			throws Exception {
		validarDadosGrupo(estado);
		GenericDao<Estado> tcDao = new GenericDao<Estado>();
		try {
			return tcDao.saveOrUpdate(estado);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Estado estado) 
			throws Exception {
		validarDadosGrupo(estado);
		GenericDao<Estado> tcDao = new GenericDao<Estado>();
		try {
			return tcDao.remove(Estado.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Estado estado) throws Exception {
		if (estado.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}

}
