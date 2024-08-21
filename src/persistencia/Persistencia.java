package persistencia;
import jakarta.persistence.*;

public class Persistencia {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre.uy");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    //tx.begin();
    //em.persist(usu);
    //tx.commit();
    //em.close();
    //emf.close();
}