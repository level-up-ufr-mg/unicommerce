package br.edu.uniformg.unicommerce.service;

import javax.persistence.EntityManager;

import br.edu.uniformg.unicommerce.dao.ClienteDao;
import br.edu.uniformg.unicommerce.modelo.Categoria;
import br.edu.uniformg.unicommerce.modelo.Cliente;
import br.edu.uniformg.unicommerce.util.JPAUtil;

public class ClienteService {
	
	public static void main (String[] args) {
		
		Cliente cli = new Cliente();
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao cliDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		cliDao.cadastrarCliente(cli);
		em.getTransaction().commit();
		em.close();
	}

}
