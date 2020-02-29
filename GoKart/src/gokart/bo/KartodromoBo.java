package gokart.bo;

import gokart.classes.Kartodromo;
import gokart.dao.KartodromoDao;

public class KartodromoBo {
	
	public String salvar (Kartodromo kart) throws Exception {
		
			if (kart.getCnpj().equals("")) {
				throw new Exception("CNPJ deve ser preenchido");
			}
			
			KartodromoDao kartDao = new KartodromoDao();
			return kartDao.salvar(kart);
		}
	
}
