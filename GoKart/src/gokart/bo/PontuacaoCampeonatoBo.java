package gokart.bo;

import gokart.classes.Kartodromo;
import gokart.classes.PontuacaoCampeonato;
import gokart.dao.GenericDao;

public class PontuacaoCampeonatoBo {
	
	
	public String Salvar(PontuacaoCampeonato pCp) throws Exception {
		
		validarDadosGrupo(pCp);
		
		GenericDao<PontuacaoCampeonato> pCDao = new GenericDao<PontuacaoCampeonato>();
		
		try {
			return pCDao.saveOrUpdate(pCp);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(PontuacaoCampeonato pCp) throws Exception {
		
		validarDadosGrupo(pCp);
		
		GenericDao<PontuacaoCampeonato> tcDao = new GenericDao<PontuacaoCampeonato>();
		
		try {
			return tcDao.remove(PontuacaoCampeonato.class, 1);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(PontuacaoCampeonato pCp) throws Exception {
		if (pCp.getId() < 0) {
			throw new Exception("Id não pode ser negativo!");
		}
	}
	
	

}
