package br.com.alura.unicommerce.Factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {

	public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("unicommerce");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	
}
