package gokart.teste;

import gokart.bo.KartodromoBo;
import gokart.classes.Kartodromo;

public class KartomodroTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Kartodromo k = new Kartodromo();
		k.setCidade("Araucária");
		k.setCnpj("456464");
		k.setEndereco("Avenida Vicente Machado");
		k.setEstado("Paraná");
		k.setNome("PiresIndoor");
		k.setSenha("123");
		
		KartodromoBo kBo = new KartodromoBo();
		try {
			String confirmado = kBo.salvar(k);
			System.out.println(confirmado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
