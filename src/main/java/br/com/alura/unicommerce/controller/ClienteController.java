package br.com.alura.unicommerce.controller;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.util.JPAUtil;

public class ClienteController {
	public static void main(String[] args) {

		cadastrarCliente();
	}
	
	private static void cadastrarCliente() {
		EntityManager em = JPAUtil.getEntityManager();

		Cliente ana = new Cliente("ANA", "520.770.180-03", "(81)2868-1314");
		Cliente eli = new Cliente("ELI", "011.308.890-68", "(95)3847-3831");
		Cliente dani = new Cliente("DANI", "131.102.310-00", "(37)3418-8122");
		Cliente bia = new Cliente("BIA", "351.700.140-66", "(98)3364-2143");
		Cliente caio = new Cliente("CAIO", "530.260.510-47", "(55)2177-8561");

		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		clienteDao.cadastrar(ana);
		clienteDao.cadastrar(eli);
		clienteDao.cadastrar(dani);
		clienteDao.cadastrar(bia);
		clienteDao.cadastrar(caio);

		em.getTransaction().commit();
		em.close();
	}

}
