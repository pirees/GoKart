package gokart.bo;

import java.util.List;

import gokart.classes.Campeonato;
import gokart.classes.Kartodromo;
import gokart.classes.PontuacaoCampeonato;
import gokart.dao.GenericDao;
import gokart.dao.PontuacaoCampeonatoDao;

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
	
	
	public List<PontuacaoCampeonato> listarPt (Campeonato cp)throws Exception {	
		
		PontuacaoCampeonatoDao pcDao = new PontuacaoCampeonatoDao();		
		return pcDao.listaPontuacao(cp);		
		
	}
	
		
	private void validarDadosGrupo(PontuacaoCampeonato pCp) throws Exception {
		if (pCp.getId() < 0) {
			throw new Exception("Id não pode ser negativo!");
		}
	}
	
	

}
