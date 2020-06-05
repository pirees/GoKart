package gokart.bo;


import java.time.LocalDate;
import java.util.List;

import gokart.classes.Bateria;
import gokart.dao.BateriaDao;
import gokart.dao.GenericDao;

public class BateriaBo {

	public String Salvar(Bateria bateria) 
			throws Exception {
		validarDadosGrupo(bateria);
		GenericDao<Bateria> tcDao = new GenericDao<Bateria>();
		try {
			return tcDao.saveOrUpdate(bateria);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Bateria bateria) 
			throws Exception {
		validarDadosGrupo(bateria);
		GenericDao<Bateria> tcDao = new GenericDao<Bateria>();
		try {
			return tcDao.remove(Bateria.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Bateria> listarBateria(String nome, LocalDate data) 
			throws Exception {
		try {
			return new BateriaDao().ProcuraKartodromo(nome,data);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Bateria bateria) throws Exception {
		if (bateria.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}
}
