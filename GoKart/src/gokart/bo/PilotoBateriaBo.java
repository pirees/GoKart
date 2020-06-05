package gokart.bo;

import gokart.classes.PilotoBateria;
import gokart.dao.GenericDao;

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
}
