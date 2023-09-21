package br.com.alura.unicommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alura.unicommerce.modelo.Categoria;
import jakarta.persistence.EntityManager;

@Component
public class CategoriaDao implements Dao<Categoria> {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}
	
	public List<Categoria> buscarTodos() {
		String jpql = "SELECT p FROM Categoria p";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	public List<Categoria> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Categoria p WHERE P.nome = :nome";
		return em.createQuery(jpql, Categoria.class)
				.setParameter("nome", nome)
				.getResultList();
	}

	@Override
	public Categoria get(Long id) {
		if (id == null) throw new IllegalArgumentException();
		Categoria encontrado = em.find(Categoria.class, id);
		return encontrado;
	}
	
	
	@Override
	public void save(Categoria t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Categoria t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public void update(Categoria t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}
	
}
