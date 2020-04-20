package gokart.teste;

import gokart.classes.Bateria;
import gokart.classes.Campeonato;
import gokart.classes.Estado;
import gokart.classes.Kartodromo;
import gokart.classes.Piloto;
import gokart.dao.GenericDao;

public class CampeonatoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		                                         //ESTADO TESTE//
		Estado est = new Estado();
		est.setNome("PR");
		
		GenericDao<Estado> estadoBo = new GenericDao<Estado>();
		try {
			estadoBo.saveOrUpdate(est);
			System.out.println("Estado salvo com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		                                          //PILOTO TESTE//
		Piloto piloto = new Piloto();
		piloto.setNome("Leonardo");
		piloto.setCidade("Araucária");
		piloto.setEndereco("Archelau");
		piloto.setEst(est);
		
		GenericDao<Piloto> pilotoBo = new GenericDao<Piloto>();
		try {
			pilotoBo.saveOrUpdate(piloto);
			System.out.println("Piloto salvo com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		                                        //KARTODROMO TESTE//
		Kartodromo kart = new Kartodromo();
		kart.setCnpj(784654654);
		kart.setEndereco("Linha verde");
		kart.setNome("RA KART");
		kart.setEst(est);
		
		GenericDao<Kartodromo> kartBo = new GenericDao<Kartodromo>();
		try {
			kartBo.saveOrUpdate(kart);
			System.out.println("Kartódromo salvo com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		                                         //BATERIA TESTE//
		
		Bateria bat = new Bateria();
		bat.setKart(kart);
		bat.setPil(piloto);
		bat.setData(null);
		
		GenericDao<Bateria> bateriaBo = new GenericDao<Bateria>();
		try {
			bateriaBo.saveOrUpdate(bat);
			System.out.println("Bateria agendada com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		                                       //CAMPEONATO TESTE//
		
		Campeonato camp = new Campeonato();
		camp.setNome("AMIGOS DO KART");
		camp.setPontos(25);
		camp.setBat(bat);
		camp.setKart(kart);
		camp.setPil(piloto);
		
		GenericDao<Campeonato> campeonatoBo = new GenericDao<Campeonato>();
		try {
			campeonatoBo.saveOrUpdate(camp);
			System.out.println("Campeonato criado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
