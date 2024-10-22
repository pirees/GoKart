package gokart.bo;


import java.time.LocalDate;
import java.util.List;

import gokart.classes.Bateria;
import gokart.classes.Kartodromo;
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
	
	public List<Bateria> listarBateriasNome(String nome, LocalDate date) throws Exception {		
			return new BateriaDao().ProcurarBateria(nome, date);		
	}
	
	public List<Bateria> listarBateriasKartodromo(Kartodromo k) throws Exception {		
		return new BateriaDao().ListaBateriaKartodromo(k);	
}

		
	private void validarDadosGrupo(Bateria bateria) throws Exception {
		if (bateria.getId() < 0) {
			throw new Exception("Id da composicao n�o pode ser negativo!");
		}
	}
}
