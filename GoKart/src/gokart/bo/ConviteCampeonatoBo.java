package gokart.bo;

import gokart.classes.Campeonato;
import gokart.classes.ConviteCampeonato;
import gokart.dao.GenericDao;

public class ConviteCampeonatoBo {
	
	public String Salvar(ConviteCampeonato cp) throws Exception {

		validarDadosGrupo(cp);

		GenericDao<ConviteCampeonato> cpDao = new GenericDao<ConviteCampeonato>();

		try {
			return cpDao.saveOrUpdate(cp);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(ConviteCampeonato cp) throws Exception {
		
		validarDadosGrupo(cp);
		GenericDao<ConviteCampeonato> cpDao = new GenericDao<ConviteCampeonato>();
		
		try {
			return cpDao.remove(ConviteCampeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
		
	private void validarDadosGrupo(ConviteCampeonato cvCp) throws Exception {
		if (cvCp.getId() < 0) {
			throw new Exception("ID do Campeonato não poder ser menor que ZERO.");
		}
		
		if(cvCp.getEmail().isBlank()) {
			throw new Exception("Email do Piloto não pode ser Branco ou Nulo!");			
		}
		
	}

}
