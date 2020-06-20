package gokart.bo;

import java.util.List;

import gokart.classes.BateriaCampeonato;
import gokart.classes.Campeonato;
import gokart.classes.ClassificacaoCampeonato;
import gokart.classes.Piloto;
import gokart.classes.PilotoCampeonato;
import gokart.dao.ClassificacaoCampeonatoDao;
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

	public List<ClassificacaoCampeonato> listarCC(BateriaCampeonato bc, PilotoCampeonato piloto) {

		ClassificacaoCampeonatoDao ccDao = new ClassificacaoCampeonatoDao();
		return ccDao.listarCC(bc, piloto);

	}

	public List<ClassificacaoCampeonato> listar(Campeonato c) {

		ClassificacaoCampeonatoDao ccDao = new ClassificacaoCampeonatoDao();
		return ccDao.listar(c);

	}

	public List<ClassificacaoCampeonato> listarCpBt(Campeonato c, BateriaCampeonato bc) {

		ClassificacaoCampeonatoDao ccDao = new ClassificacaoCampeonatoDao();
		return ccDao.listarCpBt(c, bc);

	}

	private void validarDadosGrupo(ClassificacaoCampeonato cvCp) throws Exception {
		if (cvCp.getId() < 0) {
			throw new Exception("ID do Campeonato não poder ser menor que ZERO.");
		}

		if (cvCp.getPosicao() == 0) {
			throw new Exception("Posição para o piloto " + cvCp.getPil().getPil().getNome() + " não pode ser 0!");
		}

	}

}
