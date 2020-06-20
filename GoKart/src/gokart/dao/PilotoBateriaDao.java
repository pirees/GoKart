package gokart.dao;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import gokart.classes.Piloto;
import gokart.classes.PilotoBateria;

public class PilotoBateriaDao {
	
private static EntityManager em = Fabrica.getEntityManager();	
		
	public List<PilotoBateria> ProcurarReserva(LocalDate data)throws Exception{	

		  Query	a = em.createQuery("select pb from PilotoBateria pb"
					+" inner join pb.bat b"
		            +" where b.data = :data");
			
			a.setParameter("data", data);
					
		return a.getResultList();		
	}
	
	public List<PilotoBateria> CarregarReserva(Piloto piloto)throws Exception{	

		  Query	a = em.createQuery("select pb from PilotoBateria pb"
				    +" where pil_Id = :id");
		  
		  a.setParameter("id", piloto.getId());
					
		return a.getResultList();		
	}

}
