package gokart.bo;

import java.util.List;

import gokart.classes.Campeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;
import gokart.dao.GenericDao;
import gokart.dao.PilotoCampeonatoDao;

public class PilotoCampeonatoBo {
	
	public String Salvar(PilotoCampeonato pCmp) throws Exception {

		validarDadosGrupo(pCmp);

		GenericDao<PilotoCampeonato> tcDao = new GenericDao<PilotoCampeonato>();

		try {
			return tcDao.saveOrUpdate(pCmp);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(PilotoCampeonato pCmp) throws Exception {
		validarDadosGrupo(pCmp);
		GenericDao<PilotoCampeonato> tcDao = new GenericDao<PilotoCampeonato>();
		try {
			return tcDao.remove(PilotoCampeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PilotoCampeonato> ListarPilotoCampeonato(Piloto piloto)throws Exception{	
		
		PilotoCampeonatoDao pcpDao = new PilotoCampeonatoDao();				
		return pcpDao.ListaPilotoCampeonato(piloto);		
	}

	private void validarDadosGrupo(PilotoCampeonato pCmp) throws Exception {
		if (pCmp.getId() < 0) {
			throw new Exception("Id do Piloto não pode ser negativo!");
		}
	}

}
