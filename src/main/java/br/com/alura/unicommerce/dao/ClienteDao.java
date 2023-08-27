package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void buscaPorId(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void cadastra(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualiza(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remove(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}

	public void listaTodos(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void listaPorNome(Cliente cliente) {
		this.em.persist(cliente);
	}
}