package gokart.bo;


import java.util.List;
import gokart.classes.KartodromoBateria;
import gokart.dao.GenericDao;
import gokart.dao.KartodromoBateriaDao;


public class KartodromoBateriaBo {

	public String Salvar(KartodromoBateria kartodromoBateria) throws Exception {


		GenericDao<KartodromoBateria> tcDao = new GenericDao<KartodromoBateria>();

		try {
			return tcDao.saveOrUpdate(kartodromoBateria);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<KartodromoBateria> listarBateria(String nome) 
			throws Exception {
		try {
			return new KartodromoBateriaDao().ProcuraKartodromo(nome);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
