package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

public class Persistencia {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public Persistencia() {
        // Crear el EntityManagerFactory
        emf = Persistence.createEntityManagerFactory("airelibre.uy");
        // Crear el EntityManager
        em = emf.createEntityManager();
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }

    public void rollbackTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
