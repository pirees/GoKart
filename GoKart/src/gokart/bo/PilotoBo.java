package gokart.bo;



import gokart.classes.Piloto;
import gokart.dao.GenericDao;
import gokart.dao.PilotoDao;

public class PilotoBo {

	public String Salvar(Piloto piloto) throws Exception {
		
		/*Validações a serem feitas:*/
		validarDadosGrupo(piloto);
		
		//validaCPF(piloto.getCpf());
		

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
	
	/*INCLUIR VALIDAÇÕES AQUI:*/
	private void validarDadosGrupo(Piloto piloto) throws Exception {
		if (piloto.getId() < 0) {
			throw new Exception("Id do Piloto não pode ser negativo!");
		}
		
		if(piloto.getNome().isBlank()) {
			throw new Exception("É necessário inserir um nome");			
		}
		
		if(piloto.getIdade() < 14) {
			throw new Exception("É necessário ser maior de 14 anos para realizar o cadastro");			
		}		
		
		PilotoDao pDao = new PilotoDao();
				
		if(pDao.ValidaCPF(piloto.getCpf()) != null) {
			throw new Exception("CPF já cadastrado no sistema");			
		}
		
		if(pDao.ValidaEmail(piloto.getEmail()) != null) {
			throw new Exception("E-mail já cadastrado no sistema");			
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
		
	public Piloto ProcuraEmail(String email) throws Exception{
		
		if(email.isBlank()) {			
			throw new Exception("Email do Piloto não pode ser Branco.");
		}
		
		Piloto rPiloto;	
		PilotoDao pDao = new PilotoDao();
		rPiloto = pDao.ProcuraEmail(email);
		
		if(rPiloto == null) {
			throw new Exception("Não encontrado Piloto com e-mail informado: " + email);	
		}		
		
		return rPiloto;		
	}
}
