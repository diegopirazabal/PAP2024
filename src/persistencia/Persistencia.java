package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Persistencia {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Persistencia() {
        // Crear el EntityManagerFactory utilizando la unidad de persistencia definida en persistence.xml
        emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        // Crear el EntityManager
        em = emf.createEntityManager();
    }

    // Método para iniciar una transacción
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    // Método para confirmar una transacción
    public void commitTransaction() {
        EntityTransaction tx = em.getTransaction();
        if (tx.isActive()) {
            tx.commit();
        }
    }

    // Método para deshacer una transacción
    public void rollbackTransaction() {
        EntityTransaction tx = em.getTransaction();
        if (tx.isActive()) {
            tx.rollback();
        }
    }

    // Método para cerrar el EntityManager y el EntityManagerFactory
    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

    // Obtener el EntityManager para operaciones CRUD
    public EntityManager getEntityManager() {
        return em;
    }
}
