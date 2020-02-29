package gokart.bo;

import gokart.classes.Piloto;
import gokart.dao.PilotoDao;

public class PilotoBo {
	
	public String salvar(Piloto Piloto) throws Exception {
		
		if (Piloto.getApelido().equals("")) {
			throw new Exception("Apelido não pode estar em branco");
		}		
		if (Piloto.getIdade() < 16) {
			throw new Exception("Idade é apenas para maiores de 16 anos");
		}
		PilotoDao p = new PilotoDao();
		return p.salvar(Piloto);		
	}

}
