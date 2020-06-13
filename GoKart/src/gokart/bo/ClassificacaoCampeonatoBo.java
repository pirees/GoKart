package gokart.bo;

import gokart.classes.ClassificacaoCampeonato;
import gokart.dao.GenericDao;

public class ClassificacaoCampeonatoBo {

	public String Salvar(ClassificacaoCampeonato cp) throws Exception {

		validarDadosGrupo(cp);

		GenericDao<ClassificacaoCampeonato> cpDao = new GenericDao<ClassificacaoCampeonato>();

		try {
			return cpDao.saveOrUpdate(cp);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(ClassificacaoCampeonato cp) throws Exception {

		validarDadosGrupo(cp);
		GenericDao<ClassificacaoCampeonato> cpDao = new GenericDao<ClassificacaoCampeonato>();

		try {
			return cpDao.remove(ClassificacaoCampeonato.class, 1);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void validarDadosGrupo(ClassificacaoCampeonato cvCp) throws Exception {
		if (cvCp.getId() < 0) {
			throw new Exception("ID do Campeonato não poder ser menor que ZERO.");
		}

	}

}
