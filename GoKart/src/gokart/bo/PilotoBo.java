package gokart.bo;

import java.util.List;

import gokart.classes.Piloto;
import gokart.dao.GenericDao;
import gokart.dao.PilotoDao;

public class PilotoBo {
	
	public String Salvar(Piloto piloto) throws Exception {
		
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
			throw new Exception("Id do Piloto não pode ser negativo!");
		}
	}
	
	public List<Piloto> listarPiloto() 
			throws Exception {
		try {
			return new PilotoDao().listarNomePiloto();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	public List<Piloto> listarNivel() 
			throws Exception {
		try {
			return new PilotoDao().listarNivelPiloto();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
