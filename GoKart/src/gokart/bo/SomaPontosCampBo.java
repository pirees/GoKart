package gokart.bo;

import java.util.List;

import gokart.classes.Campeonato;
import gokart.classes.PilotoCampeonato;
import gokart.classes.PontuacaoCampeonato;
import gokart.classes.SomaPontosCamp;
import gokart.dao.GenericDao;
import gokart.dao.SomaPontosCampDao;

public class SomaPontosCampBo {

	public String Salvar(SomaPontosCamp pCp) throws Exception {

		validarDadosGrupo(pCp);

		GenericDao<SomaPontosCamp> pCDao = new GenericDao<SomaPontosCamp>();

		try {
			return pCDao.saveOrUpdate(pCp);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(SomaPontosCamp pCp) throws Exception {

		validarDadosGrupo(pCp);

		GenericDao<SomaPontosCamp> tcDao = new GenericDao<SomaPontosCamp>();

		try {
			return tcDao.remove(SomaPontosCamp.class, 1);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<SomaPontosCamp> listar(Campeonato cp) throws Exception {

		SomaPontosCampDao spcDao = new SomaPontosCampDao();
		return spcDao.listar(cp);

	}

	public List<SomaPontosCamp> listarPiloto(Campeonato cp, PilotoCampeonato pc) throws Exception {

		SomaPontosCampDao spcDao = new SomaPontosCampDao();
		return spcDao.listarPiloto(cp, pc);
	}

	private void validarDadosGrupo(SomaPontosCamp pCp) throws Exception {
		if (pCp.getId() < 0) {
			throw new Exception("Id não pode ser negativo!");
		}
	}

}
