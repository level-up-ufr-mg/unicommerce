package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public List<Cliente> buscaPorId(Long id) {
		String jpql = "SELECT c FROM Cliente c WHERE c.id = :id";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("id", id)
				.getResultList();
	}

	public void cadastra(Cliente cliente) {
		em.persist(cliente);
	}

	public void atualiza(Cliente cliente) {
		em.merge(cliente);
	}

	public void remove(Cliente cliente) {
		em.remove(cliente);
	}

	public List<Cliente> listaTodos() {
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public List<Cliente> listaPorNome(String nome) {
		String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
