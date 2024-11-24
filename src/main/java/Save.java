import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Boy b1 = new Boy();
			b1.setId(101);
			b1.setName("mithun");
			b1.setEmail("m@g.com");
			b1.setPassword("1234");
			b1.setMob(6291);
			b1.setEx("nidhi");
			
		Girl g1 = new Girl();
			 g1.setId(1);
			 g1.setName("sunny");
			 g1.setInstaid("sunny@121");
			 
		Girl g2 = new Girl();
			 g2.setId(2);
			 g2.setName("mia");
			 g2.setInstaid("mia@121");
			 
		Girl g3 = new Girl();
			 g3.setId(3);
			 g3.setName("danny");
			 g3.setInstaid("danny@121");
			 
		List<Girl> listofgirls =  Arrays.asList(g1,g2,g3);
		
		//mapping
		b1.setGirls(listofgirls);
		g1.setBoy(b1);
		g2.setBoy(b1);
		g3.setBoy(b1);
		
		//save/persist
		et.begin();
		em.persist(b1);
		em.persist(g1);
		em.persist(g2);
		em.persist(g3);
		et.commit();
		
		System.out.println("record inserted successfully...");
			
			
			 
			 
			 
		
			
		
		
		
	}

}
