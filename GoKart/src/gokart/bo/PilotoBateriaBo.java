package gokart.bo;


import java.time.LocalDate;
import java.util.List;

import gokart.classes.Bateria;
import gokart.classes.Piloto;
import gokart.classes.PilotoBateria;
import gokart.dao.GenericDao;
import gokart.dao.PilotoBateriaDao;

public class PilotoBateriaBo {
	
	public String Salvar(PilotoBateria pilotobateria) throws Exception {
		
		//validarBateria(pilotobateria);
		GenericDao<PilotoBateria> tcDao = new GenericDao<PilotoBateria>();
			
		try {
			
			return tcDao.saveOrUpdate(pilotobateria);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PilotoBateria> bsucarReservas(LocalDate data) throws Exception {		
		return new PilotoBateriaDao().ProcurarReserva(data);
	}
	
	public List<PilotoBateria> carregarReserva(Piloto piloto) throws Exception {		
		return new PilotoBateriaDao().CarregarReserva(piloto);	
	}

	
//	public void validarBateria(PilotoBateria pilotobateria) throws Exception {
//	
//		if(pilotobateria.getPil().getId() == pilotobateria.getPil().getId()) {
//			throw new Exception("Piloto já reservou sua vaga");
//		}
//		
//	}
		
	
}
