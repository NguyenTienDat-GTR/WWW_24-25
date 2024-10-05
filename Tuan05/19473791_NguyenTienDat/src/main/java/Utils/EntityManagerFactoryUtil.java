package Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerFactoryUtil {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		entityManagerFactory = jakarta.persistence.Persistence.createEntityManagerFactory("QLdienthoai");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
