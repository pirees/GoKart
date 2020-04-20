package gokart.bo;

import gokart.classes.Kartodromo;
import gokart.dao.GenericDao;

public class KartodromoBo {
	
	public String Salvar(Kartodromo kartodromo) 
			throws Exception {
		validarDadosGrupo(kartodromo);
		GenericDao<Kartodromo> tcDao = new GenericDao<Kartodromo>();
		try {
			return tcDao.saveOrUpdate(kartodromo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Kartodromo kartodromo) 
			throws Exception {
		validarDadosGrupo(kartodromo);
		GenericDao<Kartodromo> tcDao = new GenericDao<Kartodromo>();
		try {
			return tcDao.remove(Kartodromo.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Kartodromo kartodromo) throws Exception {
		if (kartodromo.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}
}
