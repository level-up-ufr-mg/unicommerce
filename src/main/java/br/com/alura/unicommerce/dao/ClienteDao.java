package br.com.alura.unicommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.util.JPAUtil;
import jakarta.persistence.EntityManager;

@Component
public class ClienteDao implements Dao<Cliente> {

	private EntityManager em;

	public ClienteDao() {
		this.em = JPAUtil.getEntityManager();
	}

	@Override
	public void save(Cliente t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Cliente t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Cliente t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public Cliente get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}
	
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT p FROM Cliente p";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Cliente p WHERE P.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nome)
				.getResultList();
	}

}
