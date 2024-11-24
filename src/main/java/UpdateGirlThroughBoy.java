import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateGirlThroughBoy {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Boy b = em.find(Boy.class, 101);
		if(b!=null) {
			List<Girl> listofgirls =b.getGirls();
			if(listofgirls!=null && !listofgirls.isEmpty()) {
				for(Girl g: listofgirls) {
					if(g.getId()==3) {
						g.setInstaid("dannySona");
						et.begin();
						em.merge(g);
						et.commit();
						System.out.println("record updated successfully");
					}
				}
			}
			else {
				System.out.println("no girl record present to update");
			}
		}
		else {
			System.out.println("boy record not present");
		}
	}

}
