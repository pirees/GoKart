package gokart.teste;


import gokart.classes.Piloto;
import gokart.dao.GenericDao;

public class teste {

	public static void main(String[] args) {
		
		
		Piloto pi = new Piloto();
		
		pi.setNome("Lucas Cordeiro");
		pi.setNivel("Rubinho");
		
		GenericDao<Piloto> gnDao = new GenericDao<Piloto>();
		
		try {
			gnDao.saveOrUpdate(pi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("DeuCerto");
		
		

	}

}
