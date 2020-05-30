package gokart.bo;

import gokart.classes.KartodromoBateria;
import gokart.dao.GenericDao;

public class KartodromoBateriaBo {

	public String Salvar(KartodromoBateria kartodromoBateria) throws Exception {


		GenericDao<KartodromoBateria> tcDao = new GenericDao<KartodromoBateria>();

		try {
			return tcDao.saveOrUpdate(kartodromoBateria);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
