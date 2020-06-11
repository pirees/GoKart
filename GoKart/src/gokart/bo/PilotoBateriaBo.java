package gokart.bo;


import java.time.LocalDate;
import java.util.List;
import gokart.classes.PilotoBateria;
import gokart.dao.GenericDao;
import gokart.dao.PilotoBateriaDao;

public class PilotoBateriaBo {
	
	public String Salvar(PilotoBateria pilotobateria) 
			throws Exception {
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
}
