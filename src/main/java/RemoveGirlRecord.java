import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveGirlRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//we can directly remove girl record bcuz there is no other table present where in that table any record is dependent on this girl record.  
		Girl g =em.find(Girl.class, 3);
		et.begin();
		em.remove(g);
		et.commit();
		System.out.println("girl record removed");
	}

}
