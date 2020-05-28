package gokart.bo;

import java.util.List;

import javax.persistence.Query;

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

	public String deletar(Piloto piloto) throws Exception {
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

	public Piloto ValidaLogin(String email, String senha) throws Exception {
		
		
		if(email.isBlank()) {			
			throw new Exception("Por favor informar um EMAIL válido!");
		}
		
		if(senha.isBlank()) {
			throw new Exception("Por favor informar uma SENHA válida!");			
		}		
		

		Piloto rPiloto;		

		PilotoDao pDao = new PilotoDao();
		rPiloto = pDao.ValidaLogin(email, senha);
		
		if(rPiloto == null) {
			throw new Exception("Usuário ou Senha incorreto(s).");			
		}
		
		return rPiloto;	
	}

}
