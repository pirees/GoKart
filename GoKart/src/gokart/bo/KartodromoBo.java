package gokart.bo;

import gokart.classes.Kartodromo;
import gokart.dao.GenericDao;
import gokart.dao.KartodromoDao;

public class KartodromoBo {
	
	public String Salvar(Kartodromo kartodromo) 
			throws Exception {
		validarDadosGrupo(kartodromo);
		GenericDao<Kartodromo> tcDao = new GenericDao<Kartodromo>();
		try {
			return tcDao.saveOrUpdate(kartodromo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String deletar(Kartodromo kartodromo) 
			throws Exception {
		validarDadosGrupo(kartodromo);
		GenericDao<Kartodromo> tcDao = new GenericDao<Kartodromo>();
		try {
			return tcDao.remove(Kartodromo.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		
	private void validarDadosGrupo(Kartodromo kartodromo) throws Exception {
		if (kartodromo.getId() < 0) {
			throw new Exception("Id da composicao não pode ser negativo!");
		}
	}
	
	public Kartodromo ValidaLogin(String email, String senha) throws Exception {
		
		
		if(email.isBlank()) {			
			throw new Exception("Por favor informar um EMAIL válido!");
		}
		
		if(senha.isBlank()) {
			throw new Exception("Por favor informar uma SENHA válida!");			
		}		
		

		Kartodromo rKartodromo;		

		KartodromoDao kDao = new KartodromoDao();
		rKartodromo = kDao.ValidaLogin(email, senha);
		
		if(rKartodromo == null) {
			throw new Exception("Usuário ou Senha incorreto(s).");			
		}
		
		return rKartodromo;	
	}

}
