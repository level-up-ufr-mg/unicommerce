package br.com.alura.unicommerce.funcoes;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCliente {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		cadastraCliente(em);
	}

	private static void cadastraCliente(EntityManager em) {
		Endereco endereco = new Endereco("Rua da Amizade", "123", "Apto 4B", "Centro", "São Paulo", "SP");
		Cliente cliente = new Cliente("Maria do Carmo", "123.456.789", "37 012345-6789", endereco);


		ClienteDao cadastraClienteDao = new ClienteDao(em);
		em.getTransaction().begin();
		cadastraClienteDao.cadastra(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
