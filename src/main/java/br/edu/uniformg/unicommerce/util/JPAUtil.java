package br.edu.uniformg.unicommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("unicommerce"); //variável constante. Será usada em toda a aplicação
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
