package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(Long id) {
		String jpql = "SELECT c FROM Categoria c WHERE c.id = :id";
		return em.createQuery(jpql, Categoria.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public void cadastra(Categoria categoria) { //Feito apenas para mostrar, pois a adição da categoria acontece na adição do produto
		this.em.persist(categoria);
	}

	public List<Categoria> listaTodas() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}


}
