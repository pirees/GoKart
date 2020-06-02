package gokart.bo;

import java.util.List;

import gokart.classes.Campeonato;
import gokart.classes.Piloto;
import gokart.dao.GenericDao;

public class CampeonatoBo {
	
	public String Salvar(Campeonato cp) throws Exception {

		validarDadosGrupo(cp);

		GenericDao<Campeonato> cpDao = new GenericDao<Campeonato>();

		try {
			return cpDao.saveOrUpdate(cp);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Campeonato cp) throws Exception {
		
		validarDadosGrupo(cp);
		GenericDao<Campeonato> cpDao = new GenericDao<Campeonato>();
		
		try {
			return cpDao.remove(Campeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
		
	private void validarDadosGrupo(Campeonato campeonato) throws Exception {
		if (campeonato.getId() < 0) {
			throw new Exception("ID do Campeonato não poder ser menor que ZERO.");
		}
		
		if(campeonato.getNomeCampeonato().isEmpty()) {
			throw new Exception("Nome do Campeonato não pode ser BRANCO.");			
		}
		
	}
	
	
}
