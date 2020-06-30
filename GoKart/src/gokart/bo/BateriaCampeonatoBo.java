package gokart.bo;

import java.util.ArrayList;
import java.util.List;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.dao.BateriaCampeonatoDao;
import gokart.dao.GenericDao;

public class BateriaCampeonatoBo {
	
	private List<BateriaCampeonato> qtBat = new ArrayList<BateriaCampeonato>();

	public String Salvar(BateriaCampeonato cp) throws Exception {

		validarDadosGrupo(cp);

		GenericDao<BateriaCampeonato> cpDao = new GenericDao<BateriaCampeonato>();

		try {
			return cpDao.saveOrUpdate(cp);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(BateriaCampeonato cp) throws Exception {

		validarDadosGrupo(cp);
		GenericDao<BateriaCampeonato> cpDao = new GenericDao<BateriaCampeonato>();

		try {
			return cpDao.remove(BateriaCampeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<BateriaCampeonato> listaBateriaCampeonato(Campeonato cp) throws Exception {

		if (!(cp == null)) {
			BateriaCampeonatoDao bcDao = new BateriaCampeonatoDao();
			return bcDao.listaBateriaCp(cp);
		}

		return null;

	}

	private void validarDadosGrupo(BateriaCampeonato btCampeonato) throws Exception {
		if (btCampeonato.getId() < 0) {
			throw new Exception("ID da Bateria x Campeonato n�o poder ser menor que ZERO.");
		}
		
		BateriaCampeonatoBo bcBo = new BateriaCampeonatoBo();		
		qtBat = bcBo.listaBateriaCampeonato(btCampeonato.getId_campeonato());			
		
		if(qtBat.size() == btCampeonato.getId_campeonato().getNrBatCampeonato()) {			
			throw new Exception("Campeonato atingiu n�mero m�ximo de baterias cadastradas!" + " Nr Max:" + btCampeonato.getId_campeonato().getNrBatCampeonato());			
		}
		
	
		

	}

}
