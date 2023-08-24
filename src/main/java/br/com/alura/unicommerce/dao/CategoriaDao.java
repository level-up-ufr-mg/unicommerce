package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}

	public List<Categoria> listaTodas() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
}
