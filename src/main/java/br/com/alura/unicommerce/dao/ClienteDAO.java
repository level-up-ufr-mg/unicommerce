package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Produto;

public class ClienteDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remover(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}
	
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT p FROM Cliente p";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Cliente p WHERE p.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nome)
				.getResultList();
	}
		
	
}