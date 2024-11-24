import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoveBoyRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query q = em.createQuery("select g from Girl g");
		List<Girl> listOfGirls = q.getResultList();

		if (listOfGirls != null && !listOfGirls.isEmpty()) {
			et.begin(); // Start the transaction at the beginning

			for (Girl g : listOfGirls) {
				Boy b = g.getBoy();
				if (b != null && b.getId() == 101) {
					// Dereference the boy from the girl
					g.setBoy(null);
					em.merge(g); // Persist the change to the girl
				}
			}

			// Now safely remove the boy after the girls are updated
			Boy boyToDelete = em.find(Boy.class, 101);
			if (boyToDelete != null) {
				em.remove(boyToDelete); // Remove the boy from the database
				System.out.println("Boy record successfully deleted");
			}

			et.commit(); // Commit the transaction
		} else {
			System.out.println("No girl record present");
		}

	}

}
