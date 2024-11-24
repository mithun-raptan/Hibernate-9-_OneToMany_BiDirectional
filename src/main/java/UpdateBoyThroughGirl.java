import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateBoyThroughGirl {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query q  =em.createQuery("select g from Girl g");
		List<Girl> listofgirls = q.getResultList();
		if(listofgirls!=null && !listofgirls.isEmpty()) {
			et.begin();
			for(Girl g : listofgirls) {
				if(g.getBoy().getId()==101) {
					g.getBoy().setName("mithunji");
					em.merge(g.getBoy());
					//here also we can write et.begin(); em.merge(g.getBoy()); et.commit();
				}
			}
			et.commit();
			System.out.println("record updated succesfully...");
		}
	}

}
