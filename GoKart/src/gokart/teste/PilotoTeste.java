package gokart.teste;

import gokart.bo.PilotoBo;
import gokart.classes.Piloto;

public class PilotoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Piloto p = new Piloto();
		p.setNome("Leonardo");
		p.setSenha("123");
		p.setApelido("Leona");
		p.setCidade("Araucária");
		p.setIdade(16);
		
		PilotoBo pBo = new PilotoBo();
		try {
			String confirmado = pBo.salvar(p);
			System.out.println(confirmado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
